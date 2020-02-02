package valley;

import java.util.*;
import java.awt.*;

/**
 * Creamos al punto.
 */
public class Point{
    private int[] coordenadasPlano;
    
    /**
     * Constructor de objetos de la clase Point.
     */
    public Point(int x, int y) {
        coordenadasPlano = new int[2];
        coordenadasPlano[0]= x;
        coordenadasPlano[1]= y;
    }
    
    /**
     * Determina si dos puntos son iguales.
     * @return valor, retorna si un punto es igual a otro
     */
    public boolean equals(Point punto) {
        boolean valor= false;
        if((getCoordenadas()[0] == punto.getCoordenadas()[0]) && (getCoordenadas()[1] == punto.getCoordenadas()[1])){
            valor= true;
        }
        return valor;
    }

    /**
     * @return coordenadasPlano, retorna las coordenadas del punto 
     */
    public int[] getCoordenadas(){   
        return this.coordenadasPlano;
    }
}
