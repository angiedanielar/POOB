package Aplicacion;

/**
 * Crea la sorpresa Corazon del juego
 */
public class Corazon extends Sorpresa {
	
	/**
	 * Constructor de la sorpresa Corazon
	 * @param posi, la posicion del corazon 
	 * @param name, el spirte del corazon 
	 */
	public Corazon(Posicion posi, String root) {
		super(posi,"corazon");
	}
	
	/**
	 * El poder que tiene la sorpresa: Da una vida
	 * @player p, el jugador al cual se le aplica el efecto
	 */
	public void efecto(Player p) {
		if(isVisible()) {
			p.sumeVida();
			setVisible(false);
		}		
	}
}
