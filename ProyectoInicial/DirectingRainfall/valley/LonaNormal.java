package valley;
import shapes.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Crea las trampas normales.
 */
public class LonaNormal extends Lona{
    public LonaNormal(int[] cord1,int[] cord2,int tamano) {
        super(cord1,cord2,tamano,"Normal");
    }
    
    @Override
    public void changePosition(int[] cord1, int[] cord2){
    }
}

    