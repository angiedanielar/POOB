package Aplicacion;

/**
 * Crea la sorpresa Martillo del juego
 */
public class Martillo extends Sorpresa {
	
	/**
	 * Constructor de la sorpresa Martillo
	 * @param posi, la posicion del martillo
	 * @param name, el spirte del martillo
	 */
	public Martillo(Posicion posi, String root) {
		super(posi,"martillo");
	}
	
	/**
	 * El poder que tiene la sorpresa: Permite destruir barriles por cierto tiempo
	 * @player p, el jugador al cual se le aplica el efecto
	 * NO LO LOGRAMOS IMPLEMENTAR
	 */
	public void efecto(Player p) {
	}
}
