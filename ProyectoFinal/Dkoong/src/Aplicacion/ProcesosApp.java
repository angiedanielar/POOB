package Aplicacion;

/**
 * Crea el proceso de la App
 */
public class ProcesosApp extends Thread {
	private  Board board;
	private String name;
	
	/**
	* Constructor del proceso
	* @param board, el tablero del juego app
	* @param name, el nombre del proceso a relizar
	*/
	public ProcesosApp(Board board, String name) {
		this.board= board;
		this.name= name;
	}
	
	/**
	* Pone a correr el hilo
	*/
	public void run() {
		try {
			if(name.equals("mover_barriles")) {
				sleep(60);
				board.moveBarrels();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
