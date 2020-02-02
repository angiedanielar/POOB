package Aplicacion;

import java.util.List;

/**
 * Crea el barril rojo del Juego 
 */
public class RedBarrel extends Barrel {

	/**
	 * Constructor del Red Barrel
	 * @param posi, la posicion del barril rojo
	 * @param points, los puntos del barril rojo
	 * @param root, el sprite del barril rojo
	 */
	public RedBarrel(Posicion posi, String root) {
		super(posi,30,root);
	}
	
	/**
	 * Mueve el barril rojo hacia abajo, sin importar las escaleras, ni las plataformas
	 * @param plataformas, la lista actual de las plataformas del tablero
	 * @param escaleras, la lista actual de las escaleras del tablero 
	 */
	@Override
	public void move(List<Platform> plataformas, List<Stair> escaleras) {
		moveDown();
	}
	
	/**
	 * Mueve el barril rojo hacia abajo
	 */
	public void moveDown() {
		int[] valores= posicion.getCordenadas();
		int temporal= valores[1]+2;
		changePosition(valores[0], temporal);
	}
	
	/**
	 * El efecto del barril rojo: quitarle una vida al jugador 
	 */
	@Override
	public void efecto(Player p) {
		p.resteVida();
	}
}
