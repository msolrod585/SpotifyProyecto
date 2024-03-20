package Spotify;

import java.util.Scanner;

/**
 * Clase Cuenta que implemtente la opcion Premium
 */
public class Cuenta implements Premium {
	/**
	 * Definicion de atributos de la clase estado de la Cuenta
	 */
	private String estadoCuenta = "NULL";
	/**
	 * Nombre de usuario
	 */
	private String nomUsuario;
	/**
	 * Contrasenia de la cuenta
	 */
	private String contrasenia;
	/**
	 * Minutos reproducidos en total
	 */
	private Double minutosReproducidos;
	/**
	 * Numero de playlist
	 */
	private int numPlaylist;
	/**
	 * Playlists Personalizadas
	 */
	private Personalizada[] playPersonalizada = new Personalizada[30];

	/**
	 * Contructor por defecto de la clase Cuenta
	 */
	public Cuenta() {

	}

	/**
	 * Contructor con unicos parametros nomUsuario y Contrasenia
	 * 
	 * @param nomUsuario
	 * @param contrasenia
	 */
	public Cuenta(String nomUsuario, String contrasenia) {
		this.nomUsuario = nomUsuario;
		this.contrasenia = contrasenia;
		this.estadoCuenta = "CREADA";
		this.minutosReproducidos = 0.;
		this.numPlaylist = 0;
	}

	/**
	 * Contructor de la clase con todos sus atributos
	 * 
	 * @param estadoCuenta
	 * @param nomUsuario
	 * @param contrasenia
	 * @param minutosReproducidos
	 * @param numPlaylist
	 */
	public Cuenta(String estadoCuenta, String nomUsuario, String contrasenia, Double minutosReproducidos,
			int numPlaylist) {
		this.estadoCuenta = estadoCuenta;
		this.nomUsuario = nomUsuario;
		this.contrasenia = contrasenia;
		this.minutosReproducidos = minutosReproducidos;
		this.numPlaylist = numPlaylist;

	}

	/**
	 * Getters y Setters
	 */
	public String getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setIdCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public Double getMinutosReproducidos() {
		return minutosReproducidos;
	}

	public void setMinutosReproducidos(Double minutosReproducidos) {
		this.minutosReproducidos = minutosReproducidos;
	}

	public int getNumPlaylist() {
		return numPlaylist;
	}

	public void setNumPlaylist(int numPlaylist) {
		this.numPlaylist = numPlaylist;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}
	
	

	@Override
	/**
	 * Funcion de la interfaz implementada Premium
	 */
	public boolean premium() {
		var sc = new Scanner(System.in);
		boolean premium = false;
		System.out.println("Bienvenido al sistema de suscripcion Premium.");
		System.out.println("Si se pasa a Premium, podrá disfrutar de música sin interrupciones");
		System.out.println("¿Pasarse a premium? (S/N)");
		char resp = sc.next().charAt(0);
		if (resp == 'S') {
			premium = true;
			System.out.println("Enhorabuena! Ahora puedes escuchar musica sin publicidad");
		} else if (resp == 'N') {
			premium = false;
			System.out.println("Disfruta de esta pequeña pausa publicitaria");
			System.out.println("Con la boca abierta nos quedamos el día que descubrimos que si bajabas demasiado el volumen de un anuncio de Spotify\n"
					+ ", el anuncio pasaba a modo «pause» y hasta que no terminaba no podías seguir escuchando música.\n"
					+ " Pero con la boca más abierta todavía nos hemos quedado al escuchar un anuncio que se burla de esta situación y de los molestos anuncios que suenan en Spotify.\n"
					+ " Se trata de un producto de nombre también muy alternativo: el Angry Whooper. Hacen una analogía entre el nombre de la hamburguesa\n"
					+ " y el cabreo de tener que escuchar anuncios. Un hurra por ellos.");
		} else {
			System.out.println("Opcion Incorrecta");
		}

		return premium;
	}

	

}
