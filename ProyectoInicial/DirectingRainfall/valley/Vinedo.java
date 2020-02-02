package valley;

import shapes.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Crea el vinedo
 */
public class Vinedo {
    private Segmento vinedo;
    private boolean isVisible;
    private String color;  
    
    /**
     * Constructor de objetos de la clase Vinedo.
     * @param x1, coordenada x inicial
     * @param x2, coordenada x final 
     * @param z, coordenada en y
     */
    public Vinedo(int x1,int x2,int z, float tamano) {    
        vinedo = new Segmento(x1, x2, tamano-z, tamano-z, tamano);
        isVisible = false;
        color= "black";
    }
    
    /**
     * Cambia el color del vinedo.
     * @param color, nuevo color del vinedo
     */
    public void changeColor(String color) {
        this.color= color;
        vinedo.changeColor(color);
    }    
    
    /**
     * Hace visible al vinedo.
     */
    public void makeVisible() {
        this.isVisible= true;
        vinedo.makeVisible();
    }
    
    /**
     * Hace invisible al vinedo.
     */
    public void makeInvisible() {
        this.isVisible= false;
        vinedo.makeInvisible();
    }
    
    /**
     * @return isVisible, retorna si es visible o no
     */
    public boolean getVisible() {
        return this.isVisible;
    }
    
     /**
     * @return color, retorna el nombre del vinedo
     */
    public String getName() {
        return this.color;
    }
    
    /**
     * @return color, retorna el color del vinedo
     */
    public String getColor() {
        return this.color;
    }
    
    /**
     * @return vinedo, retorna el valor del segmento vinedo
     */
    public Segmento getVinedo() {
        return this.vinedo;
    }
    
    /**
     * @return linea2D, retorna el segmento de linea2D del vinedo
     */
    public Line2D getLinea(){
        return this.vinedo.getSegmento();
    }
    
    /**
     * @return coordenadas, retorna las coordenadas(inicial y final) del vinedo
     */
    public int[] getCoordenadas() {
        return getVinedo().getCoordenadasPlano();
    }
}
