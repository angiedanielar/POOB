package aplicacion;

import java.awt.Color;

/**
 * @author ECI 2014
 * 
 */

/**
 * Clase Actor dada por la ECI
 * @author ECI
 */
public class Actor extends Persona implements EnEscena{
    private Teatro teatro;   
    protected String palabras;

    /**
     * Crea al actor 
     * @param teatro, el Teatro actual
     * @param name, el nombre del actor 
     * @param posicionx, la posicion en equis donde queremos al actor
     * @param posiciony, la posicion en ye donde queremos al actor
     */
    public Actor(Teatro teatro,String name,int posicionx, int posiciony) {
        super(name,posicionx,posiciony);
        this.teatro=teatro;
        color=Color.BLACK;
        palabras="¡Hola!";
    }

    /**
     * Indica si se puede o no mover el actor
     * @param direccion, indica la direccion a mover del actor para verificar
     */
    private boolean puedeMover(char direccion) {
        boolean puede=false;
        int posX = getPosicionX();
        int posY = getPosicionY();
        switch(direccion){
            case 'N' : puede = (posY+1 < teatro.MAXIMO);
            break;
            case 'E' : puede = (posX+1 < teatro.MAXIMO);
            break;
            case 'S' :  puede = (posY-1 >= 0);
            break;
            case 'O':puede = (posX-1 >= 0);
            break; 
        } 
        return puede;
    }
    
    /**
     * Hace que el actor deje de actuar y corte la escena
     */
    public void corte() {
        muevaBrazo('I','B'); 
        muevaPierna('I','P');
        muevaBrazo('D','B'); 
        muevaPierna('D','P');       
        palabras="";
    }
    
    /**
     * Hace que el actor cominece a actuar y empiece la escena
     */
    public void actue() {
        if (getPosicionBrazo('I')==ABAJO && getPosicionBrazo('D')==ABAJO){
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        } else if (getPosicionBrazo('I')==FRENTE){
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        } else if (getPosicionBrazo('I')==ARRIBA){
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
        }else if (getPosicionBrazo('D')==FRENTE){
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
        }else if (getPosicionBrazo('D')==ARRIBA){
            muevaBrazo('D','B'); 
            muevaPierna('D','B');
            muevaBrazo('D','B'); 
            muevaPierna('D','B');
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        }       
        muevase('S');   
        palabras="Soy " + this;
    }

    /**
     * Nos muestra las palabras actuales del actor 
     */
    public String mensaje() {
        return  palabras;
    }
}
