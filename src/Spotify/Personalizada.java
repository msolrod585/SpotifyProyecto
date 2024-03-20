package Spotify;

import java.util.Scanner;

/**
 * La clase Personalizada extiende a Playlist
 */
public class Personalizada extends Playlist {
	/**
	 * Definicion de atributos de la clase Nombre de la Playist Personalizada
	 */
	private String nombre;
	/**
	 * Array de Canciones de la clase Playlist
	 */
	private Cancion[] Canciones = new Cancion[100];

	/**
	 * COntructor por defecto
	 */
	public Personalizada() {
		super();
	}

	/**
	 * Constructor en el cual solo se pide el nombre
	 * 
	 * @param nombre
	 */
	public Personalizada(String nombre) {
		super();
		this.nombre = nombre;
	}

	/**
	 * Constructor con todos los atributos de clase y heredados
	 * 
	 * @param tiempoTotalReproduccion
	 * @param numCanciones
	 */
	public Personalizada(int tiempoTotalReproduccion, int numCanciones) {
		super(tiempoTotalReproduccion, numCanciones);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cancion[] getCanciones() {
		return Canciones;
	}

	public void setCanciones(Cancion[] canciones) {
		Canciones = canciones;
	}

	public void editarPlaylist(int numPlaylist) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el número de canciones que deseas añadir a la playlist " + numPlaylist + ":");
		int numCanciones = scanner.nextInt();
		scanner.nextLine(); 
		Cancion[] nuevasCanciones = new Cancion[numCanciones];
		for (int i = 0; i < numCanciones; i++) {
			System.out.println("Introduce el nombre de la canción " + (i + 1) + ":");
			String nombreCancion = scanner.nextLine();
			nuevasCanciones[i] = new Cancion(nombreCancion);
		}
		this.setCanciones(nuevasCanciones);

		System.out.println("Playlist " + numPlaylist + " editada correctamente.");
	}

}
