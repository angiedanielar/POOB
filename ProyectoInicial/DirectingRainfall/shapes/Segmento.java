package shapes
;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * Una segmento que puede ser manipulado.
 */
public class Segmento extends Figura {
    private int[] coordenadasPlano;
    private float[] coordenadasReales;
    private Line2D.Double segmento;
    private float[] info;
    
    /**
     * Constructor de objetos de la clase Segmento.
     */
    public Segmento(float x1, float x2, float y1, float y2, float tamano) {
        info= new float[2];
        informacion(x1, x2, y1, y2);
        coordenadasPlano=  new int[4];
        coordenadasPlano[0]= (int)x1;
        coordenadasPlano[1]= (int)x2;
        coordenadasPlano[2]= (int)y1;
        coordenadasPlano[3]= (int)y2;
        coordenadasReales= new float[4];
        coordenadasReales[0]= x1;
        coordenadasReales[1]= x2;
        coordenadasReales[2]= tamano- y1;
        coordenadasReales[3]= tamano- y2;
        segmento= new Line2D.Double(coordenadasReales[0], coordenadasReales[2], coordenadasReales[1], coordenadasReales[3]);
    }
    
    /**
     * @return inVisible, retorna si es visible o no el segmento
     */
    public boolean getVisible() {
        return isVisible;
    }
    
    /**
     * Obtiene las coordenada de los puntos de inicio del segmento.
     * @return dato, la coordenada con la menor x del segmento
     */
    public float[] getCoordenada() {
        float[] dato;
        dato= new float[2];
        if (this.coordenadasReales[0] > this.coordenadasReales[1]){
            dato[0]= this.coordenadasReales[0];
            dato[1]= this.coordenadasReales[2];
        }
        else{
            dato[0]= this.coordenadasReales[1];
            dato[1]= this.coordenadasReales[3];
        }
        return dato;
    }
    
    /**
     * Obtiene las coordenadas de los puntos que hacen el segmento.
     * @return coordenadas, las coordenadas en el canvas
     */
    public float[] getCoordenadasReales() {
        return this.coordenadasReales;
    }
    
    /**
     * Obtiene las coordenadas en el plano del segmento.
     * @return coordenadasPlano, las coordenadas del segmento como se manejan en el plano
     */
    public int[] getCoordenadasPlano() {
        return this.coordenadasPlano;
    }
    
    /**
     * Obtiene si el segmento contiene las coordenadas x de otro.
     * @return valor, si contiene o no las coordenadas x de otro
     */
    public boolean contains(Segmento seg) {
        boolean valor= false;
        float [] coordenadasSeg= seg.getCoordenadasReales();
        if ((this.coordenadasReales[0] <= coordenadasSeg[0]) && (coordenadasSeg[0] <= this.coordenadasReales[1]) && 
            (this.coordenadasReales[0] <= coordenadasSeg[1]) && (coordenadasSeg[1] <= this.coordenadasReales[1])){
            valor= true;
        } 
        return valor;
    }
    
    /**
     * Mira si el segmento interseca a otro segmento.
     * @param seg, segmento a mirar interseccion
     * @return valor, si se intersecan en algun punto
     */
    public boolean intersecta(Segmento seg) {
        boolean valor= false;
        float[] cordSeg= seg.getCoordenadasReales();
        valor= checkInterseccion(cordSeg);
        return valor;
    }  
    
    /**
     * Obtiene la informacion de la recta asociada a la segmento .
     * @return info, array de floats de 2 elementos pendiente de la segmento, corte con el eje y
     */
    public float[] getInfo() {
        return info;
    }
    
    /**
     * Obtiene el objeto Line2D que representa al segmento.
     * @return segmento, objeto que representa al segmento
     */
    public Line2D getSegmento() {
        return segmento;
    }
    
    /**
     * Obtiene si se interseca o no con otra linea.
     * @param cordSeg, coordenadas del segmento a probar
     * @return valor, si se intersecan o no
     */
    public boolean checkInterseccion(float[] cordSeg) {
        boolean valor= false;
        Line2D segmento= getSegmento();
        valor= segmento.intersectsLine((double)cordSeg[0],(double)cordSeg[2],(double)cordSeg[1],(double)cordSeg[3]);
        return valor;
    }
    
    /**
     * Calcula la informacion de la recta asocioada a la segmento.
     */
    private void informacion(float x1, float x2, float y1, float y2) {
        float pendiente= (float)((y2 - y1)/(x2 - x1));
        this.info[0]= pendiente;
        float b= (float) (y1 - (pendiente * x1));
        this.info[1]= b;
    }
    
    /**
     * Hace un rectangulo2D alrededor del segmento.
     */
    public Line2D.Double getBounds() {
        return segmento;
    }
    
    /**
     * Dibuja al segmento.
     */
    public void draw() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, super.getColor(),segmento);
            canvas.wait(10);
        }
    }   
}
