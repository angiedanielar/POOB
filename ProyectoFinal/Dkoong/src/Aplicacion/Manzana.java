package Aplicacion;

/**
 * Crea la sorpresa Manzana del juego
 */
public class Manzana extends Sorpresa {
	
	/**
	 * Constructor de la sorpresa Manzana
	 * @param posi, la posicion de la manzana
	 * @param name, el spirte de la manzana 
	 */
	public Manzana(Posicion posi, String root) {
		super(posi,"manzana");
	}
	
	/**
	 * El poder que tiene la sorpresa: Da cinco puntos
	 * @player p, el jugador al cual se le aplica el efecto
	 */
	public void efecto(Player p) {
		if(isVisible()) {
			p.sumeScore(5);
			setVisible(false);
		}
	}
}
