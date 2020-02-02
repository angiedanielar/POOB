package Aplicacion;

/**
 * Crea la sorpresa Hongo del juego
 */
public class Hongo extends Sorpresa {
	
	/**
	 * Constructor de la sorpresa Hongo
	 * @param posi, la posicion del hongo
	 * @param name, el spirte del hongo 
	 */
	public Hongo(Posicion posi, String root) {
		super(posi,"hongo");
	}
	
	/**
	 * El poder que tiene la sorpresa: Invierte los controles del jugador
	 * @player p, el jugador al cual se le aplica el efecto
	 */
	public void efecto(Player p) {
		if(isVisible()) {
			p.setInvertido();
			setVisible(false);
		}		
	}
}
