package aplicacion;


/**
 * Write a description of class ReplicateException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReplicateException extends Exception{
    public static final String WRONG_DIMENSIONS = "La cantidad de casas y semillas deben ser mayor que cero.";
 
    /**
     * Constructor for objects of class KalahException
     */
    public ReplicateException(String message){
        super(message);
    }
}