import java.awt.Toolkit;
/**
 * Slot Machine de n*n celdas 
 * @param n dimensiones de la maquina
 */
public class SquareSlotMachine{
    private SlotMachineCell maquina[][];
    private int size;
    private int timesWon;
    private int timesPulled;
    private ErrorMessage error;
    private boolean isWinning; 
    private boolean isVisible;
    /**
     * Constructor for objects of class SlotMachineV1
     */
    public SquareSlotMachine(int n){
        if (n>=2 && n<=5){
            maquina= new SlotMachineCell[n][n];
            size= n;
            timesWon= 0;
            timesPulled= 0;
            isWinning= false;
            isVisible= true;
            for (int i= 0; i<n; i++){
                for(int j= 0; j<n; j++){
                    maquina[i][j]= new SlotMachineCell();
                }
            }
            for (int i= 0; i<n; i++){
                for(int j= 0; j<n; j++){
                    maquina[i][j].changePosition(50+(60*i),130+(50*j));
                }
            }
        }
        else{
            error= new ErrorMessage();
        }
    }
    /**
     * jala la palanca de la maquina
     */
    public void pull(){
        this.timesPulled+= 1;
        for (int i= 0; i<this.size; i++){
            for (int j= 0; j< this.size; j++){
                maquina[i][j].pull((this.size*this.size)+1);
            }
        }
        if (isWinningState()){
            this.timesWon+= 1;
            Toolkit.getDefaultToolkit().beep()
            ;
        }
    }
    /**
     * jala la fila n, comienza en 0.
     * @param n int que determina la fila
     */
    public void pullFila(int n){
        this.timesPulled+=1;
        for (int i=0; i< this.size; i++){
            maquina[i][n].pull((this.size*this.size)+1);
        } 
    }
    /**
     * mira si el estado es uno ganador
     */
    public boolean isWinningState(){
        this.isWinning= false;
        if (checkFilas() || checkColumnas() || checkDiagonal() || checkContraDiagonal()){
            this.isWinning= true;
        }
        return isWinning;
    }
    
    /**
     * @param x numero de veces que jala la palanca
     */
    public void pullTimes(int x){
        for (int i= 0; i<x; i++){
            pull();
        }
    }
    /**
     * reseta los valores dejandola en el estado de visibilidad de la maqina
     */
    public void reset(){
        this.timesWon= 0;
        this.timesPulled= 0;
        this.isWinning= false;
        this.isVisible= true;
        makeVisible();
    }
    /**
     * hace la maquina Visible
     */
    public void makeVisible(){
        for (int i= 0; i<this.size; i++){
            for (int j= 0; j< this.size; j++){
                maquina[i][j].resetEstado();
                maquina[i][j].makeVisible();
            }
        }
    }
    /**
     * hace la maquina Invisible
     */
    public void makeInvisible(){
        for (int i= 0; i<this.size; i++){
            for (int j= 0; j< this.size; j++){
                maquina[i][j].resetEstado();
                maquina[i][j].makeInvisible();
            }
        }
    }
    /**
     * muestar el procentage de victorias con el total de victorias sobre el total de pulls
     */
    public int percentageOfWinning(){
        return (this.timesWon*100)/this.timesPulled;
    }
/**
 * mueve la maquina a horizontal y verticalmente
 * @param horizontal cuanto se mueve horizontalmente
 * @param vertical cuante se mueve verticalmente 
 */
public void move(int horizontal, int vertical){
    for (int i= 0; i<this.size;i++){
        for (int j= 0; j<this.size; j++){
            maquina[i][j].move(horizontal,vertical);
        }
    }
}
    /**
     * checkea si alguna fila esta en estado ganador y retorna true si encuentra la primera, false si no encuentra ninguna
     */private boolean checkFilas(){
        boolean valor= false;
        int filaActual= 0;
        if(maquina[0][0].getEstado()!= -1){
            while (!valor && filaActual < this.size){
            boolean flag= true;
            for(int i= 0; flag && i<this.size; i++){
                if(maquina[filaActual][0].getEstado()!=maquina[filaActual][i].getEstado()){
                    flag= false;
                }
            }
            filaActual+= 1;
            if (flag){
                valor= true;
            }
            }
        }
        return valor;
    }
    /**
     * checkea si alguna columna esta en estado ganador y retorna true si encuentra la primera, false si no encuentra ninguna
     */
    private boolean checkColumnas(){
        boolean valor= false;
        int columnaActual= 0;
        if(maquina[0][0].getEstado()!= -1){
            while (!valor && columnaActual < this.size){
            boolean flag= true;
            for(int i= 0; flag && i<this.size; i++){
                if(maquina[0][columnaActual].getEstado()!=maquina[i][columnaActual].getEstado()){
                    flag= false;
                }
            }
            columnaActual+= 1;
            if (flag){
                valor= true;
            }
        }
        }
        return valor;
    }
    /**
     * checkea si la diagonal esta en estado ganador y retorna true si encuentra la primera, false si no encuentra ninguna
     */private boolean checkDiagonal(){
        boolean valor= false;
        int diag1= 0;
        if(maquina[0][0].getEstado()!= -1){
            while (!valor && diag1 < this.size){
                boolean flag= true;
                for(int i= 0; flag && i<this.size; i++){
                    if(maquina[0][0].getEstado()!=maquina[i][i].getEstado()){
                        flag= false;
                    }
                }
                diag1+= 1;
                if (flag){
                    valor= true;
                }
            }
        }
        return valor;
    }
    /**
     * checkea si la contra diagonal esta en estado ganador y retorna true si encuentra la primera, false si no encuentra ninguna
     */private boolean checkContraDiagonal(){
        boolean valor= false;
        int diag2= 0;
        if(maquina[0][0].getEstado()!= -1){
            while (!valor && diag2 < this.size){
            boolean flag= true;
            for(int i= 0; flag && i<this.size; i++){
                if(maquina[this.size-1][0].getEstado()!=maquina[i][this.size-i-1].getEstado()){
                    flag= false;
                }
            }
            diag2+= 1;
            if (flag){
                valor= true;
            }
           }
        }
        return valor;
    }
}