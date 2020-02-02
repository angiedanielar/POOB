package valley;

import shapes.*;
import java.awt.Toolkit;
import java.util.*;
import java.awt.geom.*;

/**
 * Creamos a Valley.
 * @author (Ernesto Camacho y Daniela Ruiz) 
 * @version (18/10/2019)
 */
public class Valley {
    private Rectangulo valle;
    private boolean isVisible;
    private static int alto;
    private static int ancho;
    private ArrayList<Lona> trampas;
    private ArrayList<Vinedo> vinedos;
    private ArrayList<String> nombres;
    private ArrayList<Rain> rain;
    private ErrorMessage error;  
    private boolean okFlag;
    private Stack<String>methods;
    private boolean undo;
    private Stack<Object>param;    
    
    /**
     * Constructor de objetos de la clase Valley.
     */
    public Valley(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
        isVisible = false;
        hacerValle();
        okFlag= true;
        methods=new Stack<String>();
        param=new Stack<Object>();
        undo=false;
    }
    
    /**
     * Crea las caracteriasticas del valle.
     */
    private void  hacerValle() {  
       valle = new Rectangulo(alto, ancho, 0,"lightGray");
       trampas= new ArrayList<Lona>();
       vinedos= new ArrayList<Vinedo>();
       nombres= new ArrayList<String>();
       rain= new ArrayList<Rain>();                 
    }  
    
    /**
     *@param c, es el caracter que nos indica si quiere acercar o alejar el valle, '-' para alejar el valle o '+' para acercar el valle.
     */
    public void zoom(char c) {
        if (c == '+' || c == '-'){
            Canvas canvas = Canvas.getCanvas();
            canvas.zoom(c);
            canvas.setVisible(false);
            methods.push("zoom");
            param.push(c);
            this.okFlag=true;
        }
        else{
            if (this.isVisible){
                error= new ErrorMessage();
            }
            this.okFlag=false;
        }
    }
    
    /**
     * REDO/UNDO.
     * @param c, el caracter que nos indica si quiere desahacer o rehacer la ultima operacion relaizada 'R' para rehacer la ultima operacion relaizada o 
     * 'U' para deshacer la ultima operacion relaizada. Do es reservado en java para el do while. Entonces para cumplir con el estandar que se usa para 
     * nombrar los metodos usamos does.
     */
    public void does(char d) {
        if (d == 'U' || d == 'R'){
            if (d == 'U'){
                undo();
            }
            else{
                redo();
            }
        }
        else{
            if (this.isVisible){
                error= new ErrorMessage();
            }
            this.okFlag=false;
        }
    }
    
    /**
     * Crea un nuevo vinedo, donde la coordeanada "y" de los puntos es el alto del valle.
     * @param name, nombre del nuevo vinedo
     * @param xi , punto inicial del vinedo
     * @param xf, punto final del vinedo
     */
    public void openVineyard(String name, int xi, int xf) {
        if (checkVineyard(name, xi, xf)){
            nombres.add(name);
            vinedos.add(new Vinedo(xi,xf,this.alto, this.alto));
            asignaColor(name);
            trapColor();
            this.okFlag=true;
            methods.push("openVineyard");
            param.push(name);
        }
        else{
            this.okFlag=false;
            if (this.isVisible){
                error= new ErrorMessage();
            }
        }
        if(this.isVisible){
            makeVisible();
        }
    }
    
    /**
     * Cierra el vinedo especificado, no cierra si no existe un vinedo con ese nombre.
     * @param name, nombre del vinedo a cerrar
     */
    public void closeVineyard(String name) {
        int indexVinedo= nombres.indexOf(name);
        if (indexVinedo!= -1){
            int[] cor= vinedos.get(indexVinedo).getCoordenadas();
            methods.push("closeVineyard");
            param.push(name);
            param.push(cor[0]);
            param.push(cor[1]);
            vinedos.get(indexVinedo).makeInvisible();
            vinedos.remove(indexVinedo);
            nombres.remove(indexVinedo);
            trapColor();
            this.okFlag=true;
        }
        else{
            this.okFlag=false;
            if (this.isVisible){
                error= new ErrorMessage();
            }
        }
        if(this.isVisible){
            makeVisible();
        }
    }
       
    /**
     * crea una nueva trampa al valle.
     * @param type, el tipo de lona que desea crear
     * @param lowerEnd, array con 2 enteros coordenadas del punto inferior
     * @param higherEnd, array con 2 enteros coordenadas del punto superior 
     */
    public void  addTarp(String type, int[] lowerEnd, int[] higherEnd) {
        if (checkTrap(lowerEnd, higherEnd)){
            if(type.equals("Normal")){
                trampas.add(new LonaNormal(lowerEnd,higherEnd, this.alto));
            }
            else if(type.equals("Radical")){
                trampas.add(new LonaRadical(lowerEnd,higherEnd, this.alto));
            }
            else if(type.equals("Hard")){
                trampas.add(new LonaHard(lowerEnd,higherEnd, this.alto));
            }
            else if(type.equals("Flexible")){
                trampas.add(new LonaFlexible(lowerEnd,higherEnd, this.alto));
            }
            else if(type.equals("Inmutable")){
                trampas.add(new LonaInmutable(lowerEnd,higherEnd, this.alto));
            }
            asignaPosicionTrampas();
            trapColor();
            this.okFlag=true;
            methods.push("addTarp");
            param.push(lowerEnd);
            param.push(higherEnd);  
        }
        else{
            this.okFlag=false;
            if (this.isVisible){
                error= new ErrorMessage();
            }
        }
        if(this.isVisible){
            makeVisible();
        }
    }
    
    /**
     * Remueve la trampa en la posicion indicada.
     * @param posicion, la posicion de la trampa a remover
     */
    public void removeTarp(int posicion) {
        if(posicion<= this.trampas.size()){            
            if(trampas.get(posicion-1).getTipo().equals("Hard")){
                this.okFlag=false;
            }
            else{
                methods.push("removeTarp");
                int[] coordenadas= trampas.get(posicion-1).getCoordenadas();
                int[] lower=  {coordenadas[0], coordenadas[2]};
                int[] higher= {coordenadas[1], coordenadas[3]};
                param.push(lower);
                param.push(higher);
                param.push(trampas.get(posicion-1).getTipo());
                this.trampas.remove(posicion-1);
                asignaPosicionTrampas();
                this.okFlag=true;
            }                        
        }
        else{
            this.okFlag=false;
            if (this.isVisible){
                error= new ErrorMessage();
            }
        }
        if(this.isVisible){
            makeVisible();
        }
    }
    
    /**
     * Hace visible el valle y los elementos ya creados visibles.
     */
    public void makeVisible() {
        this.isVisible= true;
        valle.makeVisible();
        
        Iterator<Vinedo> iteradorVinedo= vinedos.iterator();
        while(iteradorVinedo.hasNext()){
            Vinedo vinedo= iteradorVinedo.next();
            vinedo.makeVisible();          
        }
        Iterator<Lona> iteradorLona= trampas.iterator();
        while(iteradorLona.hasNext()){
            Lona lona= iteradorLona.next();
            lona.makeVisible();
        }
        for(int i=0 ; i<this.rain.size();i++){
            this.rain.get(i).makeVisible();
        }
    }
    
    /**
     * Hace invisible el valle y los elementos ya creados invisibles.
     */
    public void makeInvisible() {
        this.isVisible= false;
        valle.makeInvisible();

        Iterator<Vinedo> iteradorVinedo= vinedos.iterator();
        while(iteradorVinedo.hasNext()){
            Vinedo vinedo= iteradorVinedo.next();
            vinedo.makeInvisible();       
        }
        Iterator<Lona> iteradorLona= trampas.iterator();
        while(iteradorLona.hasNext()){
            Lona lona= iteradorLona.next();
            lona.makeInvisible();         
        }
        for(int i=0 ; i<this.rain.size();i++){
            this.rain.get(i).makeInvisible();
        }
    }
    
    /**
     * @return, Retorna el valor de okFlag.
     */
    public boolean ok() {
        return okFlag;
    }
    
    /**
     * Hace un hueco en la trampa de la posicion seleccionada y la coordenada seleccionada.
     * @param trap, trampa en la posicion indicada
     * @param posicion, coordenada del hueco
     */
    public void makePuncture(int trap,int x) {//Problema con el posicion que le entra a param
        if(trap<= this.trampas.size()){
            trampas.get(trap-1).makePuncture(x);
            if(trampas.get(trap-1).ok()){
                this.okFlag= true;
                methods.push("makePuncture");
                param.push(trap);
                param.push(x);
            }
            else{
                this.okFlag=false;
                if (this.isVisible){
                    error= new ErrorMessage();
                }                
            }
        }     
        else{
            this.okFlag=false;
            if (this.isVisible){
                error= new ErrorMessage();
            }
        }
        if(this.isVisible){
            makeVisible();
        }        
    }
    
    /**
     * Remueve un hueco en la trampa de la posicion seleccionada y la coordenada seleccionada.
     * @param trap, trampa en la posicion indicada
     * @param posicion, coordenada del hueco
     */
    public void patchPuncture(int trap,int posicion) {//Problema con el posicion que le entra a param
        if(trap<= this.trampas.size()){
            if(posicion <= trampas.get(trap-1).getNumeroHuecos()){
                methods.push("patchPuncture");
                param.push(trap);
                param.push(posicion-1);
                trampas.get(trap-1).patchPuncture(posicion-1);
                this.okFlag= true;
            } 
            else{
                this.okFlag=false;
                if (this.isVisible){
                    error= new ErrorMessage();
                }
            }
        }     
        else{
            this.okFlag=false;
            if (this.isVisible){
                error= new ErrorMessage();
            }
        }
        if(this.isVisible){
            makeVisible();
        }
    }
    
    /**
     * Detiene la lluvia en la posicion indicada.
     * @param posicion, posicion de la lluvia a parar
     */
    public void stopRain(int posicion) {
        if(posicion <= this.rain.size()){
            if(!checkStraight(rain.get(posicion-1)) && rain.get(posicion-1).getTipo().equals("Straight")){
                this.okFlag= false;
            }
            else{
                methods.push("stopRain");
                float[] coordenadas = rain.get(posicion-1).getCoordenada();
                int x = (int)coordenadas[0];
                param.push(x);
                param.push(rain.get(posicion-1).getTipo());
                this.rain.get(posicion-1).makeInvisible();
                this.rain.remove(posicion-1);
                asignaPosicionRain();
                this.okFlag=true;
            }            
        }
        else{
            this.okFlag=false;
            if (this.isVisible){
                error= new ErrorMessage();
            }
        }
        if(this.isVisible){
            makeVisible();
        }
    }
        
    /**
     * Inicia la lluvia en la posicion indicada.
     * @param type, el tipo de lluvia que va a ser
     * @param posicion, posicion de la lluvia a empezar
     */
    public void startRain(String type, int x) {
         if(x<= this.ancho){
            if(type.equals("Acid")){
                rain.add(new LluviaAcida(x,0));
            }
            else if(type.equals("Normal")){
                rain.add(new LluviaNormal(x,0));
            }
            else if(type.equals("Pegajosa")){
                rain.add(new LluviaPegajosa(x,0));
            }
            else if(type.equals("Straight")){
                rain.add(new LluviaStraight(x,0));
            }
            methods.push("startRain");            
            this.okFlag= true;
        }        
        else{
            this.okFlag=false;
            if (this.isVisible){
                error= new ErrorMessage();
            }
        }
        if(this.isVisible){
            makeVisible();
        }
    }
    
    /**
     * Mueve la lluvia.
     */
    private void startRains() {
        if(this.isVisible){
            makeVisible();
        }
        for(Rain r:rain){
            r.startMove(this.trampas,this.alto);
        }
    }
    
    private boolean checkStraight(Rain rainc){
        boolean valor= false;
        Rectangle2D delimitador = rainc.getBounds2D();
        for(int j= 0; j< this.vinedos.size(); j++){
            if (delimitador.intersectsLine(vinedos.get(j).getLinea())){
                valor= true;
                break;
            }
        }
        return valor;
    }
    
    /**
     * @return rainF, retorna los nombres de los vinedos que estan recibiendo lluvia
     */
    public String[] rainFalls() {        
        ArrayList<String> rainFall = new ArrayList<String>();
        startRains();
        for (int i= 0; i< this.rain.size(); i++){
            Rectangle2D delimitador = rain.get(i).getBounds2D();
            for(int j= 0; j< this.vinedos.size(); j++){
                if (delimitador.intersectsLine(vinedos.get(j).getLinea())){
                    rainFall.add(vinedos.get(j).getName());
                }
            }
        }
        String[] rainF = new String[rainFall.size()];
        for (int i= 0; i< rainFall.size(); i++){
            rainF[i]= rainFall.get(i);
        }
        return rainF;
    }
    
    /**
     * @return vineyards, retorna las posiciones de los vinedos
     */
    public int[][] vineyards() {
        int[][] vineyards= new int[this.vinedos.size()][2];
        for(int i= 0; i< this.vinedos.size();i++){ 
            int[] cords= vinedos.get(i).getCoordenadas();
            vineyards[i][0]= cords[0];
            vineyards[i][1]= cords[2];
        }
        return vineyards;
    }
    
    /**
     * @return traps, retorna las posiciones de las trampas y sus huecos
     */
    public int[][][] tarps() {
        int[][][] traps= new int[this.trampas.size()][3][];
        for(int i= 0; i< this.trampas.size();i++){
            int[] coordenadas= trampas.get(i).getCoordenadas();
            int[] lower=  {coordenadas[0], coordenadas[2]};
            int[] higher= {coordenadas[1], coordenadas[3]};
            traps[i][0]= lower;
            traps[i][1]= higher;
            traps[i][2]= trampas.get(i).coordenadaHuecos();
        }
        return traps;
    }
    
    /**
     * @return rains, retorna los recorridos de las lluvias
     */
    public int[][][] rains() {
        int[][][] rains= new int[this.rain.size()][][];
        for(int i= 0; i< this.rain.size();i++){            
            rains[i]= rain.get(i).getPosiciones();
        }
        return rains;
    }
    
    /**
     * Asigna color a cada vinedo.
     * @param nombreVinedo, viendo al cual se le asigna un color
     */
    private void asignaColor(String nombreVinedo) {
        int vinedoColor= nombres.indexOf(nombreVinedo);
        vinedos.get(vinedoColor).changeColor(nombreVinedo);
    }
    
    /**
     * Asigna la posicion de las trampas.
     */
    private void asignaPosicionTrampas() {
        ArrayList<float[]> coordenadas= new ArrayList<float[]>();
        ArrayList<Lona> lona1= new ArrayList<Lona>();
        Iterator<Lona> iteradorTrampas= this.trampas.iterator();
        while (iteradorTrampas.hasNext()){
            Lona trampa= iteradorTrampas.next();
            coordenadas.add(trampa.getCoordenada());
        }
        coordenadas= ordenar(coordenadas);
        int tamano= coordenadas.size();
        for(int i= 0; i< tamano; i++){
            Iterator<Lona> iteradorTrampas1= this.trampas.iterator();
            while (iteradorTrampas1.hasNext()){
                Lona trampa= iteradorTrampas1.next();
                if(coordenadas.get(i)[0]==trampa.getCoordenada()[0] && coordenadas.get(i)[1]==trampa.getCoordenada()[1]){
                    lona1.add(trampa);
                }
            }
        }
        this.trampas.clear();  
        for(int i=0;i<lona1.size();i++){
            this.trampas.add(lona1.get(i));
        }
    }
    
    /**
     * Asigna la posicion de las lluvias.
     */
    private void asignaPosicionRain() {
        ArrayList<float[]> coordenadas= new ArrayList<float[]>();
        ArrayList<Rain> lluvia1= new ArrayList<Rain>();
        Iterator<Rain> iteradorRain= this.rain.iterator();
        while (iteradorRain.hasNext()){
            Rain lluvia= iteradorRain.next();
            coordenadas.add(lluvia.getCoordenada());
        }
        coordenadas= ordenar(coordenadas);
        int tamano= coordenadas.size();
        for(int i= 0; i< tamano; i++){
            Iterator<Rain> iteradorRain1= this.rain.iterator();
            while (iteradorRain1.hasNext()){
                Rain lluvia= iteradorRain1.next();
                if(coordenadas.get(i)[0]==lluvia.getCoordenada()[0] && coordenadas.get(i)[1]==lluvia.getCoordenada()[1]){
                    lluvia1.add(lluvia);
                }
            }
        }
        this.rain.clear();  
        for(int i=0;i<lluvia1.size();i++){
            this.rain.add(lluvia1.get(i));
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
                    float[] valorX= aOrdenar.get(i);
                    aOrdenar.set(i,aOrdenar.get(j));
                    aOrdenar.set(j,valorX);
                }
            }
        }
        for(int i= 0; i< tamano; i++){
            for(int j= i+1; j< tamano; j++){
                if( aOrdenar.get(i)[0] == aOrdenar.get(j)[0]){
                    if(aOrdenar.get(i)[1] > aOrdenar.get(j)[1]){
                        float[] valorY= aOrdenar.get(i);
                        aOrdenar.set(i,aOrdenar.get(j));
                        aOrdenar.set(j,valorY);
                    }
                }
            }
        }
        return aOrdenar;
    }
    
    /**
     * Se encarga de chequear si el vinedo a crear es valido, si no se interseca con ninguna trampa o vinedo, y si no existe otro con el mismo nombre.
     * @param name, nombre del vinedo a probar
     * @param xi, coordenada inicial del vinedo
     * @param xf, coordenada final del vinedo
     * @return valor, si puede crear o no el vinedo
     */
    private boolean checkVineyard(String name, int xi, int xf) {
        boolean valor= false;
        int [] firstPoint= {xi,0};
        int [] secondPoint= {xf,0};
        String[] colores= {"red","blue","yellow","green","magenta","white","orange","cyan","pink","gray","darkGray"};
        if (Arrays.asList(colores).contains(name)){
            if(checkPoints(firstPoint,secondPoint)){
                valor= true;
                int indexVinedo= nombres.indexOf(name);
                if (indexVinedo== -1){
                    Vinedo prueba= new Vinedo(xi,xf,this.alto, this.alto);
                    Segmento pruebaSeg= prueba.getVinedo();
                    for (int i= 0; i< this.trampas.size(); i++){ 
                        if(trampas.get(i).getLona().intersecta(pruebaSeg)){
                            valor= false;
                            break;
                        }
                    }
                    for (int i= 0; i< this.vinedos.size(); i++){ 
                        if(!valor){
                            break;
                        }
                        if(vinedos.get(i).getVinedo().intersecta(pruebaSeg)){
                            valor= false;
                            break;
                        }
                    }
                }
                else {
                    valor= false;
                }
            }        
        }        
        return valor;
    }
    
    /**
     * Se encarga de determinar y asignar el color de la trampa.
     */
    private void trapColor() {
      for(int t= 0; t< this.trampas.size(); t++){
          trampas.get(t).changeColor("black");
          Segmento lonaActual = trampas.get(t).getLona();
          for(int v= 0; v< this.vinedos.size(); v++){
              String color= vinedos.get(v).getColor();
              Segmento vinedoActual= vinedos.get(v).getVinedo();
              if(vinedoActual.contains(lonaActual)){
                  trampas.get(t).changeColor(color);
                }
            }
        }      
    }
    
    /**
     * Se encarga de chequear si la trampa a crear es valida y si no se interseca con ninguna trampa o vinedo.
     * @param lowerEnd, coordenada 
     * @param higherEnd, coordenada 
     * @return valor, si puede crear o no la trampa
     */
    private boolean checkTrap(int[] lowerEnd, int[] higherEnd) {
        boolean valor= false;
        if(checkPoints(lowerEnd,higherEnd)){
            valor= true;
            int tamanoTrampas= trampas.size();
            int tamanoVinedos= vinedos.size();
            Lona lonaParaProbar= new LonaNormal(lowerEnd, higherEnd, this.alto);
            for (int i= 0; i< tamanoTrampas; i++){ 
                if(trampas.get(i).getLona().intersecta(lonaParaProbar.getLona())){
                    valor= false;
                    break;
                }
            }
            for (int i= 0; i< tamanoVinedos; i++){ 
                if(vinedos.get(i).getVinedo().intersecta(lonaParaProbar.getLona())){
                    valor= false;
                    break;
                }
            }         
        }
        return valor;
    }
    
    /**
     * Se encarga de hacer el check de que los puntos sean validos.
     * @param puntoA, punto inical a chequear 
     * @param puntoB, punto final a chequear
     */
    private boolean checkPoints(int[] puntoA, int[] puntoB) {
        boolean valor= false;
        if((0<= puntoA[0] && puntoA[0]<= this.ancho) &&
           (0<= puntoA[1] && puntoA[1]<= this.alto) &&
           (0<= puntoB[0] && puntoB[0]<= this.ancho) &&
           (0<= puntoB[1] && puntoB[1]<= this.alto)){
               valor= true;
        }
        return valor;
    }
    
    /**
     * REDO. REHACER la accion que se realizo antes, al hacer el metodo deshacer igual se vuelve a guardar la ultima operacion relizada, para asi poder 
     * rehacerla deshaciendo lo que deshicimos, respetando que solo se puede hacer undo y redo sobre la operacion inmediatamente anterior. 
     */
    private void redo() {
        if(methods.isEmpty()){
            this.okFlag=false;
            return;
        }
        if (undo==true){
            undo();
            undo = false;
        }
    }
    
    /**
     * UNDO. DESHACER la accion que se hizo antes, compara el ultimo metodo agregado al stack con los metodos que se tienen y se hace la operacion inversa
     * a la eliminada para asi deshacer la operacion realizada inmediatamente anterior, guardando igualmnente la ultima operacion relaizada al stack.
     */
    private void undo() {
        if(methods.isEmpty()){
            if (this.isVisible){
                error= new ErrorMessage();
            }
            this.okFlag=false;
            return;
        }
        String method = methods.pop();
        if(method.equals("openVineyard")){
            String name = (String)param.pop();
            closeVineyard(name);
            this.okFlag=true;
        }
        if(method.equals("zoom")){
            char c = (char)param.pop(); 
            if(c =='+'){
                zoom('-');
            }
            else{
                zoom('+');
            }
            this.okFlag=true;
        }
        if(method.equals("closeVineyard")){
            int xf = (int)param.pop();
            int xi = (int)param.pop();
            String name = (String)param.pop();
            openVineyard(name,xi,xf);
            this.okFlag=true;
        }
        if(method.equals("addTarp")){
           int[] higherEnd = (int[])param.pop();
           int[] lowerEnd = (int[])param.pop();
           for(int i= 0; i<trampas.size();i++){
               Lona trampaActual= trampas.get(i);
               if ((lowerEnd[0]== trampaActual.getCoordenadas()[0]) && (lowerEnd[1]== trampaActual.getCoordenadas()[2]) &&
                   (higherEnd[0]== trampaActual.getCoordenadas()[1]) && (higherEnd[1]== trampaActual.getCoordenadas()[3]))
                   {
                       removeTarp((i+1));
                       break;
                }
           }
           this.okFlag=true;
           if(this.isVisible){
               makeVisible();
            }
        }
        if(method.equals("removeTarp")){
           String type= (String) param.pop();
           int[] higherEnd = (int[]) param.pop();
           int[] lowerEnd = (int[]) param.pop();            
           addTarp(type,lowerEnd,higherEnd);
           this.okFlag=true;
           if(this.isVisible){
               makeVisible();
            }
        }  
        if(method.equals("makePuncture")){
            int x = (int)param.pop();
            int trap = (int)param.pop();
            patchPuncture(trap,x);
            this.okFlag=true;
        }
        if(method.equals("patchPuncture")){
            int posicion = (int)param.pop();
            int trap = (int)param.pop();
            makePuncture(trap,posicion);
            this.okFlag=true;
        }
        if(method.equals("startRain")){
            int coordenada = (int)param.pop();
            stopRain(coordenada);
            this.okFlag=true;
        }
        if(method.equals("stopRain")){
            String type= (String)param.pop();
            int x = (int)param.pop();
            startRain(type,x);
            this.okFlag=true;
        }
        undo=true;
    } 
    
    /**
     * Termina la ejecucion del programa.
     */
    public void finish() {
        System.exit(0);
    }
}
