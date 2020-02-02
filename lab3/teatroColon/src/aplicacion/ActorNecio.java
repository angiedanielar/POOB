package aplicacion;

import java.awt.Color;

/**
 * @author ECI 2014
 * 
 */

/**
 * Clase propuesta por el laboratorio: Clase Actor Necio
 * @author (Ernesto Camacho y Daniela Ruiz)
 */
public class ActorNecio extends Persona implements EnEscena{
    private Teatro teatro;
    private String ultimaAccion;
    protected String palabras;
    private int cont;

    /**
     * Crea al actor necio
     * @param teatro, el Teatro actual
     * @param name, el nombre del actor necio
     * @param posicionx, la posicion en equis donde queremos al actor
     * @param posiciony, la posicion en ye donde queremos al actor
     */
    public ActorNecio(Teatro teatro,String name,int posicionx, int posiciony){
        super(name,posicionx,posiciony);
        this.teatro=teatro;
        color=Color.BLACK;
        ultimaAccion= null;
        palabras="¡Hola!";
        cont = 1;
    }
    
    /**
     * Indica si se puede o no mover el actor necio 
     * @param direccion, indica la direccion a mover del actor para verificar
     */
    private boolean puedeMover(char direccion) {
        boolean puede=false;
        int posX = getPosicionX();
        int posY = getPosicionY();
        
        switch(direccion) {
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
     * Decide como actuar de forma necia, actua neciamente cada 3 veces
     */
    private boolean decidaComoActua() {
        boolean valor= false;
        if(cont%3 == 0) {
            valor= true;
        }
        return valor;
    }        
    
    /**
     * Hace que el actor necio deje de actuar y corte la escena como un actor normal
     */
    public void corte() {
        if(decidaComoActua()) {
            corteNecio();
        }
        else {
            actueNecio();
        }
        this.ultimaAccion="corte";
        cont+=1;
    }
    
    /**
     * Hace que el actor necio cominece a actuar y empiece la escena como un actor normal
     */
    public void actue() {
        if(decidaComoActua()) {
            actueNecio();
        }
        else {
            corteNecio();
        }
        this.ultimaAccion="actue";
        cont+=1;
    }
    
    /**
     * Hace que el actor necio deje de actuar y corte la escena como un actor necio
     */
    public void corteNecio() {
        if (getPosicionBrazo('I')==ABAJO && getPosicionBrazo('D')==ABAJO){
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        } 
        else if (getPosicionBrazo('I')==FRENTE){
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        } 
        else if (getPosicionBrazo('I')==ARRIBA){
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
        }
        else if (getPosicionBrazo('D')==FRENTE){
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
        }
        else if (getPosicionBrazo('D')==ARRIBA){
            muevaBrazo('D','B'); 
            muevaPierna('D','B');
            muevaBrazo('D','B'); 
            muevaPierna('D','B');
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        }         
        palabras="Soy " + this;
    }

    /**
     * Hace que el actor necio cominece a actuar y empiece la escena como un actor necio
     */
    public void actueNecio() {
        muevaBrazo('I','B'); 
        muevaPierna('I','P');
        muevaBrazo('D','B'); 
        muevaPierna('D','P');       
        palabras="";
    }
    
    /**
     * Hace que el actor necio decida siempre llevar la contraria
     */
    public void decida() {
        if(this.ultimaAccion.equals("actue")){
            actue();
        }
        else{
            corte();
        }
    }
    
    /**
     * Nos muestra las palabras actuales del actor necio 
     */
    public String mensaje() {
        return  palabras;
    }
}
