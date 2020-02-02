package aplicacion;

import java.awt.Color;
import java.io.*;

/**
 * @author ECI 2014
 * 
 */

/**
 * Clase propuesta por la ECI: Luz
 * @author (Ernesto Camacho y Daniela Ruiz)
 */
public class Luz implements EnEscena,Serializable {
    private int posiX;
    private int posiY;
    private Color color;
    private Teatro teatro;
    private String nombre;
    
    /**
     * Crea la luz
     */
    public Luz(Teatro teatro, String nombre, int posiX, int posiY){
        this.posiX= posiX;
        this.posiY= posiY;
        color= Color.ORANGE;
        this.teatro= teatro;
        this.nombre= nombre;
    }
    
    /**
     * Es un circulo
     */
    public String forma(){
        return FORMAS[1];
    }
    
    /**
     * Nos muestra las palabras actuales de la luz
     */
    public String mensaje(){
        return "";
    }

    /**
     * @return posiX, retorna la posicion en equis de la luz
     */
    public int getPosicionX(){
        return posiX;
    }
    
    /**
     * @return posiY, retorna la posicion en ye de la luz
     */
    public int getPosicionY(){
        return posiY;
    }
    
    /**
     * @return color, retorna el color de la luz
     */
    public Color getColor(){
        return color;
    }
    
    /**
     * Hace que la luz actual comience a actuar
     */
    public void actue(){
        this.color=Color.ORANGE;
    }
    
    /**
     * Hace que la luz actual pare de actuar
     */
    public void corte(){
        this.color=Color.WHITE;
    }
    public void reinicien(){
	   this.color=Color.ORANGE;
    }
    
    /**
     * retorna el String con la informacion actual de la persona
     * @return estado
     */
    public String toString() {
    	String respuesta= nombre +" "+ Integer.toString(getPosicionX()) +" "+ Integer.toString(getPosicionY());
    	return respuesta;
    }
}
