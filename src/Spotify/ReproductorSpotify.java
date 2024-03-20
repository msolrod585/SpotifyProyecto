package Spotify;

import java.util.Scanner;

/**
 * Clase Reproductor de Spotify, el cual representa la interfaz de la pagina, en
 * ella se encuentra definido el main
 */
public class ReproductorSpotify {

	public static void main(String[] args) {
		/**
		 * Variable Scanner que permite la lectura de datos por teclado
		 */
		var sc = new Scanner(System.in);
		/**
		 * Lista de Usuarios registrados en Spotify
		 */
		Cuenta[] ListaUsuarios = new Cuenta[10000];
		/**
		 * Lista de Canciones registradas en la aplicacion
		 */
		Cancion[] CancionesSpotify = new Cancion[100000];
		/**
		 * Variable de referencia para el trabajo con arrays
		 */
		int posCuentaActual = -1;
		/**
		 * Variable de referencia para el trabajo con arrays
		 */

		int posCancionActual = -1;
		Cancion[] Favoritos = new Cancion[10];
		EnBucle EnRepeticion = new EnBucle();
		Personalizada[] Personal = new Personalizada[30];

		CancionesSpotify[0] = new Cancion("4a8594g82", 414085612, "Blinding Lights", "After Hours", "The Weeknd",
				false);
		CancionesSpotify[1] = new Cancion("298495629", 65079600, "Free Bird", "Pronounced", "Lynyrd Skynyrd", false);
		CancionesSpotify[2] = new Cancion("548964665", 70984301, "Dirty Diana", "BAD", "Michael Jackson", false);
		CancionesSpotify[3] = new Cancion("316468535", 30056700, "Bring Me To Life", "Fallen", "Evanescence", false);
		CancionesSpotify[4] = new Cancion("355487899", 314085600, "Starboy", "Starboy", "The Weeknd", false);
		CancionesSpotify[5] = new Cancion("187995586", 50087364, "Warriors", "Smoke + Mirrors", "Imagine Dragons",
				false);
		CancionesSpotify[6] = new Cancion("865775620", 80225698, "No time to die", "No time to die", "Billie Eilish",
				false);
		CancionesSpotify[7] = new Cancion("656698721", 98140856, "Sweet Child O' Mine", "Appetite For Destruction",
				"Guns N' Roses", false);
		CancionesSpotify[8] = new Cancion("190234532", 115326184, "THE DEATH OF PEACE OF MIND",
				"THE DEATH OF PIECE OF MIND", "Bad Omens", false);
		CancionesSpotify[9] = new Cancion("498594862", 797982433, "Moth to a Flame", "PARADISE AGAIN",
				"Swedish House Mafia + The Weeknd", false);

		ListaUsuarios[0] = new Cuenta("msolrod", "29379gw09");
		ListaUsuarios[1] = new Cuenta("jrodlop", "123456799");
		/**
		 * Esta variable nos permite saber si la sesion esta iniciada o cerrada
		 */
		boolean sesionIniciada = false;
		System.out.println("¡Bienvenido a Spotify, su página de reproduccion de música favorita!");
		System.out
				.println("Antes de empezar a reproducir, Inicie Sesión y si no tiene una cuenta...¡Creemos una nueva!");
		System.out.println("1. Iniciar Sesion\r\n" + "2.Crear Cuenta Spotify\r\n" + "");
		int primerOpcion = sc.nextInt();
		/**
		 * Este switch nos abre el primer menú para iniciar sesion o registrarnos
		 */
		switch (primerOpcion) {
		case 1:
			int posicionUsuario = buscarUsuario(ListaUsuarios);
			if (posicionUsuario >= 0) {
				sesionIniciada = true;
				posCuentaActual = posicionUsuario;
				System.out.println("Sesion iniciada correctamente.");
			} else {
				System.out.println("El nombre de Usuario o la contraseña son incorrectos");
			}
			break;
		case 2:
			posicionUsuario = crearCuenta(ListaUsuarios);
			sesionIniciada = true;
			posCuentaActual = posicionUsuario;
			break;
		default:
			System.out.println("Error en la selección");
			posCuentaActual = -1;
			sesionIniciada = false;
			break;
		}

		if (sesionIniciada) {
			int opcion2 = 0;
			do {
				System.out.println("");
				System.out.println("1. Apartado Playlist\r\n" + "2. Reproducir canción\r\n" + "3. Pasarte a Premium\r\n"
						+ "4. Salir\r\n" + "");
				opcion2 = sc.nextInt();
				/**
				 * Una vez la sesion este iniciada podemos acceder al siguiente menu, en el cual
				 * se nos pregunta sobre que quieremos hacer
				 */
				switch (opcion2) {

				case 1:
					System.out.println("Menú de Playlists");
					System.out.println("1. Reproducir Playlist \r\n" + "2. Borrar Playlist\r\n"
							+ "3. Editar Playlist\r\n" + "4. Crear Playlist\r\n" + "5. Salir\r\n" + "");
					int opcion3 = sc.nextInt();
					do {
						/**
						 * Si accedemos a la primera opcion, se abrirá un menú exclusivo para el trabajo
						 * con Playlists
						 */
						switch (opcion3) {
						case 1:
							System.out.println("¿Que tipo de Playlist quiere reproducir?");
							System.out.println(
									"1.Favoritos \r\n" + "2. Más Reproducidos\r\n" + "3. Personalizada\r\n" + "");
							int opcion4 = sc.nextInt();
							switch (opcion4) {
							case 1:
								listarFavoritos(CancionesSpotify);
								break;
							case 2:
								reproducirEnBucle(CancionesSpotify);
								break;
							case 3:
								reproducirPlaylist(Personal);
								break;
							default:
								System.out.println("Opcion Incorrecta");
							}
							break;
						case 2:
							borrarPersonalizada(Personal);
							break;
						case 3:
							Personalizada personal = new Personalizada();
							personal.editarPlaylist(buscarPlaylist(Personal));
							break;
						case 4:
							agregarPersonalizada(Personal);
							break;
						default:
							System.out.println("Opcion Incorrecta");
							break;
						}
					} while (opcion3 != 5);
				case 2:
					reproducirCancion(CancionesSpotify);
					break;

				case 3:
					ListaUsuarios[posCuentaActual].premium();
					break;
				default:
					System.out.println("Opcion incorrecta");
					break;
				}

			} while (opcion2 != 4);

		} else {
			System.out.println("¡Intente conectarse a Spotify más tarde!");

		}

	}

	/**
	 * Crear Cuenta es una funcion para Registrarse
	 * 
	 * @param Usuarios
	 * @return
	 */
	public static int crearCuenta(Cuenta[] Usuarios) {
		var sc = new Scanner(System.in);
		int posicion = -1;
		do {
			posicion++;
		} while (!((Usuarios[posicion] == null)));
		System.out.println("Introduzca el nombre de Usuario: ");
		String nombre = sc.nextLine();
		System.out.println("Introduzca la contraseña: ");
		String contrasenia = sc.nextLine();
		Usuarios[posicion] = new Cuenta(nombre, contrasenia);
		System.out.println("!La cuenta se ha creado exitosamente!");
		return posicion;
	}

	/**
	 * Localiza un Usuario en la lista de usuarios de Spotify
	 * 
	 * @param Usuarios
	 * @return
	 */
	public static int buscarUsuario(Cuenta[] Usuarios) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre de Usuario: ");
		String nomUser = sc.nextLine();
		System.out.println("Introduzca la contraseña: ");
		String contr = sc.nextLine();
		if (!(nomUser.equals("") || contr.equals(""))) {
			for (int i = 0; i < Usuarios.length; i++) {
				if ((Usuarios[i].getContrasenia()).equals(contr) && (Usuarios[i].getNomUsuario()).equals(nomUser))
					return i;
			}
		}
		return -1;
	}

	/**
	 * Busca canciones en las canciones registradas de Spotify
	 * 
	 * @param Canciones
	 * @return
	 */
	public static int buscarCancion(Cancion[] Canciones) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre de la cancion: ");
		String nomCancion = sc.nextLine();
		if (!nomCancion.equals("")) {
			for (int i = 0; i < Canciones.length; i++) {
				if ((Canciones[i].getNombre()).equals(nomCancion))
					return i;
			}
		}
		return -1;
	}

	/**
	 * Reproduce una cancion introducida por teclado
	 * 
	 * @param Canciones
	 */
	public static void reproducirCancion(Cancion[] Canciones) {
		int posicion = buscarCancion(Canciones);
		if (posicion != -1) {
			System.out.println("Now playing: " + Canciones[posicion].getNombre());
			Canciones[posicion].like();
		}
	}

	/**
	 * Agrega las canciones a la lista bucle
	 * 
	 * @param canciones
	 */
	public static void agregarEnBucle(Cancion[] canciones) {
		boolean orden;
		do {
			orden = false;
			for (int i = 1; i < canciones.length; i++) {
				if (!(canciones[i] == null)
						&& canciones[i - 1].getNumReproducciones() < canciones[i].getNumReproducciones()) {
					Cancion temp = canciones[i - 1];
					canciones[i - 1] = canciones[i];
					canciones[i] = temp;
					orden = true;
				}
			}
		} while (orden);
	}

	/**
	 * Reproduce la playlist bucle
	 * 
	 * @param canciones
	 */
	public static void reproducirEnBucle(Cancion[] canciones) {
		agregarEnBucle(canciones);
		System.out.println("Lista de las más reproducidas: ");
		System.out.println("-------------------------------");
		for (Cancion cancion : canciones) {
			if (!(cancion == null)) {
				System.out.println(cancion.getNombre() + " - Reproducciones: " + cancion.getNumReproducciones());
			}
		}
		System.out.println("-------------------------------");
	}

	/**
	 * Crea una lista personalizada
	 * 
	 * @param playPersonalizada
	 */
	public static void agregarPersonalizada(Personalizada[] playPersonalizada) {
		var sc = new Scanner(System.in);
		int primeraLibre = -1;
		for (int i = 0; i < playPersonalizada.length; i++) {
			if (playPersonalizada[i] == null) {
				primeraLibre = i;
				break;
			}
		}
		if (primeraLibre != -1) {
			System.out.println("Introduzca el nombre de la nueva Playlist:");
			String nombre = sc.nextLine();
			Personalizada nuevaPlaylist = new Personalizada(nombre);
			playPersonalizada[primeraLibre] = nuevaPlaylist;
			System.out.println("Se ha añadido la nueva playlist correctamente.");
		} else {
			System.out.println("No hay espacio disponible para añadir más playlists.");
		}

	}

	/**
	 * Borra una lista personalizada
	 * 
	 * @param playPersonalizada
	 */
	public static void borrarPersonalizada(Personalizada[] playPersonalizada) {
		var sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre de la Playlist a borrar:");
		String nombre = sc.nextLine();
		boolean encontrado = false;
		for (int i = 0; i < playPersonalizada.length; i++) {
			if (playPersonalizada[i] != null && playPersonalizada[i].getNombre().equals(nombre)) {
				playPersonalizada[i] = null;
				encontrado = true;
				System.out.println("Se ha borrado la Playlist \"" + nombre + "\" correctamente.");
				break;
			}
		}
		if (!encontrado) {
			System.out.println("La Playlist \"" + nombre + "\" no se encontró en la lista.");
		}
	}

	/**
	 * busca una playlist en la lista
	 * 
	 * @param personal
	 * @return
	 */
	public static int buscarPlaylist(Personalizada[] personal) {
		var sc = new Scanner(System.in);
		System.out.println("Introduce el nombre de la playlist que quieres buscar: ");
		String nomCancion = sc.nextLine();
		if (!nomCancion.equals("")) {
			for (int i = 0; i < personal.length; i++) {
				if ((personal[i].getNombre()).equals(nomCancion))
					System.out.println("Se ha encontrado la playlist");
				return i;
			}
		}
		return -1;
	}

	/**
	 * Reproduce una playlist
	 * 
	 * @param personal
	 */
	public static void reproducirPlaylist(Personalizada[] personal) {
		int posicion = buscarPlaylist(personal);
		if (posicion != -1) {
			System.out.println("Now playing playlist: " + personal[posicion].getNombre());
		}
	}

	/**
	 * Muestra las canciones que cumplan la condicion de favoritos
	 * 
	 * @param favoritos
	 */
	public static void listarFavoritos(Cancion[] favoritos) {
		int longitud = favoritos.length;
		for (int i = 0; i < favoritos.length; i++) {
			if (!(favoritos[i] == null) && (favoritos[i].isMeGusta())) {
				System.out.println(favoritos[i].toString());
			}
		}

	}

}