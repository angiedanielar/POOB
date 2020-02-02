package Aplicacion;

/**
 * Crea la escalera normal del juego
 */
public class NormalStair extends Stair {

	/**
	 * Constructor de la escalera NORMAL
	 * @param abajoInicial, la posicion de abajo inicial de la escalera
	 * @param abajoFinal, la posicion de abajo final de la escalera
	 * @param arribaInicial, la posicion de arribal inicial de la escalera
	 * @param arribaFinal, la posicion de arribal final de la escalera
	 */
	public NormalStair(Posicion abajoInicial, Posicion abajoFinal, Posicion arribaInicial, Posicion arribaFinal) {
		super(abajoInicial, abajoFinal, arribaInicial, arribaFinal);
		setBroken(false);
	}

}
