package aplicacion;

import java.io.Serializable;

public class TeatroColonException extends Exception implements Serializable {
	public static final String EN_CONSTRUCCION= "En construccion";
	public static final String TYPE_DAT_ERROR= "La extencion no es .dat";
	public static final String TYPE_TXT_ERROR= "La extencion no es .txt";
	public static final String FILE_NOT_FOUND_ERROR= "Occurio un error al encontrar el archivo";
	public static final String NO_TEXT_FOUND= "El archivo de texto esta vacio";
	public static final String SIZE_ERROR= "El archivo de texto esta vacio";
	public static final String NUMBER_FORMAT_EXCEPTION = "No es posible convertir a entero";
	public static final String BOOLEAN_FORMAT = "No es correcto el valor de si es movil";
	
	public TeatroColonException(String message){
		super(message);
	}
}
