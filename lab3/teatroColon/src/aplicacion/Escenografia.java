package aplicacion;

import java.awt.Color;

/**
 * @author Ernesto Camacho y Daniela Ruiz 2019 
 */


/**
 * Objeto propuesto: Escenografia
 * @author (Ernesto Camacho y Daniela Ruiz)
 */

public class Escenografia implements EnEscena {
    private int posiX;
    private int posiY;
    private Color color;
    private Teatro teatro;
    private String nombre;
    private boolean movil;
    
    /**
     * Crea la escenografia dsel teatro actual
     * @param teatro, el Teatro actual
     * @param name, el nombre del nuevo objeto de la escenografia
     * @param posicionx, la posicion en equis donde queremos la escenografia
     * @param posiciony, la posicion en ye donde queremos la escenografia
     */
    public Escenografia(Teatro teatro, String nombre, int posiX, int posiY, boolean movil) {
        this.posiX= posiX;
        this.posiY= posiY;
        this.teatro= teatro;
        this.nombre= nombre;
        this.movil= movil;
        
        if(movil) {
            color= Color.BLUE;
        }
        else {
            color= Color.RED;
        }
    }
    
    /**
     * Es un cuadrado
     */
    public String forma() {
        return FORMAS[2];
    }
    
    /**
     * Nos muestra las palabras del objeto de la escenografia
     */
    public String mensaje() {
        return "";
    }

    /**
     * @return posiX, retorna la posicion en equis del objeto de la escenografia
     */
    public int getPosicionX() {
        return posiX;
    }
    
    /**
     * @return posiY, retorna la posicion en ye del objeto de la escenografia
     */
    public int getPosicionY() {
        return posiY;
    }
    
    /**
     * @return color, retorna el color del objeto de la escenografia
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Hace que el objeto actual de la escenografia comience a actuar
     */
    public void actue() {
        if(movil) {
            color= Color.BLUE;
        }
        else {
            color= Color.RED;
        }
        
        if(movil) {
            this.posiY+= 10;
        }
    }
    
    /**
     * Hace que el objeto actual de la escenografia pare de actuar
     */
    public void corte() {
        this.color=Color.WHITE;
    }
    
    /**
     * Hace que el objeto actual de la escenografia decida
     */
    public void decida() {
    }
}
