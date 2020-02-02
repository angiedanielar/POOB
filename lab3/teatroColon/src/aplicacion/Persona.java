package aplicacion;

import java.util.*;
import javafx.util.*;
import java.awt.Color;

/**
 * @author ECI 2014
 * 
 */

/**
 * Clase Persona dada por la ECI
 * @author ECI
 */

public class Persona {
    //Posiciones
    public final static int ARRIBA=0;
    public final static int FRENTE=1;
    public final static int ABAJO=2;
    
    //Dimension pasos
    private final static int PASO=20;
    private String nombre;  
    private int brazoIzq;
    private int brazoDer;
    private int piernaIzq;
    private int piernaDer;
    protected Color color;
    private List<Pair<Integer,Integer>> posiciones;

    /**
     * Crea un nuevo persona en la posicion (posicionx, posiciony)
     * @param nombre nombre de la persona
     * @param posicionx coordenada x de la posicion
     * @param posiciony coordenada y de la posicion
     */
    public Persona(String nombre, int posicionx, int posiciony) {
        this.nombre=nombre;
        brazoIzq=ABAJO;
        brazoDer=ABAJO;
        piernaIzq=ABAJO;
        piernaDer=ABAJO;
        color=Color.BLACK;
	this.posiciones = new ArrayList<Pair<Integer,Integer>>();
	posiciones.add(new Pair<>(posicionx,posiciony));
    }

    /**
     * Retorna el color del vestido
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Mueve un brazo segun las indicaciones
     * @param c el brazo a mover: I(zquierdo) o D(erecho)
     * @param d el modo de moverlo: S(ubir) o B(ajar)
    */
    public final void muevaBrazo(char c,char d) {
        if ((c=='I') && (d=='S') && ((brazoIzq-1)>=0)) {
             brazoIzq-=1;
        } else if ( (c=='I') && (d=='B') && ((brazoIzq+1)<3)){
            brazoIzq+=1;
        } else if ((c=='D') && (d=='S') && ((brazoDer-1)>=0)){
            brazoDer-=1;
        }  else if ((c=='D') && (d=='B') && ((brazoDer+1)<3)){
            brazoDer+=1;
        }
    }

    /**
     * Mueve una pierna segun las indicaciones
     * @param c la pierna a mover: I(zquierdo) o D(erecho)
     * @param d el modo de moverlo: S(ubir), B(ajar), P(iso)
     */
    public final void muevaPierna(char c,char d) {
        if ((c=='I') && (d=='S') && ((piernaIzq-1)>=0)){
             piernaIzq-=1;
        } else if ((c=='I') && (d=='B') && ((piernaIzq+1)<3)){
            piernaIzq+=1;
        } else if ((c=='D') && (d=='S') && ((piernaDer-1)>=0)){
            piernaDer-=1;
        }  else if ((c=='D') && (d=='B') && ((piernaDer+1)<3)){
            piernaDer+=1;
        } else if ((c=='D') && (d=='P')){
            piernaDer=ABAJO;
        } else if ((c=='I') && (d=='P')){
            piernaIzq=ABAJO;
        }
    }

    /**
     * Retorna la posicion de un brazo
     * @param c el brazo de interes: I(zquierdo) o D(erecho)
     * @return la posicion del brazo indicada
     */
    public final int getPosicionBrazo(char c) {
        return (c=='I'? brazoIzq: brazoDer);
    }

    /**
     * Retorna la posicion de una pierna
     * @param c la pierna de interes: I(zquierda) o D(erecha)
     * @return la posicion de la pierna indicada
     */
    public final int getPosicionPierna(char c) {
        return (c=='I'? piernaIzq: piernaDer);
    }
    
    /**
     * Se mueve en la direccion indicada
     * @param c indica la direccion. N(orte), S(ur), E(ste), O(este)
     */
    public void muevase(char c) {
        if (c=='E') {
            posiciones.add(new Pair<>(getPosicionX()+PASO,getPosicionY()));
        } else if (c=='O'){
           posiciones.add(new Pair<>(getPosicionX()-PASO,getPosicionY()));  
        } else if (c=='N'){
            posiciones.add(new Pair<>(getPosicionX(),getPosicionY()-PASO));
        } else if (c=='S'){
            posiciones.add(new Pair<>(getPosicionX(),getPosicionY()+PASO));
        }
    }

   /**
     * Se reinicia
     */
    public void reinicien() {
        Pair<Integer,Integer> temp = posiciones.get(0);
	posiciones.clear();
	posiciones.add(temp);
    }

    /**
     * Retorna la coordenada x de la posicion
     */
    public final int getPosicionX() {
        return posiciones.get(posiciones.size()-1).getKey();
    }

    /**
     * Retorna la coordenada y de la posicion
     */
    public final int getPosicionY() {
        return posiciones.get(posiciones.size()-1).getValue();
    }
}
