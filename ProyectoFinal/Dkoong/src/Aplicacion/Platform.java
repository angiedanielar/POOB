package Aplicacion;

import java.util.*;
import java.awt.Rectangle;

/**
 * Crea la plataforma del juego
 */
public class Platform {
	private List<Posicion> coordenadas;
	private Rectangle hitBox;
	private int tipo;
	
	/**
	 * Cosntructor de la plataforma
	 * @param posiInicial, la poscion inical de la plataforma
	 * @param posiFinal, la poscion final de la plataforma
	 * @param tipo, el tipo de la plataforma (para que los barriles rueden)
	 */
	public Platform(Posicion posiInicial, Posicion posiFinal, int tipo) {
		coordenadas= new ArrayList<Posicion>();
		coordenadas.add(posiInicial);
		this.tipo= tipo;
		coordenadas.add(posiFinal);
		int posiY= posiInicial.getY()-20;
		int ancho= Math.abs(posiFinal.getX() - posiInicial.getX());
		int alto= Math.abs(posiInicial.getY()- posiY);
		hitBox= new Rectangle(posiInicial.getX(), posiY, ancho, alto);
	}
	
	/**
	 * Retorna las coordenas de la plataforma
	 * @return coordenadas, devuelve las coordenadas de la lona actual
	 */
	public  List<Posicion> getCoordenadas(){
		return coordenadas;
	}
	
	/**
	 * Mira si se intersecta la plataforma con algun otro rectangulo
	 * @param r, el rectangulo a mirar 
	 * @return intersecta, si se intersecta o no
	 */
	public boolean intersecta(Rectangle r) {
		return hitBox.intersects(r);
	}
	
	/**
	 * Obtiene el rectangulo de la plataforma
	 * @return hitBox, el rectangulo a devolver
	 */
	public Rectangle getHitBox() {
		return hitBox;
	}
	
	/**
	 * Obtiene el tipo  de la plataforma
	 * @return tipo, el tipo a devolver
	 */
	public int getTipo() {
		return tipo;
	}
}
