package valley;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * Crea la lluvia acida la cual agujerea las toldas en su camino y nunca para.
 */
public class LluviaAcida extends Rain {
    
    public LluviaAcida(int x, int y) {
        super("Acida",x,y);
        changeColor("green");
    }
        
    /**
     * Inicia el movimiento de la lluvia acida.
     * 
     */
    @Override
    public void startMove(ArrayList<Lona> trampas, int alto) {
       int deltaX= this.puntos.get(0).getCoordenadas()[0];
        for(int y = 0; y < alto; y++){
            changePosition(deltaX,y);
            for(Lona t: trampas){
                if(t.intersectaLona(getBounds2D())){
                    t.makePuncture(deltaX); 
                }                
            }            
       }                    
    }
}
