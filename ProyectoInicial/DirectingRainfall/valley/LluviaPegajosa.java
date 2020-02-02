package valley;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * Prpuesta por Ernesto Cmacho y Daniela Ruiz.
 * Crea la lluvia pegajosa la cual se adiere a las lonas, para solo si toca una lona.
 */
public class LluviaPegajosa extends Rain {
    public LluviaPegajosa(int x, int y) {
        super("Pegajosa",x,y);
        changeColor("yellow");
    }
    
    /**
     * Inicia el movimiento de la lluvia acida.
     * 
     */
    @Override
    public void startMove(ArrayList<Lona> trampas, int alto) {
       int deltaX= this.puntos.get(0).getCoordenadas()[0];
       boolean flag= true;
        for(int y = 0; y < alto && flag; y++){
            changePosition(deltaX,y);
            for(Lona t: trampas){
                if(t.intersectaLona(getBounds2D())){
                    flag= false;
                }                
            }            
       }                    
    }
}