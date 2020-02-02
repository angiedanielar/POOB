package valley;
import shapes.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Crea las trampas inmutables las cuales no se pueden parchar.
 */
public class LonaInmutable extends Lona {
    public LonaInmutable(int[] cord1,int[] cord2,int tamano) {
        super(cord1,cord2,tamano,"Inmutable");
    }

    /**
     * hace el hueco en la lona
     */
    @Override
    public void patchPuncture(int posicion) {
    }
    
    @Override
    public void changePosition(int[] cord1, int[] cord2){
    }
}