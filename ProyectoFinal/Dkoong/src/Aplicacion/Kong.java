package Aplicacion;

import java.io.Serializable;

/**
 * Crea el mono del Juego 
 */
public class Kong {
	private Posicion posicion;
	private String sprite;
	private String root;
	
	
	/**
	 * Constructor del Kong
	 * @param posi, la posicion del mono
	 * @param root, el sprite del mono
	 */
	public Kong(Posicion posi, String root) {
		posicion= posi;
		this.root = root;
	}
	
	/**
	 * Obiene la poscion del mono
	 * @return posicion, devuelve la posicion del Kong
	 */
	public Posicion getPosicion() {
		return posicion;
	}

}
