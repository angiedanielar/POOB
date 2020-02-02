package Aplicacion;

/**
 * Crea la sorpresa Cereza del juego
 */
public class Cereza extends Sorpresa {
	
	/**
	 * Constructor de la sorpresa Cereza
	 * @param posi, la posicion de la cereza
	 * @param name, el spirte de la cereza 
	 */
	public Cereza(Posicion posi, String root) {
		super(posi,"cereza");
	}
	
	/**
	 * El poder que tiene la sorpresa: Da diez puntos
	 * @player p, el jugador al cual se le aplica el efecto
	 */
	public void efecto(Player p) {
		if(isVisible()) {
			p.sumeScore(10);
			setVisible(false);
		}
	}
}
