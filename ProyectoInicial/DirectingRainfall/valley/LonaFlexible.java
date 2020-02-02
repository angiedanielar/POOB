package valley;
import shapes.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Crea las trampas felixbles que cambian su forma para poder ubicarse y solo se pueden agujerar una vez, auto-parcha el hueco anterior. 
 */
public class LonaFlexible extends Lona {
    public LonaFlexible(int[] cord1,int[] cord2,int tamano) {
        super(cord1,cord2,tamano,"Flexible");
    }
        
    public void makePuncture(int xposi) {
        if((getCoordenadas()[0] <= xposi && xposi <= getCoordenadas()[1])){
            float [] info= getLona().getInfo();
            float y1= (float)(info[0]*xposi) + info[1];  
            float x2= xposi + ((float)1);
            float y2= (float)(info[0]*x2) + info[1];
            Segmento nuevoHueco= new Segmento(xposi,x2,y1,y2,this.tamano);
            nuevoHueco.changeColor("lightGray");        
            huecos.add(nuevoHueco);
            if(this.huecos.size()> 1){
                super.patchPuncture(0);
            }            
            this.okFlag= true;
            if (this.isVisible){
                makeVisible();
            }        
        }      
        else{
            this.okFlag= false;
        }
    }
    
    @Override
    public void changePosition(int[] cord1, int[] cord2){
        this.trampa= new Segmento((float)cord1[0], (float)cord2[0], (float)cord1[1], (float)cord2[1], tamano);
    }
    
}