package Spotify;

import java.util.Scanner;

/**
 * Clase Cancion, que implemamta la interfaz Like
 */
public class Cancion implements Like {
	/**
	 * Definicion de atributos de la clase Codiigo de la cancion
	 */
	private String codCancion = "LIBRE";
	/**
	 * Numero de reproducciones de la cancion
	 */
	private int numReproducciones;
	/**
	 * Nombre de la cancion
	 */
	private String nombre;
	/**
	 * Album al que pertenece
	 */
	private String Album;
	/**
	 * Autor de la cancion
	 */
	private String autor;
	/**
	 * La cancion tiene me gusta o no
	 */
	private boolean meGusta = false;
	/**
	 * Constructor por defecto
	 */
	
	public Cancion() {

	}
	
	public Cancion(String nombre) {
		this.nombre=nombre;
	}

	/**
	 * Constructor de la clase con todos los atributos heredados y de clase
	 * 
	 * @param codCancion
	 * @param numReproducciones
	 * @param nombre
	 * @param album
	 * @param autor
	 */
	public Cancion(String codCancion, int numReproducciones, String nombre, String album, String autor, boolean meGusta) {
		super();
		this.codCancion = codCancion;
		this.numReproducciones = numReproducciones;
		this.nombre = nombre;
		Album = album;
		this.autor = autor;
		this.meGusta=meGusta;
	}

	/**
	 * Getters y Setters
	 */
	public String getCodCancion() {
		return codCancion;
	}

	public void setCODCancion(String codCancion) {
		this.codCancion = codCancion;
	}

	public int getNumReproducciones() {
		return numReproducciones;
	}

	public void setNumReproducciones(int numReproducciones) {
		this.numReproducciones = numReproducciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlbum() {
		return Album;
	}

	public void setAlbum(String album) {
		Album = album;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	public boolean isMeGusta() {
		return meGusta;
	}

	public void setMeGusta(boolean meGusta) {
		this.meGusta = meGusta;
	}

	@Override
	public String toString() {
		return "Cancion [nombre=" + nombre + ", Album=" + Album + ", autor=" + autor + "]";
	}

	public void setCodCancion(String codCancion) {
		this.codCancion = codCancion;
	}

	/**
	 * Funcion de la interfaz implementada
	 */
	@Override
	public boolean like() {
		var sc = new Scanner(System.in);
		boolean like = false;
		while (true) {
			System.out.println("¿Le ha gustado la canción? (S/N)");
			char opc = sc.next().charAt(0);
			if (opc == 'S' || opc == 's') {
				like = true;
				System.out.println("Se ha añadido la canción a tus favoritos.");
				setMeGusta(like);
				break;
			} else if (opc == 'N' || opc == 'n') {
				like = false;
				setMeGusta(like);
				System.out.println("No se ha añadido la canción a tus favoritos.");
				break;
			} else {
				System.out.println("Opción no válida. Inténtalo de nuevo.");
			}
		}return like;
	}	
}
