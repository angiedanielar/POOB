import java.util.Stack;

/** Calculadora.java
 * Representa una calculadora de matrices
 * @author ESCUELA 2019-02
 */
    
public class CalMat{
    private Stack<Matriz> operandos;
    private boolean okFlag;
    
    public CalMat(){
        operandos= new Stack();
        okFlag= false;
    }

    /** 
    * Empila una nueva matriz al stack
    * @param matriz int[][], los elementos a empilar
    */
    public void empile(int[][] matriz){
        operandos.push(new Matriz(matriz));
    }
    
    /** 
    * Empila una nueva matriz al stack dada su diagonal
    * @param diagonal int[], los elementos a empilar en la diagonal 
    */
    public void empile(int [] diagonal){
        operandos.push(new Matriz(diagonal));
    }
    
    /** 
    * Emplia todos los elementos que son e
    * @param e int, el elemnto repetido a empilar
    * @param filas int, el numero de filas a empilar
    * @param columnas int, el numero de columnas a empilar
    */
    public void empile(int e, int filas, int columnas){
        operandos.push(new Matriz(e, filas, columnas));
    }

    /** 
    * Empila los elemntos de la identidad de dimension d
    * @param d int, la dimension de la matriz a empilar
    */
    public void empile(int d){
        operandos.push(new Matriz(d));
    }
    
    /** 
    * Desempila el ultimo elemento del stack
    */
    public void desempile(){
        operandos.pop();
    }

    /** 
    * @return consulta String, consulta el primer elemnto del stack
    */
    public String consulte(){
       String consulta= operandos.peek().toString();
       return consulta;
    }
    
    /** 
    * @return  res Matriz, retorna la matriz multiplicacion matricial, sino la matriz UNCERO
    */
    public Matriz multiplicarMatrialcal(Matriz matri, Matriz matriDos){
        int [][] valores = matri.dimension().getMatriz();
        int filasMatri = valores[0][0];
        int clumnasMatri = valores[0][1];
 
        int [][] values = matri.dimension().getMatriz();
        int filasMatriDos = valores[0][0];
        int columnasMatriDos = valores[0][1];

        if(clumnasMatri != filasMatriDos) {
            return Matriz.UNCERO;
        }
        else {
            Matriz res = new Matriz(filasMatri,columnasMatriDos);
            for (int i = 0; i < filasMatri; i++) {
                for (int j = 0; j < columnasMatriDos; j++) {
                    int x = 0;
                    for (int k = 0; k < filasMatriDos; k++) {
                        x += matri.getMatriz()[i][j] * matriDos.getMatriz()[k][j];

                    }
                    res.getMatriz()[i][j] = x;

                }
            }
            return res;
        }
    }
    
    /** 
    * @return res Matriz , retorna la matriz multiplicada uno a uno
    */
    public Matriz multiplicarPunto(Matriz matri1, Matriz matri2){
        int [][] dimension = matri1.dimension().getMatriz();
        int [][] valores1 = matri1.getMatriz();
        int [][] valores2 = matri2.getMatriz();
        int filas = dimension[0][0];
        int columnas = dimension[0][1];
        int [][] respuesta= new int[filas][columnas];
        for(int i=0;i< filas;i++){
            for(int j=0;j< columnas;j++){
                respuesta[i][j] = valores1[i][j] * valores2[i][j];
            }
        }
        Matriz res= new Matriz(respuesta);
        return res;
    }

    /** 
    *  Los operadores binarios : + (suma), - (resta), . (multiplique elemento a elemento), * (multiplique matricial)
    */
    public void opereMatrices(char operacion){
        Matriz matA= operandos.pop();
        Matriz matB= operandos.pop();
        Matriz respuesta= null;
        if(operacion == '+'){
            respuesta= matA.sume(matB);
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matB);
                operandos.push(matA);
                okFlag= false;
            }
        }
        else if(operacion == '-'){
            respuesta= matA.reste(matB);
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matB);
                operandos.push(matA);
                okFlag= false;
            }
            
        }
        else if(operacion == '.'){
            respuesta= multiplicarPunto(matA,matB);
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matB);
                operandos.push(matA);
                okFlag= false;
            }
        }
        else if(operacion == '*'){
            respuesta= multiplicarMatrialcal(matA,matB);
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matB);
                operandos.push(matA);
                okFlag= false;
            }
        }
        else{
            operandos.push(matB);
            operandos.push(matA);
            okFlag= false;
        }
    }
    
    /** 
    *  Los operadores son: + (suma),  - (promedio), m (minimo), M (maximo), d(dimensones)
    *  Los operadores consideran todos los elementos de la matriz
    */
    public void opereMatriz(char operacion){
        Matriz matA= operandos.pop();
        Matriz respuesta= null;
        if(operacion == '+'){
            respuesta= matA.opereMatriz(operacion);
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matA);
                okFlag= false;
            }
        }
        else if(operacion == '-'){
            respuesta= matA.opereMatriz(operacion);
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matA);
                okFlag= false;
            }
            
        }
        else if(operacion == 'm'){
            respuesta= matA.opereMatriz(operacion);
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matA);
                okFlag= false;
            }
        }
        else if(operacion == 'M'){
            respuesta= matA.opereMatriz(operacion);
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matA);
                okFlag= false;
            }
        }
        else if(operacion == 'd'){
            respuesta= matA.dimension();
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matA);
                okFlag= false;
            }
        }
        else{
            operandos.push(matA);
            okFlag= false;
        }
    }
      
    /** 
    *  Los operadores son: + (suma),  - (promedio), m (minimo), M (maximo)
    *  Las operaciones se realizan por filas 
    */
    public void opereFilas(char operacion){
        Matriz matA= operandos.pop();
        Matriz respuesta= null;
        if(operacion == '+'){
            respuesta= matA.sume('f');
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matA);
                okFlag= false;
            }
        }
        else if(operacion == '-'){
            respuesta= matA.opereMatriz(operacion);
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matA);
                okFlag= false;
            }
            
        }
        else if(operacion == 'm'){
            respuesta= matA.opereMatriz(operacion);
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matA);
                okFlag= false;
            }
        }
        else if(operacion == 'M'){
            respuesta= matA.opereMatriz(operacion);
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matA);
                okFlag= false;
            }
        }
        else{
            operandos.push(matA);
            okFlag= false;
        }
    }
    
    /** 
    *  Los operadores son: + (suma),  - (promedio), m (minimo), M (maximo)
    *  Las operaciones se realizan por columnas 
    */    
    public void opereColumnas(char operacion){
        Matriz matA= operandos.pop();
        Matriz respuesta= null;
        if(operacion == '+'){
            respuesta= matA.sume('c');
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matA);
                okFlag= false;
            }
        }
        else if(operacion == '-'){
            respuesta= matA.opereMatriz(operacion);
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matA);
                okFlag= false;
            }
            
        }
        else if(operacion == 'm'){
            respuesta= matA.opereMatriz(operacion);
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matA);
                okFlag= false;
            }
        }
        else if(operacion == 'M'){
            respuesta= matA.opereMatriz(operacion);
            operandos.push(respuesta);
            if(respuesta.equals(Matriz.UNCERO)){
                operandos.pop();
                operandos.push(matA);
                okFlag= false;
            }
        }
        else{
            operandos.push(matA);
            okFlag= false;
        }
    }    
    
    /** 
    *  @return okFlag boolean, indica si se logro realizar la ultima accion
    */ 
    public boolean ok(){
        return okFlag;
    }
}
    