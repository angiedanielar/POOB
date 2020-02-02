package aplicacion;

import java.util.*;

/**
 * @author ECI 2014
 * 
 */

/**
 * Clase Teatro dada por la ECI
 * @author ECI
 */
public class Teatro {
    public static final int MAXIMO = 500;
    private static Teatro teatro = null;
    
    /**
     * Crea el teatro por default desde consola nulo
     */
    public static Teatro demeTeatro() {
        if (teatro==null){
            teatro=new Teatro();
        }
        return teatro;
    }
    
    /**
     * Crea un nuevo teatro
     */
    private static void nuevoTeatro() {
        teatro=new Teatro();
    }   
    
    /**
     * Cambia el teatro actual por otro
     * @param d, el nuevo teatro a  cambiar
     */
    public static void cambieTeatro(Teatro d) {
        teatro=d;
    }       

    private ArrayList<EnEscena> elementos;
    
    /**
     * Crea el teatro con todos sus elementos en el
     */
    private Teatro() {
        elementos= new ArrayList<EnEscena>();
    }
    
    /**
     * Añade los elementos al actual teatro
     */
    public void algunosEnEscena() {  
        Actor actor1 = new Actor(this,"Romeo",20,150);
        Actor actor2 = new Actor(this,"Julieta",90,150);
        
        ActorNecio actor3 = new ActorNecio(this,"Homero",20,70);
        ActorNecio actor4 = new ActorNecio(this,"Bard",90,70);
        
        ActorPerezoso actor5 = new ActorPerezoso(this,"Edward",20,0);
        ActorPerezoso actor6 = new ActorPerezoso(this,"Bella",90,0);
        
        ActorEjemplar actor7 = new ActorEjemplar(this,"Ernesto",20,220);
        ActorEjemplar actor8 = new ActorEjemplar(this,"Daniela",90,220);
        
        Luz luz1= new Luz(this,"centralDerecha",240,250);
        Luz luz2= new Luz(this,"centralIzquierda",260,250);
        
        Escenografia mesa1 = new Escenografia(this,"Mobil",240,300,true);
        Escenografia mesa2 = new Escenografia(this,"inMobil",260,300,false);
        
        elementos.add(actor1);
        elementos.add(actor2);
        elementos.add(actor3);
        elementos.add(actor4);
        elementos.add(actor5);
        elementos.add(actor6);
        elementos.add(actor7);
        elementos.add(actor8);
        elementos.add(luz1);
        elementos.add(luz2);
        elementos.add(mesa1);
        elementos.add(mesa2);
    }   
    
    /**
     * @param n, el elemento a mirar si esta o  no en escena
     * @return h, retorna si el elemento esta en o no en escena
     */
    public EnEscena demeEnEscena(int n) {
        EnEscena h=null;
        if (1<=n && n<=elementos.size()){
            h=elementos.get(n-1);
        }    
        return h; 
    }
    
    /**
     * Adiciona los elementos del teatro a la escena
     * @param e, el elemento a adicionar
     */
    public void adicione(EnEscena e) {
        elementos.add(e);
    }
    
    /**
     * @return retorna el numero de elementos del teatro en escena
     */
    public int numeroEnEscena() {
        return elementos.size();
    }
    
    /**
     * Pone en accion a los elementos del teatro
     */
    public void accion() {
        for(EnEscena e: elementos){
            e.actue();
        }
    }
    
    /**
     * Para la accion de los elementos del teatro
     */
    public void corten() {
        for(EnEscena e: elementos){
            e.corte();
        }
    }    

    /**
     * Pone en decidir a los elementos del teatro
     */
    public void decidan() {
        for(EnEscena e: elementos){
            e.decida();
        }
    }

    /**
     * Pone a reiniciar a los elementos del teatro
     */
    public void reinicien() {
        for(EnEscena e: elementos){
            e.reinicien();
        }
    }
}
