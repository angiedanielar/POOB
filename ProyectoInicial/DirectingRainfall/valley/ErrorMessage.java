package valley;

import javax.swing.*;

/**
 * Informa al usuario que ha ocurrido un error.
 */
public class ErrorMessage {
    JFrame f;  
    
    /**
     * Constructor de objetos de la clase ErrorMessage.
     */
    public ErrorMessage() {
        JOptionPane.showMessageDialog(f, "Accion no permitida, perdon por las molestias.", "Error", JOptionPane.WARNING_MESSAGE);
    }
}
