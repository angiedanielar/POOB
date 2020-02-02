package Presentacion;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;

/**
 * Crea el Fondo del Juego 
 */
public class DKoongFondo implements Border {
	
	private BufferedImage myImage= null;
	
	/**
	 * Constructor de DKoongFondo
	 */
	public DKoongFondo(BufferedImage newImage) {
		myImage= newImage;
	}	
	
	/**
	 * Pinta el borde del componente especificado con la posición y el tamaño especificados.
	 * @param c, El componente para el que se pinta este borde
	 * @param g, Los gráficos de la pintura
	 * @param x, la posición x del borde pintado
	 * @param y, la posición y del borde pintado
	 * @param width, el ancho del borde pintado
	 * @param height, el alto del borde pintado
	 */
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (myImage != null) {
            g.drawImage(myImage, 0, 0, width, height, null);
        }
    }
    
	/**
	 * @return Insets, Devuelve las inserciones del borde.
	 */
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }
    
    /**
	 * @return boolean, Devuelve si el borde es opaco o no. 
	 * Si el borde es opaco, es responsable de completar su propio fondo al pintar.
	 */
    public boolean isBorderOpaque() {
        return true;
    }

}
