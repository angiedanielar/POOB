import java.util.Random;
/**
 * A Slot Machine de una fila con la que se puede interactuar 
 * hacerla visible e invisible
 */
public class SlotMachineCell
{
    // instance variables - replace the example below with your own
    public Rectangle maquina[];
    private Circle circulos[];
    //private ErrorMessage error;
    private int estado;
    private boolean isVisible;
    /**
     * Constructor for objects of class SlotMachine
     */
    public SlotMachineCell(){
        maquina = new Rectangle[25];
        circulos = new Circle[2];
        estado= -1;
        isVisible = true;
        preparacionMaquina();
    }
    /**
     * crea las caracteristicas de una celda de la maquina
     */private void preparacionMaquina(){ 
        String colores []= {"white","lightGray","gray","darkGray","red","pink","orange","yellow","green","magenta",
                            "cyan","blue"};
        int contA= 0;
        int contB= 0;
        for (int i= 0; i<25; i++){
            maquina[i]= new Rectangle();
            maquina[i].changePosition(55,135);
            if (i!=0){
                if (i%2 == 0){
                    maquina[i].changeSize(30,30);
                    maquina[i].changeColor(colores[contA]);
                    contA+=1;
                }
                else{
                    maquina[i].changeSize(10,30);
                    maquina[i].changeColor(colores[contB]);
                    contB+=1;
                }
            }     
        }
        maquina[0].changeSize(40,40);
        maquina[0].changePosition(50,130);
        maquina[0].makeVisible();
        circulos[0]= new Circle();
        circulos[1]= new Circle();
        circulos[1].changeColor("yellow");
        circulos[0].changePosition(55,135);
        circulos[1].changePosition(55,135);
    }
    /**
     * jala la palanca de la celda del juego del tragamonedas
     */public void pull(int limite){
        Random rnd= new Random();
        this.estado= rnd.nextInt((limite-1)+1)+1;
        for (int i=1 ; i<25 ;i++){
            maquina[i].makeInvisible();
        }
        circulos[0].makeInvisible();
        circulos[1].makeInvisible();
        if (estado<25){
            maquina[estado].makeVisible();
        }
        else{
            switch(estado){
                case 25:
                    circulos[0].makeVisible();
                    break;
                case 26:
                    circulos[1].makeVisible();
                    break;
                default: 
                    break;
        }
    }
}
    /**
     * cambia de posicion la celda
     * @param x nueva coordenada x de la celda
     * @param y nueva coordenada y de la celda
     */
    public void changePosition(int x, int y){
        for (int i= 0; i<25; i++){
            maquina[i].changePosition(x,y);
            if (i!= 0){
                maquina[i].changePosition(x+5,y+5);
            }            
        }
        circulos[0].changePosition(x+5,y+5);
        circulos[1].changePosition(x+5,y+5);
    }
    /**
     * hace visible la celda y el valor que tiene, si aun no tiene valor solo muestra la celda
     */
    public void makeVisible(){
        this.isVisible= true;
        if (this.estado== -1){
            maquina[0].makeVisible();
        }
        else{
            maquina[0].makeVisible();
            if (estado<25){
            maquina[estado].makeVisible();
            }
            else{
                switch(estado){
                    case 25:
                        circulos[0].makeVisible();
                        break;
                    case 26:
                        circulos[1].makeVisible();
                        break;
                    default: 
                        break;
                    }
                }
    }
}
    /**
     * hace invisible la celda
     */
    public void makeInvisible(){
        this.isVisible= false;
        for (int i= 0; i<25; i++){
            maquina[i].makeInvisible();
        }
        circulos[0].makeInvisible();
        circulos[1].makeInvisible();
    }
/**
 * mueve la cela a horizontal y verticalmente
 * @param horizontal cuanto se mueve horizontalmente
 * @param vertical cuante se mueve verticalmente 
 */
public void move(int horizontal, int vertical){
    makeInvisible();
    resetEstado();
    makeVisible();
    for (int i= 0; i<25;i++){
        maquina[i].slowMoveHorizontal(horizontal);
        maquina[i].slowMoveVertical(vertical);
    }
    circulos[0].slowMoveHorizontal(horizontal);
    circulos[0].slowMoveVertical(vertical);
    circulos[1].slowMoveHorizontal(horizontal);
    circulos[1].slowMoveVertical(vertical);
}
/**
 * retorna el valor del estado actual
 */
public int getEstado(){
    return this.estado;
}
/**
 * resetea el valor del estado
 */
public void resetEstado(){
    this.estado= -1;
}
}