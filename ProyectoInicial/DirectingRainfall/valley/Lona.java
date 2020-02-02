package valley;

import shapes.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Las trampas que se pueden anadir.
 */
public abstract class Lona {
    protected Segmento trampa;
    protected ArrayList<Segmento> huecos;    
    protected boolean isVisible;
    private String color;
    protected boolean okFlag;
    protected float tamano;
    private String tipo;
    /**
     * Constructor de objetos de la clase Lona.
     * @param cord1, array de 2 elementos x,y coordenada 1 de la lona
     * @param cord2, array de 2 elementos x,y coordenada 2 de la lona
     */
    public Lona(int[] cord1, int[] cord2, int tamano, String tipo) {
        this.tamano= (float)tamano;
        trampa= new Segmento((float)cord1[0], (float)cord2[0], (float)cord1[1], (float)cord2[1], (float)tamano);
        huecos= new ArrayList<Segmento>();     
        isVisible= false;
        this.tipo= tipo;
        color= "black";
        okFlag= true;
    }
    
    /**
     * Hace el hueco en la lona.
     * @param xposi, la posicion del hueco
     */
    public void makePuncture(int xposi) {
        if((getCoordenadas()[0] <= xposi && xposi <= getCoordenadas()[1])){
            if(!checkPuntoHueco(xposi)){
                float [] info= this.trampa.getInfo();
                float y1= (float)(info[0]*xposi) + info[1];  
                float x2= xposi + ((float)1);
                float y2= (float)(info[0]*x2) + info[1];
                Segmento nuevoHueco= new Segmento(xposi,x2,y1,y2,this.tamano);
                nuevoHueco.changeColor("lightGray");        
                huecos.add(nuevoHueco);
                asignaPosicionHuecos();
                this.okFlag= true;}            
            if (this.isVisible){
                makeVisible();
            }        
        }      
        else{
            this.okFlag= false;
        }
    }
    
    /**
     * Remueve el hueco de la posicion indicada de la lona.
     * @param posicion, el hueco que se remueve
     */
    public void patchPuncture(int posicion) {
        if((posicion) <= this.huecos.size()){
            huecos.get(posicion).makeInvisible();            
            huecos.remove(posicion);
            this.okFlag= true;
            if (this.isVisible){
                makeVisible();
            }
        }
        else{
            this.okFlag= false;
        }
    }
    
    /**
     * Hace visible la lona.
     */
    public void makeVisible() {
        this.isVisible= true;
        trampa.makeVisible();
        Iterator<Segmento> iteradorHuecos= this.huecos.iterator();
        while (iteradorHuecos.hasNext()){
            Segmento hueco= iteradorHuecos.next();
            hueco.makeVisible();
        }
    }
    
    /**
     * Hace invisible la lona.
     */
    public void makeInvisible() {
        this.isVisible= false;
        trampa.makeInvisible();
        Iterator<Segmento> iteradorHuecos= this.huecos.iterator();
        while (iteradorHuecos.hasNext()){
            Segmento hueco= iteradorHuecos.next();
            hueco.makeInvisible();
        }
    }
    
    /**
     * Cambia el color de la lona.
     * @param color, nuevo color de la lona
     */
    public void changeColor(String color) {
        this.color= color;
        trampa.changeColor(color);
    }
    
    public String getColor(){
        return this.color;
    }
    
    /**
     * Retorna si es la lona es visible o no.
     * @return isVisible, el valor actual de la visibilidad de la lona
     */
    public boolean getVisible() {
        return isVisible;
    }
    
    /**
     * Retorna la coordenada con el x mas pequeña del segmento ya transformada.
     * @return, retorna la coordenada con el x mas pequeño
     */
    public float[] getCoordenada() {
        return trampa.getCoordenada();
    }
    
    /**
     * Retorna la coordenadas de la informacion del segmento.
     * @return, retorna las coordenadas 
     */
    public int[] getCoordenadas() {
        return getLona().getCoordenadasPlano();
    }
    
    /**
     * Retorna la informacion del segmento que la representa.
     * @return info, pendiente y corte en eje que tienen la linea del segmento
     */
    public float[] getInfo() {
        return getLona().getInfo();
    }
    
    /**
     * Obtiene la pendiente de la lona actual.
     * @return, retorna la pendiente de la trampa
     */
    public double getPendiente() {
        float[] coordenadas = getLona().getInfo();
        double pendiente = (double)coordenadas[0];
        return pendiente;
    }
    
    /**
     * retorna si se intersecta la trampa con el rectangulo de la lluvia
     */
    public boolean intersectaLona(Rectangle2D otroObjeto){
        boolean interseccion = trampa.getBounds().intersects(otroObjeto);
        return interseccion;
    }
    
    /**
     * @return nHuecos, retorna el numero de huecos que hay en la lona
     */
    public int getNumeroHuecos() {
        return this.huecos.size();
    }
    
    /**
     *  @return huecos, retorna los huecos de la lona
     */
    public ArrayList getHuecos() {
        return this.huecos;
    }
    
    /**
     * Obtiene el valor de okFlag
     * @return okFlag, si pudo o no hacer la ultima operacion.
     */
    public boolean ok() {
        return this.okFlag;
    }
    
    /**
     *  @return trampa, retorna el valor del segmento trampa
     */
    public Segmento getLona() {
        return this.trampa;
    }
    
    /**
     * Obtiene un array con la informacion de las posiciones de los huecos.
     * @return coords, las coordenadas de los huecos
     */
    public int[] coordenadaHuecos() {
        int[] coords= new int[this.huecos.size()];
        for(int i= 0; i< this.huecos.size(); i++){
            coords[i]= huecos.get(i).getCoordenadasPlano()[0];
        }
        return coords;
    }
    
    /**
     * @return tipo, retorna el tipo de lona que es
     */
    public String getTipo(){
        return this.tipo;
    }
    
    public abstract void changePosition(int[] cord1, int[] cord2);
    
    /**
     * chequea las coordenadas los huecos 
     * @return valor, si es permitido o no 
     */
    private boolean checkPuntoHueco(int xposi){
        boolean valor= false;
        int[] huecos= coordenadaHuecos();
        for(int i= 0; i< this.huecos.size();i++){
            if (huecos[i] == xposi){
                valor= true;
            }
        }
        return valor;
    }
    /**
     * Asigna la posicion los elementos que la necesiten.
     */
    private void asignaPosicionHuecos() {
        ArrayList<float[]> coordenadas= new ArrayList<float[]>();
        ArrayList<Segmento> huecos1= new ArrayList<Segmento>();
        Iterator<Segmento> iteradorHuecos= this.huecos.iterator();
        while (iteradorHuecos.hasNext()){
            Segmento hueco= iteradorHuecos.next();
            coordenadas.add(hueco.getCoordenada());
        }
        coordenadas= ordenar(coordenadas);
        int tamano= coordenadas.size();
        for(int i= 0; i< tamano; i++){
             Iterator<Segmento> iteradorHuecos1= this.huecos.iterator();
            while (iteradorHuecos1.hasNext()){
                Segmento hueco= iteradorHuecos1.next();
                if(coordenadas.get(i)[0] == hueco.getCoordenada()[0] &&
                   (coordenadas.get(i)[1] == hueco.getCoordenada()[1])){
                    huecos1.add(hueco);
                }
            }
        }
        this.huecos.clear();
        for(int i= 0; i< huecos1.size(); i++){
            huecos.add(huecos1.get(i));
        }
    }
    
    /**
     * Ordena las coordenadas con las condiciones de izquierda a derecha y de arriba a abajo.
     * @param aOrdenar, la lista de coordenadas a ordenar
     * @return aOrdenar, lista de coordenadas ordenada
     */
    private ArrayList<float[]> ordenar(ArrayList<float[]> aOrdenar) {
        int tamano= aOrdenar.size();
        for(int i= 0; i< tamano; i++){
            for(int j= i+1; j< tamano; j++){
                if( aOrdenar.get(i)[0] > aOrdenar.get(j)[0]){
                    float[] valor_x= aOrdenar.get(i);
                    aOrdenar.set(i,aOrdenar.get(j));
                    aOrdenar.set(j,valor_x);
                }
            }
        }
        return aOrdenar;
    }
}
