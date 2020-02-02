package Aplicacion;

import java.io.Serializable;

/**
 * Crea las excpeciones del juego
 */
public class DKoongException extends Exception implements Serializable {
		public static final String COLOR_PLAYER_ALREADY_ERROR= "ya hay un jugador con ese color";
		
		/**
		 * Constructor de DKoongException
		 */
		public DKoongException(String message){
			super(message);
		}
}	

