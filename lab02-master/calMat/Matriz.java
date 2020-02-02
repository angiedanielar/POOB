import java.util.*;
/**
 * @author ECI, 2019
 *
 */
public class Matriz{
    public static Matriz UNCERO= new Matriz(new int[][]{{0}});
    private int [][] matriz;
    private int filas;
    private int columnas;
    
    /**
     * Crea una matriz dados sus elementos. Si hay error en datos, retorna la matriz [0]
     * @param elementos int[][], los elemtnos
     */
    public Matriz (int  elementos[][]) {
        this.matriz=(this.esValida(elementos))? elementos:UNCERO.getMatriz();
        filas= elementos.length;
        columnas= elementos[0].length;
    }   
    
    /**
     * Crea una matriz dada su diagonal. Si hay error en datos, retorna la matriz [0]
     * @param d int[], la diagonal
     */    
    public Matriz (int d []){
        matriz=new int[d.length][d.length]; 
        filas= d.length;
        columnas= d.length;
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                matriz[i][j]=(i==j)? d[i]:0;
            }
        }
    } 

    /**     
    * Crea una matriz de un numero repetido dada su dimension. Si hay error en datos, retorna la matriz [0]
    * @param e int, numero a repetir
    * @param f int, el numero de filas
    * @param c int, el numero de columnas
    */
    public Matriz (int e, int f, int c) {
       if((f> 0) && (c> 0)){
           matriz= new int[f][c];
           filas= f;
           columnas= c;
           for(int i= 0; i<f; i++){
               for(int j= 0; j<c; j++){
                   matriz[i][j]= e;
                }
           }
        }
        else{
            matriz= UNCERO.getMatriz();
        }        
      }
     
    /**
    * Crea una matriz dadas sus dimensiones. Si hay error en datos, retorna la matriz [0]
    * @param f int, el numero de filas
    * @param c int,el numero de columnas
    */
    public Matriz (int f, int c) {
       if((f> 0) && (c> 0)){
           this.filas = f;
           this.columnas = c;
           matriz= new int[f][c];
        }
        else{
            matriz= UNCERO.getMatriz();
        }        
    }
    
    /**
    * Crea una matriz identidad dada su dimension. Si hay error en datos, retorna la matriz [0]
    *@param n int, la dimension para crear la matriz cuadrada
    */
    public Matriz (int n){
        if(n>=0){
            matriz=new int[n][n];
            filas= n;
            columnas= n;
            for(int i=0;i<matriz.length;i++){
                for(int j=0;j<matriz[0].length;j++){
                    if (i==j){
                        matriz[i][j]=1;
                    }
                    else{
                        matriz[i][j]=0;
                    }
                }
            }
        }
        else{
            matriz= UNCERO.getMatriz(); 
        }
    }   
    
    /**
     * @return matrizNueva Matriz, retorna la matriz opuesta de la matriz dada. Si hay error en datos, retorna la matriz [0]
     */
    public Matriz opuesta(){
        Matriz matrizNueva;
        int[][] matriz= new int[this.filas][this.columnas];
        for(int i=0;i<this.matriz.length;i++){
            for(int j=0;j<this.matriz[i].length;j++){
                matriz[i][j]= (-this.matriz[i][j]);
            }
        }
        matrizNueva = new Matriz(matriz);
        return matrizNueva;
    }
    
    /**
     * @return matrizNueva Matriz, retorna la matriz transpuesta de la matriz dada. Si hay error en datos, retorna la matriz [0]
     */
    public Matriz transpuesta(){
        Matriz matrizNueva;
        int[][] matriz= new int[this.columnas][this.filas];
        for(int i=0;i<this.matriz.length;i++){
            for(int j=0;j<this.matriz[i].length;j++){
                matriz[i][j]=this.matriz[j][i];
            }
        }
        matrizNueva = new Matriz(matriz);
        return matrizNueva;
    }
    
    /**
     * @return matriz Matriz, retorna una matriz con la dimension de la matriz
     */
    public Matriz dimension(){
        Matriz matriz;
        int filas= this.filas;
        int columnas= this.columnas;
        int[][] array= {{filas,columnas}};
        matriz= new Matriz(array);
        return matriz;
    }
    
    /**
     * @return valor int, retorna el elemento en la posicion f,c de la matriz
     */
    public int get(int f, int c){
        int valor= matriz[f][c];
        return valor;
    }
    
    /**
    *@return same boolean, compara esta matriz con otra
    */ 
    public boolean equals (Matriz matrizOtra){
        boolean same = true;
        matriz=matrizOtra.getMatriz();
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                same=(this.matriz[i][j]==matriz[i][j])? same:false;
            }
        }
        return same;
    }

    /** 
    *@return same boolean, compara esta matriz con otra
    */
    @Override
    public boolean equals(Object objeto){
        boolean same = true;
        if (objeto == null){
            same = false;}
        if (getClass() != objeto.getClass()){
            same = false;}
        return same;
    }
    
    /** 
    * @return s String, retorna una cadena con los datos de la matriz alineado por columna
    */
    @Override
    public String toString () {
          String s = ""; 
          StringBuilder mat = new StringBuilder(); 
          for(int j= 0; j< this.columnas;j++){
              for(int i= 0; i< this.filas; i++){
                  mat.append(matriz[i][j]);
                }
              mat.append(" ");
            }
          s= mat.toString();
          return s;
    }   
    
    /** 
    * @return respuesta Matriz, retorna la matriz con el numero de filas o columnas
    */
    public Matriz sume(Matriz m){
        Matriz respuesta= null;
        int [][] dimensionM= m.dimension().getMatriz();
        if((this.filas == dimensionM[0][0]) && (this.columnas == dimensionM[0][1])){
            int [][] matrizM= m.getMatriz();
            int [][] suma= new int[this.filas][this.columnas];
            for (int i= 0; i< this.filas; i++){
                for (int j= 0; j< this.columnas; j++){
                    suma[i][j]= this.matriz[i][j] + matrizM[i][j];
                }
            }
            respuesta = new Matriz(suma);
        }
        else{
            respuesta= UNCERO;
        }
        return respuesta;
    }
    
    /**
    * @return respuesta Matriz, retorna la resta de las 2 matrices 
    */
    public Matriz reste(Matriz m){
        Matriz respuesta= null;
        int [][] dimensionM= m.dimension().getMatriz();
        if((this.filas == dimensionM[0][0]) && (this.columnas == dimensionM[0][1])){
            int [][] matrizM= m.getMatriz();
            int [][] resta= new int[this.filas][this.columnas];
            for (int i= 0; i< this.filas; i++){
                for (int j= 0; j< this.columnas; j++){
                    resta[i][j]= this.matriz[i][j] - matrizM[i][j];
                }
            }
            respuesta = new Matriz(resta);
        }
        else{
            respuesta= UNCERO;
        }
        return respuesta;
    }
    
    /** 
    * @return respuesta Matriz, retorna una matriz de un elemento siendo el valor de la suma de los elementos de la matriz
    */
    public Matriz sume(){
        Matriz respuesta;
        int [][] suma= new int[1][1];
        int valor= 0;
        for(int i=0;i< filas;i++){
            for(int j=0;j< columnas;j++){
                valor+= matriz[i][j];
            }
        }
        suma[0][0]= valor;
        respuesta= new Matriz(suma);
        return respuesta;
    }    
   
    /** 
    * @param foc char, indica si la suma es por filas('f') o por columnas('c')
    */
    public Matriz sume(char foc){
        Matriz respuesta= null;
        int[][] operacion= null;
        if (foc == 'f'){
            operacion= sumaFilas();
        }
        else if(foc == 'c'){
            operacion= sumaColumnas();          
        }
        respuesta= new Matriz(operacion); 
        return respuesta;
    }
    
    /**
     * realiza la operacion sobre la matriz y retorna una matriz con la respuesta
     * @param Rchar, 'm' el minimo de la matriz, 'M' el maximo de la matriz,'-' promedio de los valores de la matriz
     * @return respuesta, Matriz de 1*1 con la respuesta
     */
    public Matriz opereMatriz(char Rchar){
        Matriz respuesta= null;
        int [][] operacion= null;
        if (Rchar == 'm'){
            operacion= minimoMatriz();
        }
        else if (Rchar == 'M'){
            operacion= maximoMatriz();
        }
        else if (Rchar == '-'){
            operacion= promedioMatriz();
        }
        respuesta= new Matriz(operacion);
        return respuesta;
    }
    
    /**
     * realiza la operacion sobre la fila (fil)  y retorna una matriz con la respuesta
     * @param Rchar, 'm' el minimo de la matriz, 'M' el maximo de la matriz,'-' promedio de los valores de la matriz, 
     * @return respuesta, Matriz de 1*1 con la respuesta
     */
    public Matriz opereFila(char Rchar, int fil){
        Matriz respuesta= null;
        Matriz filaOperar= new Matriz(getFila(fil));
        if (Rchar == 'm'){
            respuesta= filaOperar.opereMatriz(Rchar);
        }
        else if (Rchar == 'M'){
            respuesta= filaOperar.opereMatriz(Rchar);
        }
        else if (Rchar == '-'){
            respuesta= filaOperar.opereMatriz(Rchar);
        }        
        return respuesta;
    }
    
    /**
     * realiza la operacion sobre la columna (colum)  y retorna una matriz con la respuesta
     * @param Rchar, 'm' el minimo de la matriz, 'M' el maximo de la matriz,'-' promedio de los valores de la matriz
     * @return respuesta, Matriz de 1*1 con la respuesta
     */
        public Matriz opereColumna(char Rchar, int fil){
        Matriz respuesta= null;
        Matriz filaOperar= new Matriz(getFila(fil));
        if (Rchar == 'm'){
            respuesta= filaOperar.opereMatriz(Rchar);
        }
        else if (Rchar == 'M'){
            respuesta= filaOperar.opereMatriz(Rchar);
        }
        else if (Rchar == '-'){
            respuesta= filaOperar.opereMatriz(Rchar);
        }
        return respuesta;
    }
    
    /**
     * @return matriz int[][],retorna la matriz 
     */
    public int[][] getMatriz(){
        return matriz;
    } 
    
    /**
     * prueba si la matriz elementos es valida
     * @param elementos int[][], matriz a probar
     * @return ans boolean, el valor de si es...
     */
    private boolean esValida(int[][] elementos){
        boolean ans=true;
        int value=elementos[0].length;
        for(int i=0;i<elementos.length;i++){
            ans=(elementos[i].length==value)? ans:false;
        }
        return ans;
    }
    
    /**
     * retorna la suma de las filas 
     * @return respuestas int[][] , retorna la suma de los elementos de las filas de la matriz
     */
    private int[][] sumaFilas(){
        int [][] respuestas= new int [this.filas][1];
        for(int i= 0; i< this.filas; i++){
            int cont= 0;
            for (int j= 0; j< this.columnas; j++){
                cont+= this.matriz[i][j];
            }
            respuestas[i][0]= cont;
        }
        return respuestas;
    }
    
    /**
     * retorna la suma de las columnas 
     * @return respuestas int[][], retorna la suma de los elementos de las columnas de la matriz
     */
    private int[][] sumaColumnas(){
        int [][] respuestas= new int [1][this.columnas];
        for(int i= 0; i< this.columnas; i++){
            int cont= 0;
            for (int j= 0; j< this.filas; j++){
                cont+= this.matriz[j][i];
            }
            respuestas[0][i]= cont;
        }
        return respuestas;
    }
    
    /**
     * retorna el minimo de la matriz
     * @return respuesta int[][], retorna el minimo de los elementos de la matriz
     */
    private int[][] minimoMatriz(){
        int[][] respuesta = new int[1][1];
        int valor= 1000000000;
        for (int i= 0; i< this.filas; i++){
            for(int j= 0; j< this.columnas; j++){
                if(valor> this.matriz[i][j]){
                    valor= this.matriz[i][j];
                }
            }
        }
        respuesta[0][0]= valor;
        return respuesta;
    }
    
    /**
     * retorna el maximo de la matriz
     * @return respuesta int[][], retorna el maximo de los elementos de la matriz
     */
    private int[][] maximoMatriz(){
        int[][] respuesta = new int[1][1];
        int valor= -1000000000;
        for (int i= 0; i< this.filas; i++){
            for(int j= 0; j< this.columnas; j++){
                if(valor> this.matriz[i][j]){
                    valor= this.matriz[i][j];
                }
            }
        }
        respuesta[0][0]= valor;
        return respuesta;
    }
    
    /**
     * retorna el entero mas cercano al promedio de los elementos de la matriz
     * @return respuesta int[][], retorna el promedio de los elementos de la matriz
     */
    private int[][] promedioMatriz(){
        int[][] respuesta = new int[1][1];
        int cont= 0;
        for (int i= 0; i< this.filas; i++){
            for(int j= 0; j< this.columnas; j++){
                cont += this.matriz[i][j];
            }
        }
        int valor= (int) (cont/(this.filas*this.columnas));
        respuesta[0][0]= valor;
        return respuesta;
    }
    
    /**
     * retorna una matriz con los valores de la fila selecionada
     * @return fila int[][], retorna los valores de la fila seleccionada 
     */
    private int[][] getFila(int fil){
        int[][] valFila= new int[1][this.columnas];
        valFila[0]= this.matriz[fil];
        return valFila;
    }
    
    /**
     * retorna una matriz con los valores de la columna selecionada
     * @return fila int[][], retorna los valores de la columna seleccionada 
     */
    private int[][] getColumna(int col){
        int[][] valColumna= new int[this.filas][1];
        for(int i= 0; i< this.filas; i++){
            valColumna[i][0]= this.matriz[i][col];
        }
        return valColumna;
    }
}
