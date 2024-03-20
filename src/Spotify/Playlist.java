package Spotify;
/**
 * Clase Playlist
 */
public class Playlist {
	/**
	 * Creacion de atributos de la clase Playlist
	 * Tiempo total de Reproduccion
	 */
	protected int tiempoTotalReproduccion;
	/**
	 * 
	 */
	protected int numCanciones;
	
	
	/**
	 * Constructor defecto de la clase
	 */
	public Playlist() {
		
	}
	/**
	 * Constructor de la clase con todos sus atributos
	 * @param tiempoTotalReproduccion
	 * @param numCanciones
	 */
	public Playlist(int tiempoTotalReproduccion, int numCanciones) {
		super();
		this.tiempoTotalReproduccion = tiempoTotalReproduccion;
		this.numCanciones = numCanciones;
	}
	/**
	 * Getters y Setters
	 */
	public int getTiempoTotalReproduccion() {
		return tiempoTotalReproduccion;
	}

	public void setTiempoTotalReproduccion(int tiempoTotalReproduccion) {
		this.tiempoTotalReproduccion = tiempoTotalReproduccion;
	}

	public int getNumCanciones() {
		return numCanciones;
	}

	public void setNumCanciones(int numCanciones) {
		this.numCanciones = numCanciones;
	}


	
	
	
	

}
