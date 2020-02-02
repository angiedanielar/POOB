import javax.swing.*;
/**
 * Write a description of class ErrorMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ErrorMessage
{
    // instance variables - replace the example below with your own
    JFrame f;  

    /**
     * Constructor for objects of class ErrorMessage
     */
    public ErrorMessage(){
        f=new JFrame();  
        JOptionPane.showMessageDialog(f,"Hubo un problema, perdon las molestias :)");
    }
    /**
     * muestra el mensaje de error
     */public void mostrar() {  
        new ErrorMessage();  
}  
}
