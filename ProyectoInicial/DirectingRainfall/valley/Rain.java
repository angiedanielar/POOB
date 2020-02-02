package valley;

import shapes.*;
import java.awt.geom.*;
import java.util.*;

/**
 * Crea la lluvia
 */
public class Rain {  
    private Ellipse2D drop;
    private boolean isVisible;
    protected ArrayList<Point> puntos;
    private String color;
    private float diametro;
    private String tipo;
    
    /**
     * Constructor de objetos de la clase Rain.
     */
    public Rain(String tipo,int x, int y) {
        puntos= new ArrayList<Point>();
        puntos.add(new Point(x,y));
        diametro = 5;
        isVisible= false;
        this.tipo= tipo;
        color= "blue";
        drop= new Ellipse2D.Double(puntos.get(0).getCoordenadas()[0], puntos.get(0).getCoordenadas()[1], diametro, diametro);
    }
    
    /**
     * @return, retorna la lluvia actual.
     */
    public Ellipse2D getRain() {
        return this.drop;
    }
    
    /**
     * @return, retorna las coordenadas actuales de la lluvia.
     */
    public float[] getCoordenada() {
        int puntoActual= this.puntos.size();
        float[] coordenadas = new float[2];
        coordenadas[0]= (float)this.puntos.get(puntoActual-1).getCoordenadas()[0];
        coordenadas[1]= (float)this.puntos.get(puntoActual-1).getCoordenadas()[1];
        return coordenadas;
    }
    
    public void changeColor(String color){
        this.color= color;
    }
    
    /**
     * retorna el tipo de lluvia que es
     * @return tipo
     */
    public String getTipo(){
        return this.tipo;
    }
    
    /**
     * Hace a la lluvia visible.
     */
    public void makeVisible() {
        this.isVisible= true;
        draw(); 
    }
    
    /**
     * Hace a la lluvia invisible.
     */
    public void makeInvisible() {
        erase();
        this.isVisible= false;
    }
    
    /**
     * Cambia la posicion de la lluvia.
     * @param x, nueva coordenada x
     * @param y, nueva coordenada y
     */
    public void changePosition(int newX, int newY) {
        Point puntoCheck= new Point(newX,newY);
        if(!(checkPoints(puntoCheck))){
            this.puntos.add(puntoCheck);
            int puntoActual= this.puntos.size();
            this.drop= new Ellipse2D.Double(this.puntos.get(puntoActual-1).getCoordenadas()[0], 
                                            this.puntos.get(puntoActual-1).getCoordenadas()[1], 
                                                                  this.diametro, this.diametro);
        }
        else{
            this.drop= new Ellipse2D.Double(puntoCheck.getCoordenadas()[0],puntoCheck.getCoordenadas()[1], 
                                                                             this.diametro, this.diametro);            
        }
        if(this.isVisible){
            makeVisible();
        }
    }
    
    /**
     * @return, retorna un cuadro delimitador de alta precision.
     */
    public Rectangle2D getBounds2D() {
        return drop.getBounds();
    }
    
    /**
     * @return, retorna las posicones de la lluvia.
     */
    public int[][] getPosiciones() {
        int[][] posiciones= new int[this.puntos.size()][2];
        for(int i= 0; i< this.puntos.size(); i++){
            posiciones[i]= this.puntos.get(i).getCoordenadas();            
        }
        return posiciones;
    }
    
    /**
     * Dibuja la lluvia.
     */
    private void draw() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,drop);
            canvas.wait(10);
        }
    }
    
    /**
     * Inicia el movimiento de esa lluvia.
     */
    public void startMove(ArrayList<Lona> trampas, int alto) {
        int deltaX= this.puntos.get(0).getCoordenadas()[0];
        for(int y = 0; y < alto; y++){
            changePosition(deltaX,y);
            for(Lona t: trampas){
                if(t.intersectaLona(getBounds2D())){
                    int[] posiHuecos= t.coordenadaHuecos();
                    y+= -1;
                    deltaX += moveRain(t.getPendiente());                       
                    for(int i= 0 ; i< t.getNumeroHuecos(); i++){
                        if(deltaX == posiHuecos[i]){
                            y+= 15;
                        }
                    }
                    changePosition(deltaX,y);
                }                    
            }
        }                    
    }
    
    /**
     * Mueve la lluvia verticalmente.
     * @return, distancia a mover
     */
    public int moveRain(double pendiente){
        int delta = 0;
        if (pendiente<0){
            delta = 1;
        }
        else if (pendiente>0){
            delta = -1;
        }
        return delta;
    }
    
    /**
     * Borra la lluvia.
     */
    private void erase() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    /**
     * Se encarga de chequear los puntos de la lluvia.
     * @return valor, si el punto actual es valido o no. 
     */
    private boolean checkPoints(Point puntoCheck){
        boolean valor= false;
        for(int i= 0; i< this.puntos.size(); i++){
            if (puntos.get(i).equals(puntoCheck)){
                valor= true;
                break;
            }
        }
        return valor;
    }
}
