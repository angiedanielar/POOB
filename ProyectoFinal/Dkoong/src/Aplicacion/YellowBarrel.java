package Aplicacion;

import java.util.List;

/**
 * Crea el barril amarillo del Juego 
 */
public class YellowBarrel extends Barrel {

	/**
	 * Constructor del Yellow Barrel
	 * @param posi, la posicion del barril amarillo
	 * @param points, los puntos del barril amarillo
	 * @param root, el sprite del barril amarillo
	 */
	public YellowBarrel(Posicion posi, String root) {
		super(posi,10,"barrilamarillo1");
	}
	
	/**
	 * Mueve el barril amarillo, no le permite bajar nigun tipo de escaleras y se le
	 * permite rodar segun el tipo de plataforma sobre la cual este, y caiga cuando 
	 * no haya por donde moverse.
	 * @param plataformas, la lista actual de las plataformas del tablero
	 * @param escaleras, la lista actual de las escaleras del tablero 
	 */
	@Override
	public void move(List<Platform> plataformas, List<Stair> escaleras) {
		while (movimiento){
			for(Platform plat: plataformas) {
				if (plat.getTipo()==1 && plat.intersecta(super.getHitBox())) {
					moveRigth();
				}
				else if(plat.getTipo()==2 && plat.intersecta(super.getHitBox())) {
					moveLeft();
				}
				else {
					moveDown();
				}
			}
		}
	}
	
	/**
	 * Mueve el barril amarillo a la derecha 
	 */
	public void moveRigth() {
		int[] valores= posicion.getCordenadas();
		int temporal= valores[0]+2;
		changePosition(temporal,valores[1]);	
	}
	
	/**
	 * Mueve el barril amarillo a la izquierda 
	 */
	public void moveLeft() {
		int[] valores= posicion.getCordenadas();
		int temporal= valores[0]-2;
		changePosition(temporal,valores[1]);
	}
	
	/**
	 * Mueve el barril amarillo hacia abajo
	 */
	public void moveDown() {
		int[] valores= posicion.getCordenadas();
		int temporal= valores[1]+2;
		changePosition(valores[0], temporal);
	}
	
	/**
	 * El efecto del barril amarillo: quitarle una vida al jugador 
	 */
	@Override
	public void efecto(Player p) {
		p.resteVida();
	}
}
