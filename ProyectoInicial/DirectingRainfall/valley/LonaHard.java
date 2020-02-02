package valley;
import shapes.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Crea las trampas hard que no se puden agujerear ni eliminar.
 */
public class LonaHard extends Lona {
    public LonaHard(int[] cord1,int[] cord2,int tamano) {
        super(cord1,cord2,tamano,"Hard");
    }
    
    @Override
    public void makePuncture(int xposi) {
    }
    
    @Override
    public void patchPuncture(int xposi) {
    }    
    
    @Override
    public void changePosition(int[] cord1, int[] cord2){
    }
}