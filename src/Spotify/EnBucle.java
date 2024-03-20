package Spotify;
/**
 * Clase que extiende a Playlist y permite realizar una Playlist con las canciones mas escuchadas
 */
public class EnBucle extends Playlist {
	/**
	 * Definicion de atributos de la clase
	 * Nombre predeterminado
	 */
	private String nombre = "En Bucle";
	/**
	 * Array de canciones que pertenece
	 */
	private Cancion[] enBucle = new Cancion[100];
	/**
	 * Constructor por defecto de la clase
	 */
	public EnBucle() {
		super();
	}
	/**
	 * Constructor con atributos heredados
	 * @param tiempoTotalReproduccion
	 * @param numCanciones
	 */
	public EnBucle(int tiempoTotalReproduccion, int numCanciones) {
		super(tiempoTotalReproduccion, numCanciones);
	}	
}
