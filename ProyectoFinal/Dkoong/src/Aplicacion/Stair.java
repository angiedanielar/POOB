package Aplicacion;

import java.util.*;
import java.awt.Rectangle;
/**
 * Crea la escalera del juego (normal y rota)
 */
public abstract class Stair {
	private List<Posicion> coordenadas;
	private boolean isBroken;
	protected String root;
	protected Posicion abajoInicial;
	protected Posicion abajoFinal;
	protected Posicion arribaInicial;
	protected Posicion arribaFinal;
	private Rectangle hitBox;
	
	/**
	 * Constructor de la escalera 
	 * @param abajoInicial, la posicion de abajo inicial de la escalera
	 * @param abajoFinal, la posicion de abajo final de la escalera
	 * @param arribaInicial, la posicion de arribal inicial de la escalera
	 * @param arribaFinal, la posicion de arribal final de la escalera
	 */
	public Stair(Posicion abajoInicial, Posicion abajoFinal, Posicion arribaInicial, Posicion arribaFinal) {
		this.abajoInicial = abajoInicial;
		this.abajoFinal = abajoFinal;
		this.arribaInicial = arribaInicial;
		this.arribaFinal = arribaFinal;
		
		coordenadas= new ArrayList<Posicion>();
		// x0
		coordenadas.add(abajoInicial);
		// x1
		coordenadas.add(abajoFinal);
		// y0
		coordenadas.add(arribaInicial);
		// y1
		coordenadas.add(arribaFinal);	
		
		hitBox= new Rectangle(arribaInicial.getX(),arribaInicial.getY(),(arribaFinal.getX()-arribaInicial.getX()),(abajoInicial.getY()-arribaInicial.getY()));
	}
	
	/**
	 * retorna las coordenadas de la escalera
	 * @return coordenadas,  las coordenadas 
	 */
	public List<Posicion> getCoordenadas(){
		return coordenadas;
	}
	
	/**
	 * retorna las coordenadas de la escalera en X
	 * @return coordenadas,  las coordenadas en X
	 */
	public int[] getPosicionesX(){
		return (new int[]{abajoInicial.getX(), arribaInicial.getX()});
	}
	
	/**
	 * retorna la coordenada de abajo de la escalera en y
	 * @return coordenadas,  las coordenadas en Y
	 */
	public int getPosicionAbajoY(){
		return abajoInicial.getY();
	}
	
	/**
	 * retorna la coordenada de arriba de la escalera en y
	 * @return coordenadas,  las coordenadas en Y
	 */
	public int getPosicionArribaY() {
		return arribaInicial.getY();
	}
	
	/**
	 * Mira si estan rotas o no las escaleras
	 * @return isBroken, devuelve si la escalera es rota
	 */
	public boolean isBroken() {
		return isBroken;
	}
	
	/**
	 * Obtiene el sprite de la escalera
	 * @return root, el sprite a devolver
	 */
	public String getRoot() {
		return root; 
	}
	
	/**
	 * Mira si las esclaeras se intersectan con algun otro rectangulo
	 * @return intersecta, si se intersecta o no 
	 */
	public boolean intersecta(Rectangle r) {
		return hitBox.intersects(r);
	}
	
	/**
	 * Cambia la escalera a rota o no
	 * @param valor, el booleano que dice si la escalera es rota
	 */
	protected void setBroken(boolean valor) {
		isBroken= valor;
	}
}
