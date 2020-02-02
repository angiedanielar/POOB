package Aplicacion;

import java.awt.Rectangle;

/**
 * Crea la sorpresa del juego(hongo, manzana, cereza, cuerda, hongo y martillo)
 */
public abstract class Sorpresa {
	private Posicion posicion;
	private Rectangle hitBox;
	private String name;
	protected boolean visible;
	
	
	/**
	 * Constructor de la sorpresa
	 * @param posi, la posicion de la sorpresa
	 * @param name, el nombre de la sorpresa 
	 */
	public Sorpresa(Posicion posi, String name) {
		posicion= posi;
		visible = true;
		this.name = name;
		hitBox= new Rectangle(posicion.getCordenadas()[0], posicion.getCordenadas()[1],28,28);
	}
	
	/**
	 * El poder que tiene la sorpresa
	 * @player p, el jugador al cual se le aplica el efecto
	 */
	public abstract void efecto(Player p);
	
	/**
	 * Devuelve el rectangulo de la sopresa actual
	 * @return hitBox, el rectangulo a devolver
	 */
	public Rectangle getHitBox() {
		return hitBox;
	}
	
	/**
	 * Devuelve si se intersecta la sorpresa con algun otro rectangulo 
	 * @return intersecta, si se intersecta o no
	 */
	public boolean intersecta(Rectangle r) {
		return hitBox.intersects(r);
	}

	/**
	 * Devuelve el nombre de la sopresa
	 * @return name, el nombre a devolver 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Hace visible o invisible a la sorpresa 
	 */
	public void setVisible(boolean v){
		visible = v;
	}
	
	/**
	 * Dice si la sorpresa actual esta visible o no
	 * @return visible, devuelve si la sorpresa es visible
	 */
	public boolean isVisible() {
		return visible;
	}

}































