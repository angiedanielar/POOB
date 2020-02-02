package Aplicacion;

/**
 * Crea la pocision del Jugador
 */
public class Posicion {
	int cordX,cordY;
	
	/**
	 * Crea la pocision del Jugador
	 * @param x, la posicion en x
	 * @param x,  la posicion en y
	 */
	public Posicion(int x, int y) {
		cordX= x;
		cordY= y;
	}
	
	/**
	 * Obtiene las coordenadas del jugador 
	 * @return respuesta, devuelve las coordenadas del player
	 */
	public int[] getCordenadas() {
		int [] respuesta= {cordX,cordY};
		return respuesta;
	}
	
	/**
	 * Obtiene la coordenada en X del jugador
	 * @return respuesta, devuelve la coordenada del player en X
	 */
	public int getX() {
		int respuesta= cordX;
		return respuesta;
	}
	
	/**
	 * Obtiene la coordenada en Y del jugador
	 * @return respuesta, devuelve la coordenada del player en Y
	 */
	public int getY() {
		int respuesta= cordY;
		return respuesta;
	}
	
	/**
	 * Cambia las coordenadas del jugador
	 */
	public void changeCoordinadas(int newX, int newY) {
		this.cordX= newX;
		this.cordY= newY;
	}
}
