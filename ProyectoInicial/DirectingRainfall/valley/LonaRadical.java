package valley;
import shapes.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Crea las trampas radicales que se agujeran desaparecen.
 */
public class LonaRadical extends Lona {
    public LonaRadical(int[] cord1,int[] cord2,int tamano) {
        super(cord1,cord2,tamano,"Radical");
    }
    
    /**
     * hace el hueco en la lona
     */
    @Override
    public void makePuncture(int xposi) {
        super.makePuncture(xposi);
        super.changeColor("lightGray");
    }
    
    /**
     * hace el hueco en la lona
     */
    @Override
    public void patchPuncture(int posicion) {
        super.patchPuncture(posicion);
        super.changeColor("black");
    }
    
    @Override
    public void changePosition(int[] cord1, int[] cord2){
    }
}