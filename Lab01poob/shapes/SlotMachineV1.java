
/**
 * Slot Machine de 3*1 celdas 
 *
 */
public class SlotMachineV1{
    private SlotMachineCell maquina[];
    private int timesWon;
    private int timesPulled;
    private boolean isWinnig; 
    private boolean isVisible;
    /**
     * Constructor for objects of class SlotMachineV1
     */
    public SlotMachineV1(){
        maquina= new SlotMachineCell[3];
        timesWon= 0;
        timesPulled= 0;
        isWinnig= false;
        isVisible= true;
        for (int i= 0; i<3; i++){
            maquina[i]= new SlotMachineCell();
        }
        for (int i= 1; i<3; i++){
            maquina[i].changePosition(50+(60*i),130);
        }
    }
    /**
     * jala la palanc de la maquina
     */
    public void pull(){
        this.timesPulled+= 1;
        for (int i= 0; i<3; i++){
            maquina[i].pull(4);
        }
        if (isWinningState()){
            this.timesWon+= 1;            
        }
    }
    /**
     * mira si el estado es uno ganador
     */
    public boolean isWinningState(){
        if(maquina[0].getEstado()!= -1){
            if (maquina[0].getEstado() == maquina[1].getEstado() && maquina[1].getEstado() == maquina[2].getEstado()){
                isWinnig= true;
           }
            else{
                isWinnig= false;
            }
        }
        else{
            isWinnig= false;
            }
        return isWinnig ;
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
        this.isWinnig= false;
        this.isVisible= true;
        makeVisible();
    }
    /**
     * hace la maquina Visible
     */
    public void makeVisible(){
        for (int i= 0; i<3; i++){
            maquina[i].resetEstado();
            maquina[i].makeVisible();
        }
    }
    /**
     * hace la maquina Invisible
     */
    public void makeInvisible(){
        for (int i= 0; i<3; i++){
            maquina[i].resetEstado();
            maquina[i].makeInvisible();
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
    for (int i= 0; i<3;i++){
        maquina[i].move(horizontal,vertical);
    }
}
}
