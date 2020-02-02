package Presentacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.*;
import java.io.File;
import java.io.IOException;

import Aplicacion.*;

/**
 * Crea el Tablero del Juego 
 */
public class Tablero extends JPanel{
	
	private Board tableroJuego;
	
	private boolean gano= false;
	
	public List<String> sorpresasPresentes;
	public List<String> barrilesPresentes;
	public String colorJugador;
	public String colorJugador2;
	public String colorPrincesa;
	public String tipoJugador;
	public String tipoJugador2;
	
	public Sprite jugador;
	public Sprite kong;
	public Sprite princesa;
	public Sprite Fondo;
	public Sprite barriles;
	
	public Sprite soga;
	public Sprite manzana;
	public Sprite cereza;
	public Sprite martillo;
	public Sprite hongo;
	public Sprite corazon;
	private List<Sprite> barrilesJuego;
	
	/**
	 * Constructor del Tablero
	 */
	public Tablero() {
		setSize(650,632);
		Fondo=new Sprite(0,0,true);
		Fondo.setRoot("tablero");
		tableroJuego= new Board(652,618);
		tableroJuego.prepareNivelF();
		addKong();
		addPrincesa();
		addBarriles();
		barrilesJuego= new ArrayList<Sprite>();
		//tableroJuego.startHilo();
		}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Fondo.paint((Graphics2D) g);
		kong.paint((Graphics2D) g);
		jugador.paint((Graphics2D) g);
		princesa.paint((Graphics2D) g);
		barriles.paint((Graphics2D) g);
		soga.paint((Graphics2D) g);
		martillo.paint((Graphics2D) g);
		manzana.paint((Graphics2D) g);
		cereza.paint((Graphics2D) g);
		corazon.paint((Graphics2D) g);
		hongo.paint((Graphics2D) g);
		for(Sprite barril:barrilesJuego) {
			barril.paint((Graphics2D) g);
		}
		}

	public void ponerSorpresas() {
		corazon = new Sprite(0,0,false);
		cereza = new Sprite(0,0,false);
		hongo = new Sprite(0,0,false);
		martillo = new Sprite(0,0,false);
		soga = new Sprite(0,0,false);
		manzana = new Sprite(0,0,false);

		if(sorpresasPresentes.contains("corazon")) {
			tableroJuego.addCorazon(new Posicion(20,300),"corazon");
			corazon.setVisible(true);
			corazon.setX(20);
			corazon.setY(300);
			corazon.setRoot("corazon");
		}

		if (sorpresasPresentes.contains("cereza")) {
			tableroJuego.addCereza(new Posicion(500,500),"cereza");
			cereza.setVisible(true);
			cereza.setX(500);
			cereza.setY(500);
			cereza.setRoot("cereza");
		}

		if (sorpresasPresentes.contains("hongo")) {
			tableroJuego.addHongo(new Posicion(500,200),"hongo");
			hongo.setVisible(true);
			hongo.setX(500);
			hongo.setY(200);
			hongo.setRoot("hongo");
		}

		if (sorpresasPresentes.contains("martillo")) {
			tableroJuego.addMartillo(new Posicion(150,500),"martillo");
			martillo.setVisible(true);
			martillo.setX(150);
			martillo.setY(500);
			martillo.setRoot("martillo");
		}

		if (sorpresasPresentes.contains("cuerda")) {
			tableroJuego.addCuerda(new Posicion(450,300),"cuerda");
			soga.setVisible(true);
			soga.setX(450);
			soga.setY(300);
			soga.setRoot("cuerda");
		}

		if (sorpresasPresentes.contains("manzana")) {
			tableroJuego.addManzana(new Posicion(400,400),"manzana");
			manzana.setVisible(true);
			manzana.setX(400);
			manzana.setY(400);
			manzana.setRoot("manzana");
		}
	}
	
	public void addPlayer() {
		tableroJuego.addPlayer(new Posicion(0,585),colorJugador,"11");
		jugador = new Sprite(0,585, true);
		jugador.setRoot("mario"+ colorJugador +"11");
	}
	
	public void addPrincesa() {
		princesa = new Sprite(305,35,true);
		tableroJuego.addPrincesa(new Posicion(305,35), colorPrincesa);
		princesa.setRoot("princesaazul");
		}
	
	public void addBarriles() {
		barriles = new Sprite(0,50,true);
		barriles.setRoot("barriles");
		}
	
	public void addKong() {
		kong = new Sprite(100,80,true,78,78);
		kong.setRoot("mono1");
	}
	
	/**
	 * Guarda la informacion de la configuracion del juego(un solo jugador)
	 * @param colorJugador, el color seleccionado por el usuario para el player
	 * @param colorPrincesa, el color seleccionado por el usuario para la princesa
	 * @param barriles, los barril(es) seleccionado(s) por el usuario para el juego
	 * @param sorpresas, las sorpresa(s) seleccionada(s) por el usuario para el juego
	 */
	public void infoConfigPlayerOne(String colorJugador, String colorPrincesa, List<String> barriles, List<String> sorpresas) {
		this.colorJugador= colorJugador;
		this.colorPrincesa= colorPrincesa;
		barrilesPresentes= barriles;
		sorpresasPresentes= sorpresas;
		addPlayer();
		ponerSorpresas();
	}
	
	/**
	 * Guarda la informacion de la configuracion del juego(dos jugadores)
	 * @param colorJugador, el color seleccionado por el usuario para el player 1
	 * @param colorJugador2, el color seleccionado por el usuario para el player 2
	 * @param colorPrincesa, el color seleccionado por el usuario para la princesa
	 * @param barriles, los barril(es) seleccionado(s) por el usuario para el juego
	 * @param sorpresas, las sorpresa(s) seleccionada(s) por el usuario para el juego
	 */
	public void infoConfigTwoPlayers(String colorJugador, String colorJugador2, String colorPrincesa, List<String> barriles, List<String> sorpresas) {
		this.colorJugador= colorJugador;
		this.colorJugador2= colorJugador2;
		this.colorPrincesa= colorPrincesa;
		barrilesPresentes= barriles;
		sorpresasPresentes= sorpresas;
	}
	
	/**
	 * Guarda la informacion de la configuracion del juego(vs maquina)
	 * @param tipoJugador, el tipo de jugador seleccionado por el usuario para el player 1
	 * @param colorJugador, el color seleccionado por el usuario para el player 1
	 * @param tipoJugador2, el tipo de jugador seleccionado por el usuario para el player 2
	 * @param colorPrincesa, el color seleccionado por el usuario para la princesa
	 * @param barriles, los barril(es) seleccionado(s) por el usuario para el juego
	 * @param sorpresas, las sorpresa(s) seleccionada(s) por el usuario para el juego
	 */
	public void infoConfigVsMaquina(String tipoJugador, String colorJugador, String tipoJugador2, String colorPrincesa, List<String> barriles, List<String> sorpresas) {
		this.tipoJugador= tipoJugador;
		this.colorJugador= colorJugador;
		this.tipoJugador2= tipoJugador2;
		this.colorPrincesa= colorPrincesa;
		barrilesPresentes= barriles;
		sorpresasPresentes= sorpresas;
	}
	
	/**
	 * Obtiene el tablero BOARD de aplicacion
	 * @return tableroJuego, devuelve el tablero del juego
	 */
	public Board getTablero() {
		return tableroJuego;
	}

	/**
	 * Obtiene el sprite del KONG
	 * @return kong, el sprite
	 */
	public Sprite getDonkey() {
		return kong;
	}
	
	/**
	 * Obtiene el sprite del JUGADOR
	 * @return jugador, el sprite
	 */
	public Sprite getJugador() {
		return jugador;
	}
	
	/**
	 * Obtiene el sprite de la PRINCESA
	 * @return princesa, el sprite
	 */
	public Sprite getPrincesa() {
		return princesa;
	}
	
	public void actualiceSpritesMario() {
		jugador.setX(tableroJuego.getPlayers().get(0).getPosicion().getCordenadas()[0]);
		jugador.setY(tableroJuego.getPlayers().get(0).getPosicion().getCordenadas()[1]);
		jugador.setRoot("mario"+tableroJuego.getPlayers().get(0).getRoot());
	}
	
	public void actualiceSpritePrincesa() {
		princesa.setRoot(this.colorPrincesa);
	}
	
	public void actualiceSpritesBarriles() {
		List<Barrel> barrilesBoard= tableroJuego.getBarrels();
		for(int i= 0; i< barrilesBoard.size(); i++) {
			barrilesJuego.get(i).setRoot(barrilesBoard.get(i).getRoot());
			barrilesJuego.get(i).setX(barrilesBoard.get(i).getPosicion().getX());
			barrilesJuego.get(i).setX(barrilesBoard.get(i).getPosicion().getY());
		}
	}
	
	public void chequeoWinner() {
		if(getTablero().getWinningState()) {
			gano= true;
		}
	}
	
	public void actualice() {
		actualiceSpritesMario();
		actualiceSpritePrincesa();
		actualiceSpritesBarriles();
		actualiceInfoBoard();
		
		chequeoWinner();
	}
	
	public void actualiceInfoBoard() {
		getTablero().intersectaSorpresa();
		getTablero().intersectaPrincesa();
	}
	
	public void addBarrel() {
		Random random= new Random();
		tableroJuego.addBarrel(barrilesPresentes.get(random.nextInt(barrilesPresentes.size())));
		barrilesJuego.add(new Sprite(Barrel.posicionInicial.getX(),Barrel.posicionInicial.getY(),true));
		System.out.println(tableroJuego.getBarrels().size());
			
	}
	
	public int getPuntos() {
		return tableroJuego.getScore();
	}
	
	public int getVidas() {
		return tableroJuego.getVida();
	}
	
	public boolean getGano() {
		return gano;
	}
}


