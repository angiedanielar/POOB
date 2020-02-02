package Aplicacion;

import java.util.List;

/**
 * Crea el barril verde del Juego 
 */
public class GreenBarrel extends Barrel {

	/**
	 * Constructor del Green Barrel
	 * @param posi, la posicion del barril verde
	 * @param points, los puntos del barril verde
	 * @param root, el sprite del barril verde
	 */
	public GreenBarrel(Posicion posi, String root) {
		super(posi,0,"barrilverde1");
	}
	
	/**
	 * Mueve el barril verde, no le permite bajar nigun tipo de escaleras y se le
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
	 * Mueve el barril verde a la derecha 
	 */
	public void moveRigth() {
		int[] valores= posicion.getCordenadas();
		int temporal= valores[0]+2;
		changePosition(temporal,valores[1]);	
	}
	
	/**
	 * Mueve el barril verde a la izquierda 
	 */
	public void moveLeft() {
		int[] valores= posicion.getCordenadas();
		int temporal= valores[0]-2;
		changePosition(temporal,valores[1]);
	}
	
	/**
	 * Mueve el barril verde hacia abajo
	 */
	public void moveDown() {
		int[] valores= posicion.getCordenadas();
		int temporal= valores[1]+2;
		changePosition(valores[0], temporal);
	}
	
	/**
	 * El efecto del barril verde: darle una vida al jugador 
	 */
	@Override
	public void efecto(Player p) {
		p.sumeVida();
	}
}
