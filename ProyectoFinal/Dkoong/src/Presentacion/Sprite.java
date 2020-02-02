package Presentacion;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * Controla los sprites del juego
 */
public class Sprite {
	private BufferedImage imagen;
	private String rut;
	private int x, y, width, height;
	private boolean visible;

	/**
	 * Constructor del Sprite
	 * @param x, posicion en x del sprite
	 * @param y, posicion en y del sprite
	 * @param visible, la visibilidad del sprite
	 */
	public Sprite(int x, int y, boolean visible) {
		this.x = x;
		this.y = y;
		this.visible = visible;
	}
	
	/**
	 * Constructor del Sprite
	 * @param x, posicion en x del sprite
	 * @param y, posicion en y del sprite
	 * @param visible, la visibilidad del sprite
	 * @param width, el ancho del sprite
	 *  @param height, el alto del sprite
	 */
	public Sprite(int x, int y, boolean visible, int width, int height){
		this(x,y,visible);
		this.width = width;
		this.height = height;
	}

	/**
	 * Cambia la coordenada en x del sprite
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Cambia la coordenada en y del sprite
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Devuelve la coordenada en X del sprite
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Devuelve la coordenada en Y del sprite
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Hace visible o no el sprite
	 */
	public void setVisible(boolean v) {
		this.visible = v;
	}

	/**
	 * Cambia el sprite
	 */
	public void setRoot(String root) {
		try {
			rut="images/"+root+".png";
			imagen = ImageIO.read(new File("images/"+root+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Obtiene el sprite actual
	 * @return rut, el sprite a devolver
	 */
	public String getRoot() {
		return rut;
	}

	/**
	 * Pinta el sprite 
	 */
	public void paint(Graphics graphics) {
		if (visible)
			if(width==0 && height == 0)
				graphics.drawImage(imagen, x, (int) y, null);
			else
				graphics.drawImage(imagen, x, (int) y, width, height, null);
	}

	@Override
	public String toString() {
		return "Sprite [imagen=" + imagen + ", rut=" + rut + ", x=" + x + ", y=" + y + ", width=" + width + ", height="
				+ height + ", visible=" + visible + "]";
	}
}
