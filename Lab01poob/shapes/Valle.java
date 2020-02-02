

/**
 * Creamos el valle
 *
 */
public class Valle
{
    // instance variables - replace the example below with your own
    private Rectangle valle[];
    private boolean isVisible;
    private int ancho;
    private int alto;

    /**
     * Constructor for objects of class Valle
     */
    public Valle(int alto, int ancho)
    {
        valle = new Rectangle[1];
        isVisible = true;
        alto = this.alto;
        ancho = this.ancho;
        hacerValle();
    }

    /**
     * crea las caracteriasticas del valle
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private void  hacerValle()
    {  String colores []= {"white","lightGray","gray","darkGray","red","pink","orange","yellow","green","magenta",
                            "cyan","blue"}; 
       valle[0] = new Rectangle();
       valle[0].changeSize(ancho,alto);
       valle[0].changePosition(0,0);
       valle[0].changeColor("lightGray");
       valle[0].makeVisible();
                 
    }
    
    public void makeVisible(){
        this.isVisible= true;
            valle[0].makeVisible();
}
    /**
     * hace invisible la celda
     */
    public void makeInvisible(){
        this.isVisible= false;
        valle[0].makeInvisible();
    }
}