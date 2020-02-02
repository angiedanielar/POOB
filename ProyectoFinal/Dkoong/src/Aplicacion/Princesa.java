package Aplicacion;

import java.awt.Rectangle;

/**
 * Crea la princesa del juego
 */
public class Princesa {
	private Posicion posicion;
	private String color;
	private Rectangle hitBox;

	/**
	* Constructor de la princesa
	* @param posi, la posicion de la princesa
	* @param color, el color(nombre) de la princesa
	*/
	public Princesa(Posicion posi, String color) {
		posicion= posi;
		this.color= color;
		hitBox= new Rectangle(posicion.getCordenadas()[0], posicion.getCordenadas()[1]);
	}
		
	/**
	* retrona la posicion de la princesa
	* @return posicion, devuelve la posicion actual de la princesa
	*/
	public Posicion getPosicion() {
		return posicion;
	}

	/**
	 * Obtiene el rectangulo de la princesa
	 * @return hitBox, el rectangulo a devolver
	 */
	public Rectangle getHitBox() {
		return hitBox;
	}

	/**
	 * Mira si se intersecta la princesa con algun otro rectangulo
	 * @param r, el rectangulo a mirar 
	 * @return intersecta, si se intersecta o no
	 */
	public boolean intersecta(Rectangle r) {
		return hitBox.intersects(r);
	}
}