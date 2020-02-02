package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.event.*;
import javax.imageio.*;

import java.util.*;

/**
 * Crea lo Grafico del Juego 
 */
public class DKoongGUI extends JFrame implements KeyListener{
	private final static int ANCHO = Toolkit.getDefaultToolkit().getScreenSize().width;
	private final static int ALTO = Toolkit.getDefaultToolkit().getScreenSize().height;
    private Font fuente; 
    private CardLayout layout;
	private JLabel level, puntos, vida;
	private JPanel panelLogo, panelMenu, panelCards, score, nivel, vidas, menuUpPanel;
	private JPanel menuDownPanel, menuOpciones, lifes, panelInstrucciones, insUpPanel;
	private JPanel insMidPanel, insDownPanel, insContainerPanel, panelTablero, tabDownPanel;
	private JPanel panelGameTypeChooser, centerGameTypeChooser, panelPlayerOne, upPlayerOne;
	private JPanel midPlayerOne, downPlayerOne, playerOneBarrelButtonContainer, upTwoPlayers;
	private JPanel playerOneSurpriseButtonContainer, upPlayerOneImageContainer, midTwoPlayers;
	private JPanel midPlayerOneSurpriseImageContainer, midPlayerOneColorsImageContainer;
	private JPanel midPlayerOneComboboxContainer, midPlayerOnePanelConatiner, panelTwoPlayers;
	private JPanel downTwoPlayers, twoPlayersBarrelButtonContainer,twoPlayersSurpriseButtonContainer;
	private JPanel upTwoPlayersImageContainer, midTwoPlayersSurpriseImageContainer, midVsMaquinaPanelConatiner;
	private JPanel midTwoPlayersColorsImageContainer, midTwoPlayersComboboxContainer;
	private JPanel midTwoPlayersPanelConatiner, panelVsMaquina, upVsMaquina, midVsMaquina, downVsMaquina;
	private JPanel vsMaquinaBarrelButtonContainer, vsMaquinaSurpriseButtonContainer, upVsMaquinaImageContainer;
	private JPanel midVsMaquinaSurpriseImageContainer, midVsMaquinaColorsImageContainer, midVsMaquinaComboboxContainer;
	private JButton jugarStartMenu, abrir, instrucciones, regresarIns, acabarJuego;
	private JButton salvarTablero, onePlayer, twoPlayer, vsMachine, regresarGameType;
	private JButton jugarPlayerOne, regresarPlayerOne, barrilAmarilloButonPlayerOne;			
	private JButton	barrilRojoButonPlayerOne, barrilVerdeButonPlayerOne, barrilAzulButonPlayerOne;
	private JButton martilloButonPlayerOne, cerezaButonPlayerOne, manzanaButonPlayerOne;				 
	private JButton hongoButonPlayerOne, sogaButonPlayerOne, corazonButonPlayerOne;
	private JButton jugarTwoPlayers, regresarTwoPlayers, barrilAmarilloButonTwoPlayers;
	private JButton barrilRojoButonTwoPlayers, barrilVerdeButonTwoPlayers, barrilAzulButonTwoPlayers;
	private JButton martilloButonTwoPlayers, cerezaButonTwoPlayers, manzanaButonTwoPlayers;
	private JButton hongoButonTwoPlayers, sogaButonTwoPlayers, corazonButonTwoPlayers;
	private JButton jugarVsMaquina, regresarVsMaquina, barrilAmarilloButonVsMaquina;
	private JButton barrilRojoButonVsMaquina, barrilVerdeButonVsMaquina, barrilAzulButonVsMaquina;
	private JButton	martilloButonVsMaquina, cerezaButonVsMaquina, manzanaButonVsMaquina;
	private JButton sogaButonVsMaquina, corazonButonVsMaquina, hongoButonVsMaquina;
	private ArrayList<JButton> botonesPlayerOne, botonesTwoPlayers, botonesVSMaquina;
	private Color colorDefault, colorActivo;
	private JFileChooser fileChooser;
	private JComboBox<String> colorPlayerMenuPlayerOne, colorPrincesMenuPlayerOne;
	private JComboBox<String> colorPlayerMenuTwoPlayersOne, colorPlayerMenuTwoPlayersTwo;
	private JComboBox<String> colorPrincesMenuTwoPlayers, colorPlayerMenuVsMaquina; 
	private JComboBox<String> colorPrincesMenuVsMaquina, PlayerTypeOne, PlayerTypeTwo;
	private Tablero tabUpPanel;
	private ProcesoGui procesoGuiActualizador, procesoGuiBarriles;
	
	/**
	 * Constructor el DKoongGUI del Juego
	 */
	private DKoongGUI() throws IOException{
		setResizable(false);
		prepareElementos();
		prepareAcciones();
	}
	
	/**
	 * Prepara los elementos del Juego
	 */
	private void prepareElementos() {
		setTitle("DonKingPoob");
		setSize(620,710);
		fileChooser= new JFileChooser();
		fileChooser.setVisible(false);
		panelCards= new JPanel();
		panelCards.setLayout(new CardLayout());
		colorDefault= Color.BLACK;
		colorActivo= Color.WHITE;
		prepareElementosMenu();
		prepareInstrucciones();
		prepareTablero();
		prepareGameTypeChooser();
		prepareMenuConfiguracionPlayerOne();
		prepareMenuConfiguracionTwoPlayers();
		prepareMenuConfiguracionVsMaquina();
		add(panelCards);
		addKeyListener(this);
		setFocusable(true);
	}
	
	/**
	 * Prepara los elementos del menu
	 */
	private void prepareElementosMenu() {
		panelMenu= new JPanel();
		menuUpPanel= new JPanel();
		menuDownPanel= new JPanel();
		panelLogo= new JPanel();
		
		ponerFondo(panelLogo, "images/principal/DKLogo.jpg");
		
		panelMenu.setBackground(colorDefault);
		menuDownPanel.setBackground(colorDefault);
		
		panelMenu.setLayout(new GridLayout(2,1));
		menuUpPanel.setLayout(new BorderLayout());
		menuDownPanel.setLayout(new BorderLayout());
		
		prepareBotonesMenu();
		
		menuUpPanel.add(panelLogo,BorderLayout.CENTER);
		menuDownPanel.add(menuOpciones,BorderLayout.CENTER);
		panelMenu.add(menuUpPanel);
		panelMenu.add(menuDownPanel);
		panelCards.add(panelMenu,"menu");
	}
	
	/**
	 * Prepara los botones del menu
	 */
	private void prepareBotonesMenu() {
		menuOpciones= new JPanel();
		jugarStartMenu= new JButton();
		abrir= new JButton();
		instrucciones= new JButton();
		
		jugarStartMenu.setBackground(colorDefault);
		abrir.setBackground(colorDefault);
		instrucciones.setBackground(colorDefault);
		
		ponerFondo(jugarStartMenu,"images/principal/jugar.png");
		ponerFondo(abrir,"images/principal/abrir.png");
		ponerFondo(instrucciones,"images/principal/comoJugar.png");
		
		menuOpciones.setBackground(colorDefault);
		
		menuOpciones.setLayout(new GridLayout(3,1,3,3));
		
		menuOpciones.add(jugarStartMenu);
		menuOpciones.add(abrir);
		menuOpciones.add(instrucciones);
	}
	
	/**
	 * Prepara las intrucciones del Juego
	 */
	private void prepareInstrucciones() {
		panelInstrucciones= new JPanel();
		insUpPanel= new JPanel();
		insMidPanel= new JPanel();
		insDownPanel= new JPanel();
		insContainerPanel= new JPanel();
		regresarIns= new JButton("Regresar");
		
		ponerFondo(regresarIns,"images/principal/regresar.png");
		ponerFondo(insUpPanel,"images/principal/instrucciones_1.png");
		ponerFondo(insMidPanel,"images/principal/instrucciones_2.png");
		
		insDownPanel.setBackground(colorDefault);
		insUpPanel.setBackground(colorDefault);
		insMidPanel.setBackground(colorDefault);
		insContainerPanel.setBackground(colorDefault);
		panelInstrucciones.setBackground(colorDefault);
		regresarIns.setBackground(colorDefault);
		
		insContainerPanel.setLayout(new  GridLayout(3,1,3,3));
		panelInstrucciones.setLayout(new  BorderLayout());
		insDownPanel.setLayout(new BorderLayout());
		
		insContainerPanel.add(insUpPanel);
		insContainerPanel.add(insMidPanel);
		insContainerPanel.add(insDownPanel);
		insDownPanel.add(regresarIns,BorderLayout.CENTER);
		panelInstrucciones.add(insContainerPanel,BorderLayout.CENTER);
		panelInstrucciones.add(new JPanel(),BorderLayout.WEST);
		panelInstrucciones.add(new JPanel(),BorderLayout.EAST);
		panelCards.add(panelInstrucciones,"Instrucciones");
	}
	
	/**
	 * Prepara el Tablero del Juego
	 */
	private void prepareTablero() {
		panelTablero= new JPanel();
		tabUpPanel= new Tablero();
		tabDownPanel= new JPanel();
		salvarTablero= new JButton("Salvar");
		score = new JPanel();
		nivel = new JPanel();
		lifes = new JPanel();
		acabarJuego = new JButton("Finalizar");
		
		procesoGuiActualizador= new ProcesoGui(tabUpPanel,"actualizador");
		procesoGuiBarriles= new ProcesoGui(tabUpPanel,"agregador_barriles");
		
		ponerFondo(salvarTablero,"images/principal/salvar.jpg");
		ponerFondo(acabarJuego,"images/principal/fin.jpg");

		Font fuente = new Font("Modern Love", Font.BOLD, 19);
		level = new JLabel("LEVEL: 1");
		puntos = new JLabel("SCORE: "+"0");
		vida = new JLabel("LIFES:"+"3");
		
		tabUpPanel.setSize(650, 632);

		puntos.setFont(fuente);
		puntos.setForeground(Color.orange);
		level.setFont(fuente);
		level.setForeground(Color.orange);
		vida.setFont(fuente);
		vida.setForeground(Color.orange);

		score.setBackground(colorDefault);
		nivel.setBackground(colorDefault);
		lifes.setBackground(colorDefault);

		score.add(puntos);
		nivel.add(level);
		lifes.add(vida);

		tabDownPanel.setBackground(colorDefault);
		
		panelTablero.setLayout(new  BorderLayout());
		tabDownPanel.setLayout(new  GridLayout(1,5));
	
		tabDownPanel.add(salvarTablero);
		tabDownPanel.add(score);
		tabDownPanel.add(lifes);
		tabDownPanel.add(nivel);
		tabDownPanel.add(acabarJuego);

		panelTablero.add(tabDownPanel,BorderLayout.SOUTH);
		panelTablero.add(tabUpPanel,BorderLayout.CENTER);
		panelCards.add(panelTablero,"Tablero");
		
}
	
	/**
	 * Prepara el tablero de la seleccion del modo de Juego
	 */
	private void prepareGameTypeChooser() {
		panelGameTypeChooser= new JPanel();
		centerGameTypeChooser= new JPanel();
		onePlayer= new JButton("Un Jugador");
		twoPlayer= new JButton("Dos Jugadores");
		vsMachine= new JButton("Vs Maquina");
		regresarGameType= new JButton("Regresar");
		
		ponerFondo(regresarGameType,"images/principal/regresar.png");
		ponerFondo(onePlayer,"images/principal/1Jugador.png");
		ponerFondo(twoPlayer,"images/principal/2Jugadores.png");
		ponerFondo(vsMachine,"images/principal/VsMaquina.png");
		
		centerGameTypeChooser.setBackground(colorDefault);
		panelGameTypeChooser.setBackground(colorDefault);
		regresarGameType.setBackground(colorDefault);
		
		centerGameTypeChooser.setLayout(new  GridLayout(4,1,5,5));
		panelGameTypeChooser.setLayout(new  BorderLayout());
		
		centerGameTypeChooser.add(onePlayer);
		centerGameTypeChooser.add(twoPlayer);
		centerGameTypeChooser.add(vsMachine);
		centerGameTypeChooser.add(regresarGameType);
		onePlayer.setBackground(colorDefault);
		twoPlayer.setBackground(colorDefault);
		vsMachine.setBackground(colorDefault);
		panelGameTypeChooser.add(new JPanel(),BorderLayout.NORTH);
		panelGameTypeChooser.add(new JPanel(),BorderLayout.EAST);
		panelGameTypeChooser.add(new JPanel(),BorderLayout.WEST);
		panelGameTypeChooser.add(new JPanel(),BorderLayout.SOUTH);
		panelGameTypeChooser.add(centerGameTypeChooser,BorderLayout.CENTER);
		panelCards.add(panelGameTypeChooser,"GameTypeChooser");
	}
	
	/**
	 * Prepara el menu de la configuracion del juego(un jugador)
	 */
	private void prepareMenuConfiguracionPlayerOne() {
		/*Creacion de los paneles*/
		panelPlayerOne= new JPanel();
		upPlayerOne= new JPanel();
		midPlayerOne= new JPanel();
		downPlayerOne= new JPanel();
		playerOneBarrelButtonContainer= new JPanel();
		playerOneSurpriseButtonContainer= new JPanel();
		upPlayerOneImageContainer= new JPanel();
		midPlayerOneSurpriseImageContainer= new JPanel();
		midPlayerOneColorsImageContainer= new JPanel();
		midPlayerOneComboboxContainer= new JPanel();
		midPlayerOnePanelConatiner= new JPanel();
		
		botonesPlayerOne= new ArrayList<JButton>();
		
		/*creacion de los Combobox de los colores*/
		colorPlayerMenuPlayerOne= new JComboBox<String>();
		colorPrincesMenuPlayerOne= new JComboBox<String>();
		
		/*Creacion de los botones*/
		regresarPlayerOne= new JButton("regresarPlayerOne");
		jugarPlayerOne= new JButton("jugarPlayerOne");
		barrilRojoButonPlayerOne= new JButton("barrilRojoButonPlayerOne");
		barrilAmarilloButonPlayerOne= new JButton("barrilAmarilloButonPlayerOne");
		barrilVerdeButonPlayerOne= new JButton("barrilVerdeButonPlayerOne");
		barrilAzulButonPlayerOne= new JButton("barrilAzulButonPlayerOne");
		martilloButonPlayerOne= new JButton("martilloButonPlayerOne");
		cerezaButonPlayerOne= new JButton("cerezaButonPlayerOne");
		manzanaButonPlayerOne= new JButton("manzanaButonPlayerOne");
		hongoButonPlayerOne= new JButton("hongoButonPlayerOne");
		sogaButonPlayerOne= new JButton("sogaButonPlayerOne");
		corazonButonPlayerOne= new JButton("corazonButonPlayerOne");
		
		botonesPlayerOne.add(barrilRojoButonPlayerOne);
		botonesPlayerOne.add(barrilAmarilloButonPlayerOne);
		botonesPlayerOne.add(barrilVerdeButonPlayerOne);
		botonesPlayerOne.add(barrilAzulButonPlayerOne);
		botonesPlayerOne.add(martilloButonPlayerOne);
		botonesPlayerOne.add(cerezaButonPlayerOne);
		botonesPlayerOne.add(manzanaButonPlayerOne);
		botonesPlayerOne.add(hongoButonPlayerOne);
		botonesPlayerOne.add(sogaButonPlayerOne);
		botonesPlayerOne.add(corazonButonPlayerOne);
		
		/* preparando los combobox de los colores */
		/* el de mario */
		colorPlayerMenuPlayerOne.addItem("Mario Rojo");
		colorPlayerMenuPlayerOne.addItem("Mario Blanco");
		colorPlayerMenuPlayerOne.addItem("Mario Gris");
		colorPlayerMenuPlayerOne.addItem("Mario Morado");
		colorPlayerMenuPlayerOne.addItem("Mario Naranja");
		colorPlayerMenuPlayerOne.addItem("Mario Negro");
		colorPlayerMenuPlayerOne.addItem("Mario Verde");
		colorPlayerMenuPlayerOne.addItem("Mario Rosa");
		
		/* el de la princesa */
		colorPrincesMenuPlayerOne.addItem("Princesa Azul");
		colorPrincesMenuPlayerOne.addItem("Princesa Cafe");
		colorPrincesMenuPlayerOne.addItem("Princesa Morada");
		colorPrincesMenuPlayerOne.addItem("Princesa Roja");
		colorPrincesMenuPlayerOne.addItem("Princesa Rosa");
		colorPrincesMenuPlayerOne.addItem("Princesa Verde");
		
		/*fondo de los botones*/
		ponerFondo(jugarPlayerOne,"images/principal/jugar.png");
		ponerFondo(regresarPlayerOne,"images/principal/regresar.png");
		
		/*barriles*/
		ponerFondo(barrilRojoButonPlayerOne,"images/Barriles/barrilrojo5.png");
		ponerFondo(barrilAmarilloButonPlayerOne,"images/Barriles/barrilamarillo5.png");
		ponerFondo(barrilVerdeButonPlayerOne,"images/Barriles/barrilverde5.png");
		ponerFondo(barrilAzulButonPlayerOne,"images/Barriles/barrilazul5.png");
		
		/*poderes*/
		ponerFondo(martilloButonPlayerOne,"images/poderes/martillo.png");
		ponerFondo(cerezaButonPlayerOne,"images/poderes/cereza.png");
		ponerFondo(manzanaButonPlayerOne,"images/poderes/manzana.png");
		ponerFondo(hongoButonPlayerOne,"images/poderes/hongo.png");
		ponerFondo(sogaButonPlayerOne,"images/poderes/cuerda.png");
		ponerFondo(corazonButonPlayerOne,"images/poderes/corazon.png");
		
		/*fondo de los paneles con imagen*/
		ponerFondo(upPlayerOneImageContainer,"images/principal/Seleccion_Barriles.png");
		ponerFondo(midPlayerOneSurpriseImageContainer,"images/principal/Seleccion_Sorpresas.png");
		ponerFondo(midPlayerOneColorsImageContainer,"images/principal/Seleccion_ColoresMenuJugadorUno.png");
		
		/*color de los paneles*/
		panelPlayerOne.setBackground(colorDefault);
		upPlayerOne.setBackground(colorDefault);
		midPlayerOne.setBackground(colorDefault);
		downPlayerOne.setBackground(colorDefault);
		playerOneBarrelButtonContainer.setBackground(colorDefault);
		playerOneSurpriseButtonContainer.setBackground(colorDefault);
		midPlayerOnePanelConatiner.setBackground(colorDefault);
		midPlayerOneComboboxContainer.setBackground(colorDefault);
		
		/*color de los Botones*/
		regresarPlayerOne.setBackground(colorDefault);
		jugarPlayerOne.setBackground(colorDefault);
		barrilRojoButonPlayerOne.setBackground(colorDefault);
		barrilAmarilloButonPlayerOne.setBackground(colorDefault);
		barrilVerdeButonPlayerOne.setBackground(colorDefault);
		barrilAzulButonPlayerOne.setBackground(colorDefault);
		martilloButonPlayerOne.setBackground(colorDefault);
		martilloButonPlayerOne.setForeground(colorDefault);
		cerezaButonPlayerOne.setBackground(colorDefault);
		cerezaButonPlayerOne.setForeground(colorDefault);
		manzanaButonPlayerOne.setBackground(colorDefault);
		manzanaButonPlayerOne.setForeground(colorDefault);
		hongoButonPlayerOne.setBackground(colorDefault);
		hongoButonPlayerOne.setForeground(colorDefault);
		sogaButonPlayerOne.setBackground(colorDefault);
		sogaButonPlayerOne.setForeground(colorDefault);
		corazonButonPlayerOne.setBackground(colorDefault);
		corazonButonPlayerOne.setForeground(colorDefault);
		
		/*layout de los paneles*/
		panelPlayerOne.setLayout(new GridLayout(3,1,5,3));
		upPlayerOne.setLayout(new GridLayout(2,1,5,3));
		midPlayerOne.setLayout(new GridLayout(3,1,5,3));
		downPlayerOne.setLayout(new GridLayout(1,2,5,3));
		playerOneBarrelButtonContainer.setLayout(new GridLayout(1,4,5,3));
		playerOneSurpriseButtonContainer.setLayout(new GridLayout(1,6,5,3));
		midPlayerOnePanelConatiner.setLayout(new GridLayout(2,1,5,3));
		midPlayerOneComboboxContainer.setLayout(new GridLayout(1,2,5,3));
		
		/*vista del panel Principal*/
		panelPlayerOne.add(upPlayerOne);
		panelPlayerOne.add(midPlayerOne);
		panelPlayerOne.add(downPlayerOne);
		
		/*panel de botones de barriles*/
		playerOneBarrelButtonContainer.add(barrilRojoButonPlayerOne);
		playerOneBarrelButtonContainer.add(barrilAmarilloButonPlayerOne);
		playerOneBarrelButtonContainer.add(barrilVerdeButonPlayerOne);
		playerOneBarrelButtonContainer.add(barrilAzulButonPlayerOne);
		
		/*panel de botones de sorpresas*/
		playerOneSurpriseButtonContainer.add(martilloButonPlayerOne);
		playerOneSurpriseButtonContainer.add(cerezaButonPlayerOne);
		playerOneSurpriseButtonContainer.add(manzanaButonPlayerOne);
		playerOneSurpriseButtonContainer.add(hongoButonPlayerOne);
		playerOneSurpriseButtonContainer.add(sogaButonPlayerOne);
		playerOneSurpriseButtonContainer.add(corazonButonPlayerOne);
		
		/* midPlayerOneComboboxContainer */
		midPlayerOneComboboxContainer.add(colorPlayerMenuPlayerOne);
		midPlayerOneComboboxContainer.add(colorPrincesMenuPlayerOne);
		
		/* midPlayerOnePanelConatiner */
		midPlayerOnePanelConatiner.add(midPlayerOneColorsImageContainer);
		midPlayerOnePanelConatiner.add(midPlayerOneComboboxContainer);
		
		/*panel de tipos de barriles*/
		upPlayerOne.add(upPlayerOneImageContainer);
		upPlayerOne.add(playerOneBarrelButtonContainer, BorderLayout.CENTER);
		
		/*panel de tipos de sorpresas*/
		midPlayerOne.add(midPlayerOneSurpriseImageContainer);
		midPlayerOne.add(playerOneSurpriseButtonContainer, BorderLayout.CENTER);
		midPlayerOne.add(midPlayerOnePanelConatiner);
		
		/*panel botones jugar y regresar*/
		downPlayerOne.add(jugarPlayerOne);
		downPlayerOne.add(regresarPlayerOne);
		
		/*poner el panel principal en el menu*/
		panelCards.add(panelPlayerOne,"panelPlayerOne");
		
	}

	/**
	 * Prepara el menu de la configuracion del juego(dos jugadores)
	 */
	private void prepareMenuConfiguracionTwoPlayers() {
		/*Creacion de los paneles*/
		panelTwoPlayers= new JPanel();
		upTwoPlayers= new JPanel();
		midTwoPlayers= new JPanel();
		downTwoPlayers= new JPanel();
		twoPlayersBarrelButtonContainer= new JPanel();
		twoPlayersSurpriseButtonContainer= new JPanel();
		upTwoPlayersImageContainer= new JPanel();
		midTwoPlayersSurpriseImageContainer= new JPanel();
		midTwoPlayersColorsImageContainer= new JPanel();
		midTwoPlayersComboboxContainer= new JPanel();
		midTwoPlayersPanelConatiner= new JPanel();
		
		botonesTwoPlayers= new ArrayList<JButton>();
		
		/*creacion de los Combobox de los colores*/
		colorPlayerMenuTwoPlayersOne= new JComboBox<String>();
		colorPlayerMenuTwoPlayersTwo= new JComboBox<String>();
		colorPrincesMenuTwoPlayers= new JComboBox<String>();
		
		/*Creacion de los botones*/
		regresarTwoPlayers= new JButton("regresarTwoPlayers");
		jugarTwoPlayers= new JButton("jugarTwoPlayers");
		barrilRojoButonTwoPlayers= new JButton("barrilRojoButonTwoPlayers");
		barrilAmarilloButonTwoPlayers= new JButton("barrilAmarilloButonTwoPlayers");
		barrilVerdeButonTwoPlayers= new JButton("barrilVerdeButonTwoPlayers");
		barrilAzulButonTwoPlayers= new JButton("barrilAzulButonTwoPlayers");
		martilloButonTwoPlayers= new JButton("martilloButonTwoPlayers");
		cerezaButonTwoPlayers= new JButton("cerezaButonTwoPlayers");
		manzanaButonTwoPlayers= new JButton("manzanaButonTwoPlayers");
		hongoButonTwoPlayers= new JButton("hongoButonTwoPlayers");
		sogaButonTwoPlayers= new JButton("sogaButonTwoPlayers");
		corazonButonTwoPlayers= new JButton("corazonButonTwoPlayers");
		
		botonesTwoPlayers.add(barrilRojoButonPlayerOne);
		botonesTwoPlayers.add(barrilAmarilloButonPlayerOne);
		botonesTwoPlayers.add(barrilVerdeButonPlayerOne);
		botonesTwoPlayers.add(barrilAzulButonPlayerOne);
		botonesTwoPlayers.add(martilloButonPlayerOne);
		botonesTwoPlayers.add(cerezaButonPlayerOne);
		botonesTwoPlayers.add(manzanaButonPlayerOne);
		botonesTwoPlayers.add(hongoButonPlayerOne);
		botonesTwoPlayers.add(sogaButonPlayerOne);
		botonesTwoPlayers.add(corazonButonPlayerOne);
		
		/* preparando los combobox de los colores */
		/* el de jugador uno */
		colorPlayerMenuTwoPlayersOne.addItem("Jugador Uno Rojo");
		colorPlayerMenuTwoPlayersOne.addItem("Jugador Uno Blanco");
		colorPlayerMenuTwoPlayersOne.addItem("Jugador Uno Gris");
		colorPlayerMenuTwoPlayersOne.addItem("Jugador Uno Morado");
		colorPlayerMenuTwoPlayersOne.addItem("Jugador Uno Naranja");
		colorPlayerMenuTwoPlayersOne.addItem("Jugador Uno Negro");
		colorPlayerMenuTwoPlayersOne.addItem("Jugador Uno Verde");
		colorPlayerMenuTwoPlayersOne.addItem("Jugador Uno Rosa");
		
		/* el de jugador dos */
		colorPlayerMenuTwoPlayersTwo.addItem("Jugador Dos Verde");
		colorPlayerMenuTwoPlayersTwo.addItem("Jugador Dos Blanco");
		colorPlayerMenuTwoPlayersTwo.addItem("Jugador Dos Gris");
		colorPlayerMenuTwoPlayersTwo.addItem("Jugador Dos Morado");
		colorPlayerMenuTwoPlayersTwo.addItem("Jugador Dos Naranja");
		colorPlayerMenuTwoPlayersTwo.addItem("Jugador Dos Negro");
		colorPlayerMenuTwoPlayersTwo.addItem("Jugador Dos Rojo");
		colorPlayerMenuTwoPlayersTwo.addItem("Jugador Dos Rosa");
		
		/* el de la princesa */
		colorPrincesMenuTwoPlayers.addItem("Princesa Azul");
		colorPrincesMenuTwoPlayers.addItem("Princesa Cafe");
		colorPrincesMenuTwoPlayers.addItem("Princesa Morada");
		colorPrincesMenuTwoPlayers.addItem("Princesa Roja");
		colorPrincesMenuTwoPlayers.addItem("Princesa Rosa");
		colorPrincesMenuTwoPlayers.addItem("Princesa Verde");
		
		/*fondo de los botones*/
		ponerFondo(jugarTwoPlayers,"images/principal/jugar.png");
		ponerFondo(regresarTwoPlayers,"images/principal/regresar.png");
		
		/*barriles*/
		ponerFondo(barrilRojoButonTwoPlayers,"images/Barriles/barrilrojo5.png");
		ponerFondo(barrilAmarilloButonTwoPlayers,"images/Barriles/barrilamarillo5.png");
		ponerFondo(barrilVerdeButonTwoPlayers,"images/Barriles/barrilverde5.png");
		ponerFondo(barrilAzulButonTwoPlayers,"images/Barriles/barrilazul5.png");
		
		/*poderes*/
		ponerFondo(martilloButonTwoPlayers,"images/poderes/martillo.png");
		ponerFondo(cerezaButonTwoPlayers,"images/poderes/cereza.png");
		ponerFondo(manzanaButonTwoPlayers,"images/poderes/manzana.png");
		ponerFondo(hongoButonTwoPlayers,"images/poderes/hongo.png");
		ponerFondo(sogaButonTwoPlayers,"images/poderes/cuerda.png");
		ponerFondo(corazonButonTwoPlayers,"images/poderes/corazon.png");
		
		/*fondo de los paneles con imagen*/
		ponerFondo(upTwoPlayersImageContainer,"images/principal/Seleccion_Barriles.png");
		ponerFondo(midTwoPlayersSurpriseImageContainer,"images/principal/Seleccion_Sorpresas.png");
		ponerFondo(midTwoPlayersColorsImageContainer,"images/principal/Seleccion_ColoresMenuJugadorUno.png");
		
		/*color de los paneles*/
		panelTwoPlayers.setBackground(colorDefault);
		upTwoPlayers.setBackground(colorDefault);
		midTwoPlayers.setBackground(colorDefault);
		downTwoPlayers.setBackground(colorDefault);
		twoPlayersBarrelButtonContainer.setBackground(colorDefault);
		twoPlayersSurpriseButtonContainer.setBackground(colorDefault);
		midTwoPlayersPanelConatiner.setBackground(colorDefault);
		midTwoPlayersComboboxContainer.setBackground(colorDefault);
		
		/*color de los Botones*/
		regresarTwoPlayers.setBackground(colorDefault);
		jugarTwoPlayers.setBackground(colorDefault);
		barrilRojoButonTwoPlayers.setBackground(colorDefault);
		barrilAmarilloButonTwoPlayers.setBackground(colorDefault);
		barrilVerdeButonTwoPlayers.setBackground(colorDefault);
		barrilAzulButonTwoPlayers.setBackground(colorDefault);
		martilloButonTwoPlayers.setBackground(colorDefault);
		martilloButonTwoPlayers.setForeground(colorDefault);
		cerezaButonTwoPlayers.setBackground(colorDefault);
		cerezaButonTwoPlayers.setForeground(colorDefault);
		manzanaButonTwoPlayers.setBackground(colorDefault);
		manzanaButonTwoPlayers.setForeground(colorDefault);
		hongoButonTwoPlayers.setBackground(colorDefault);
		hongoButonTwoPlayers.setForeground(colorDefault);
		sogaButonTwoPlayers.setBackground(colorDefault);
		sogaButonTwoPlayers.setForeground(colorDefault);
		corazonButonTwoPlayers.setBackground(colorDefault);
		corazonButonTwoPlayers.setForeground(colorDefault);

		
		/*layout de los paneles*/
		panelTwoPlayers.setLayout(new GridLayout(3,1,5,3));
		upTwoPlayers.setLayout(new GridLayout(2,1,5,3));
		midTwoPlayers.setLayout(new GridLayout(3,1,5,3));
		downTwoPlayers.setLayout(new GridLayout(1,2,5,3));
		twoPlayersBarrelButtonContainer.setLayout(new GridLayout(1,4,5,3));
		twoPlayersSurpriseButtonContainer.setLayout(new GridLayout(1,6,5,3));
		midTwoPlayersPanelConatiner.setLayout(new GridLayout(2,1,5,3));
		midTwoPlayersComboboxContainer.setLayout(new GridLayout(1,2,5,3));
		
		/*vista del panel Principal*/
		panelTwoPlayers.add(upTwoPlayers);
		panelTwoPlayers.add(midTwoPlayers);
		panelTwoPlayers.add(downTwoPlayers);
		
		/*panel de botones de barriles*/
		twoPlayersBarrelButtonContainer.add(barrilRojoButonTwoPlayers);
		twoPlayersBarrelButtonContainer.add(barrilAmarilloButonTwoPlayers);
		twoPlayersBarrelButtonContainer.add(barrilVerdeButonTwoPlayers);
		twoPlayersBarrelButtonContainer.add(barrilAzulButonTwoPlayers);
		
		/*panel de botones de sorpresas*/
		twoPlayersSurpriseButtonContainer.add(martilloButonTwoPlayers);
		twoPlayersSurpriseButtonContainer.add(cerezaButonTwoPlayers);
		twoPlayersSurpriseButtonContainer.add(manzanaButonTwoPlayers);
		twoPlayersSurpriseButtonContainer.add(hongoButonTwoPlayers);
		twoPlayersSurpriseButtonContainer.add(sogaButonTwoPlayers);
		twoPlayersSurpriseButtonContainer.add(corazonButonTwoPlayers);
		
		/* midPlayerOneComboboxContainer */
		midTwoPlayersComboboxContainer.add(colorPlayerMenuTwoPlayersOne);
		midTwoPlayersComboboxContainer.add(colorPlayerMenuTwoPlayersTwo);
		midTwoPlayersComboboxContainer.add(colorPrincesMenuTwoPlayers);
		
		/* midPlayerOnePanelConatiner */
		midTwoPlayersPanelConatiner.add(midTwoPlayersColorsImageContainer);
		midTwoPlayersPanelConatiner.add(midTwoPlayersComboboxContainer);
		
		/*panel de tipos de barriles*/
		upTwoPlayers.add(upTwoPlayersImageContainer);
		upTwoPlayers.add(twoPlayersBarrelButtonContainer, BorderLayout.CENTER);
		
		/*panel de tipos de sorpresas*/
		midTwoPlayers.add(midTwoPlayersSurpriseImageContainer);
		midTwoPlayers.add(twoPlayersSurpriseButtonContainer, BorderLayout.CENTER);
		midTwoPlayers.add(midTwoPlayersPanelConatiner);
		
		/*panel botones jugar y regresar*/
		downTwoPlayers.add(jugarTwoPlayers);
		downTwoPlayers.add(regresarTwoPlayers);
		
		/*poner el panel principal en el menu*/
		panelCards.add(panelTwoPlayers,"panelTwoPlayers");
		
	}
	
	/**
	 * Prepara el menu de la configuracion del juego(vs maquina)
	 */
	private void prepareMenuConfiguracionVsMaquina() {
		/*Creacion de los paneles*/
		panelVsMaquina= new JPanel();
		upVsMaquina= new JPanel();
		midVsMaquina= new JPanel();
		downVsMaquina= new JPanel();
		vsMaquinaBarrelButtonContainer= new JPanel();
		vsMaquinaSurpriseButtonContainer= new JPanel();
		upVsMaquinaImageContainer= new JPanel();
		midVsMaquinaSurpriseImageContainer= new JPanel();
		midVsMaquinaColorsImageContainer= new JPanel();
		midVsMaquinaComboboxContainer= new JPanel();
		midVsMaquinaPanelConatiner= new JPanel();
		
		botonesVSMaquina= new ArrayList<JButton>();
		
		/*creacion de los Combobox de los colores*/
		colorPlayerMenuVsMaquina= new JComboBox<String>();
		colorPrincesMenuVsMaquina= new JComboBox<String>();
		PlayerTypeOne= new JComboBox<String>();
		PlayerTypeTwo= new JComboBox<String>();
		
		/*Creacion de los botones*/
		regresarVsMaquina= new JButton("regresarVsMaquina");
		jugarVsMaquina= new JButton("jugarVsMaquina");
		barrilRojoButonVsMaquina= new JButton("barrilRojoButonVsMaquina");
		barrilAmarilloButonVsMaquina= new JButton("barrilAmarilloButonVsMaquina");
		barrilVerdeButonVsMaquina= new JButton("barrilVerdeButonVsMaquina");
		barrilAzulButonVsMaquina= new JButton("barrilAzulButonVsMaquina");
		martilloButonVsMaquina= new JButton("martilloButonVsMaquina");
		cerezaButonVsMaquina= new JButton("cerezaButonVsMaquina");
		manzanaButonVsMaquina= new JButton("manzanaButonVsMaquina");
		hongoButonVsMaquina= new JButton("hongoButonVsMaquina");
		sogaButonVsMaquina= new JButton("sogaButonVsMaquina");
		corazonButonVsMaquina= new JButton("corazonButonVsMaquina");
		
		botonesVSMaquina.add(barrilRojoButonPlayerOne);
		botonesVSMaquina.add(barrilAmarilloButonPlayerOne);
		botonesVSMaquina.add(barrilVerdeButonPlayerOne);
		botonesVSMaquina.add(barrilAzulButonPlayerOne);
		botonesVSMaquina.add(martilloButonPlayerOne);
		botonesVSMaquina.add(cerezaButonPlayerOne);
		botonesVSMaquina.add(manzanaButonPlayerOne);
		botonesVSMaquina.add(hongoButonPlayerOne);
		botonesVSMaquina.add(sogaButonPlayerOne);
		botonesVSMaquina.add(corazonButonPlayerOne);
		
		/* preparando los combobox de los colores */
		/* el de jugador uno */
		PlayerTypeOne.addItem("Jugador");
		PlayerTypeOne.addItem("Mimo");
		PlayerTypeOne.addItem("Protector");
		PlayerTypeOne.addItem("Temeroso");
		
		/* el color de jugador uno */
		colorPlayerMenuVsMaquina.addItem("Jugador Rojo");
		colorPlayerMenuVsMaquina.addItem("Jugador Blanco");
		colorPlayerMenuVsMaquina.addItem("Jugador Gris");
		colorPlayerMenuVsMaquina.addItem("Jugador Morado");
		colorPlayerMenuVsMaquina.addItem("Jugador Naranja");
		colorPlayerMenuVsMaquina.addItem("Jugador Negro");
		colorPlayerMenuVsMaquina.addItem("Jugador Verde");
		colorPlayerMenuVsMaquina.addItem("Jugador Rosa");
		
		/* el de jugador dos */
		PlayerTypeTwo.addItem("Mimo");
		PlayerTypeTwo.addItem("Protector");
		PlayerTypeTwo.addItem("Temeroso");
		
		/* el de la princesa */
		colorPrincesMenuVsMaquina.addItem("Princesa Azul");
		colorPrincesMenuVsMaquina.addItem("Princesa Cafe");
		colorPrincesMenuVsMaquina.addItem("Princesa Morada");
		colorPrincesMenuVsMaquina.addItem("Princesa Roja");
		colorPrincesMenuVsMaquina.addItem("Princesa Rosa");
		colorPrincesMenuVsMaquina.addItem("Princesa Verde");
		
		/*fondo de los botones*/
		ponerFondo(jugarVsMaquina,"images/principal/jugar.png");
		ponerFondo(regresarVsMaquina,"images/principal/regresar.png");
		
		/*barriles*/
		ponerFondo(barrilRojoButonVsMaquina,"images/Barriles/barrilrojo5.png");
		ponerFondo(barrilAmarilloButonVsMaquina,"images/Barriles/barrilamarillo5.png");
		ponerFondo(barrilVerdeButonVsMaquina,"images/Barriles/barrilverde5.png");
		ponerFondo(barrilAzulButonVsMaquina,"images/Barriles/barrilazul5.png");
		
		/*poderes*/
		ponerFondo(martilloButonVsMaquina,"images/poderes/martillo.png");
		ponerFondo(cerezaButonVsMaquina,"images/poderes/cereza.png");
		ponerFondo(manzanaButonVsMaquina,"images/poderes/manzana.png");
		ponerFondo(hongoButonVsMaquina,"images/poderes/hongo.png");
		ponerFondo(sogaButonVsMaquina,"images/poderes/cuerda.png");
		ponerFondo(corazonButonVsMaquina,"images/poderes/corazon.png");
		
		/*fondo de los paneles con imagen*/
		ponerFondo(upVsMaquinaImageContainer,"images/principal/Seleccion_Barriles.png");
		ponerFondo(midVsMaquinaSurpriseImageContainer,"images/principal/Seleccion_Sorpresas.png");
		ponerFondo(midVsMaquinaColorsImageContainer,"images/principal/Seleccion_ColoresMenuJugadorUno.png");
		
		/*color de los paneles*/
		panelVsMaquina.setBackground(colorDefault);
		upVsMaquina.setBackground(colorDefault);
		midVsMaquina.setBackground(colorDefault);
		downVsMaquina.setBackground(colorDefault);
		vsMaquinaBarrelButtonContainer.setBackground(colorDefault);
		vsMaquinaSurpriseButtonContainer.setBackground(colorDefault);
		midVsMaquinaPanelConatiner.setBackground(colorDefault);
		midVsMaquinaComboboxContainer.setBackground(colorDefault);
		
		/*color de los Botones*/
		regresarVsMaquina.setBackground(colorDefault);
		jugarVsMaquina.setBackground(colorDefault);
		barrilRojoButonVsMaquina.setBackground(colorDefault);
		barrilAmarilloButonVsMaquina.setBackground(colorDefault);
		barrilVerdeButonVsMaquina.setBackground(colorDefault);
		barrilAzulButonVsMaquina.setBackground(colorDefault);
		martilloButonVsMaquina.setBackground(colorDefault);
		martilloButonVsMaquina.setForeground(colorDefault);
		cerezaButonVsMaquina.setBackground(colorDefault);
		cerezaButonVsMaquina.setForeground(colorDefault);
		manzanaButonVsMaquina.setBackground(colorDefault);
		manzanaButonVsMaquina.setForeground(colorDefault);
		hongoButonVsMaquina.setBackground(colorDefault);
		hongoButonVsMaquina.setForeground(colorDefault);
		sogaButonVsMaquina.setBackground(colorDefault);
		sogaButonVsMaquina.setForeground(colorDefault);
		corazonButonVsMaquina.setBackground(colorDefault);
		corazonButonVsMaquina.setForeground(colorDefault);
		
		/*layout de los paneles*/
		panelVsMaquina.setLayout(new GridLayout(3,1,5,3));
		upVsMaquina.setLayout(new GridLayout(2,1,5,3));
		midVsMaquina.setLayout(new GridLayout(3,1,5,3));
		downVsMaquina.setLayout(new GridLayout(1,2,5,3));
		vsMaquinaBarrelButtonContainer.setLayout(new GridLayout(1,4,5,3));
		vsMaquinaSurpriseButtonContainer.setLayout(new GridLayout(1,6,5,3));
		midVsMaquinaPanelConatiner.setLayout(new GridLayout(2,1,5,3));
		midVsMaquinaComboboxContainer.setLayout(new GridLayout(1,4,5,3));
		
		/*vista del panel Principal*/
		panelVsMaquina.add(upVsMaquina);
		panelVsMaquina.add(midVsMaquina);
		panelVsMaquina.add(downVsMaquina);
		
		/*panel de botones de barriles*/
		vsMaquinaBarrelButtonContainer.add(barrilRojoButonVsMaquina);
		vsMaquinaBarrelButtonContainer.add(barrilAmarilloButonVsMaquina);
		vsMaquinaBarrelButtonContainer.add(barrilVerdeButonVsMaquina);
		vsMaquinaBarrelButtonContainer.add(barrilAzulButonVsMaquina);
		
		/*panel de botones de sorpresas*/
		vsMaquinaSurpriseButtonContainer.add(martilloButonVsMaquina);
		vsMaquinaSurpriseButtonContainer.add(cerezaButonVsMaquina);
		vsMaquinaSurpriseButtonContainer.add(manzanaButonVsMaquina);
		vsMaquinaSurpriseButtonContainer.add(hongoButonVsMaquina);
		vsMaquinaSurpriseButtonContainer.add(sogaButonVsMaquina);
		vsMaquinaSurpriseButtonContainer.add(corazonButonVsMaquina);
		
		/* midPlayerOneComboboxContainer */
		midVsMaquinaComboboxContainer.add(PlayerTypeOne);
		midVsMaquinaComboboxContainer.add(colorPlayerMenuVsMaquina);
		midVsMaquinaComboboxContainer.add(PlayerTypeTwo);
		midVsMaquinaComboboxContainer.add(colorPrincesMenuVsMaquina);
		
		
		/* midPlayerOnePanelConatiner */
		midVsMaquinaPanelConatiner.add(midVsMaquinaColorsImageContainer);
		midVsMaquinaPanelConatiner.add(midVsMaquinaComboboxContainer);
		
		/*panel de tipos de barriles*/
		upVsMaquina.add(upVsMaquinaImageContainer);
		upVsMaquina.add(vsMaquinaBarrelButtonContainer, BorderLayout.CENTER);
		
		/*panel de tipos de sorpresas*/
		midVsMaquina.add(midVsMaquinaSurpriseImageContainer);
		midVsMaquina.add(vsMaquinaSurpriseButtonContainer, BorderLayout.CENTER);
		midVsMaquina.add(midVsMaquinaPanelConatiner);
		
		/*panel botones jugar y regresar*/
		downVsMaquina.add(jugarVsMaquina);
		downVsMaquina.add(regresarVsMaquina);
		
		/*poner el panel principal en el menu*/
		panelCards.add(panelVsMaquina,"panelVsMaquina");
		
	}
	
	/**
	 * Prepara las acciones del Juego
	 */
	private void prepareAcciones() {
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		prepareAccionesMenu();
		prepareAccionesInstrucciones();
		prepareAccionesGameTypeChooser();	
		prepareAccionesMenuConfiguracionPlayerOne();
		prepareAccionesMenuConfiguracionTwoPlayers();
		prepareAccionesMenuConfiguracionVsMaquina();
		//actualiza();
	}
	
	/**
	 * Prepara las acciones del menu principal del Juego
	 */
	private void prepareAccionesMenu() {
		/*El metodo de Abrir un juego */
		abrir.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						accionAbrirJuego();
					}
				});
		
		/*El metodo de Jugar*/
		jugarStartMenu.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						accionIrGameTypeChooser();
					}
				});
		
		/*El metodo de Instrucciones*/
		instrucciones.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						accionIrInstrucciones();
					}
				});
		
	}
	
	/**
	 * Prepara las acciones de las intrucciones del Juego
	 */
	private void prepareAccionesInstrucciones() {
		/*El metodo de Regresar en Instrucciones*/
		regresarIns.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						accionRegresar();
					}
				});
	}

	/**
	 * Prepara las acciones del tablero de seleccion del tipo de Juego
	 */
	private void prepareAccionesGameTypeChooser() {
		/*El metodo de Regresar en GameTypeChooser*/
		regresarGameType.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						accionRegresar();
					}
				});
		
		/*el metodo jugar para PlayerOne*/
		onePlayer.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						accionIrJugarPlayerOne();
					}
				});		
		
		/*el metodo jugar para dos jugadores*/
		twoPlayer.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						accionIrJugarTwoPlayers();
					}
				});
		
		/*el metodo jugar para Vs Maquina*/
		vsMachine.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						accionIrJugarVsMaquina();
					}
				});
	}
	
	/**
	 * Prepara las acciones del menu de configuracion del Juego(un jugador)
	 */
	private void prepareAccionesMenuConfiguracionPlayerOne() {
		/*el metodo regresar menu de configuracion*/
		regresarPlayerOne.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						accionIrGameTypeChooser();
					}
				});
		
		/*el metodo de seleccion de barriles*/
		barrilRojoButonPlayerOne.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(barrilRojoButonPlayerOne.getBackground().equals(colorDefault)) {
							barrilRojoButonPlayerOne.setBackground(colorActivo);
						}
						else {
							barrilRojoButonPlayerOne.setBackground(colorDefault);
						}
					}
				});
		
		barrilAmarilloButonPlayerOne.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(barrilAmarilloButonPlayerOne.getBackground().equals(colorDefault)) {
							barrilAmarilloButonPlayerOne.setBackground(colorActivo);
						}
						else {
							barrilAmarilloButonPlayerOne.setBackground(colorDefault);
						}
					}
				});
		
		barrilVerdeButonPlayerOne.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(barrilVerdeButonPlayerOne.getBackground().equals(colorDefault)) {
							barrilVerdeButonPlayerOne.setBackground(colorActivo);
						}
						else {
							barrilVerdeButonPlayerOne.setBackground(colorDefault);
						}
					}
				});
		
		barrilAzulButonPlayerOne.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(barrilAzulButonPlayerOne.getBackground().equals(colorDefault)) {
							barrilAzulButonPlayerOne.setBackground(colorActivo);
						}
						else {
							barrilAzulButonPlayerOne.setBackground(colorDefault);
						}
					}
				});
		/*el metodo de seleccion de sorpresas*/
		martilloButonPlayerOne.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(martilloButonPlayerOne.getBackground().equals(colorDefault)) {
							martilloButonPlayerOne.setBackground(colorActivo);
							martilloButonPlayerOne.setForeground(colorActivo);
						}
						else {
							martilloButonPlayerOne.setBackground(colorDefault);
							martilloButonPlayerOne.setForeground(colorDefault);
						}
					}
				});
		
		cerezaButonPlayerOne.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(cerezaButonPlayerOne.getBackground().equals(colorDefault)) {
							cerezaButonPlayerOne.setBackground(colorActivo);
							cerezaButonPlayerOne.setForeground(colorActivo);
						}
						else {
							cerezaButonPlayerOne.setBackground(colorDefault);
							cerezaButonPlayerOne.setForeground(colorDefault);
						}
					}
				});
		
		manzanaButonPlayerOne.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(manzanaButonPlayerOne.getBackground().equals(colorDefault)) {
							manzanaButonPlayerOne.setBackground(colorActivo);
							manzanaButonPlayerOne.setForeground(colorActivo);
						}
						else {
							manzanaButonPlayerOne.setBackground(colorDefault);
							manzanaButonPlayerOne.setForeground(colorDefault);
						}
					}
				});
		
		hongoButonPlayerOne.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(hongoButonPlayerOne.getBackground().equals(colorDefault)) {
							hongoButonPlayerOne.setBackground(colorActivo);
							hongoButonPlayerOne.setForeground(colorActivo);
						}
						else {
							hongoButonPlayerOne.setBackground(colorDefault);
							hongoButonPlayerOne.setForeground(colorDefault);
						}
					}
				});
		
		sogaButonPlayerOne.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(sogaButonPlayerOne.getBackground().equals(colorDefault)) {
							sogaButonPlayerOne.setBackground(colorActivo);
							sogaButonPlayerOne.setForeground(colorActivo);
						}
						else {
							sogaButonPlayerOne.setBackground(colorDefault);
							sogaButonPlayerOne.setForeground(colorDefault);
						}
					}
				});
		
		corazonButonPlayerOne.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(corazonButonPlayerOne.getBackground().equals(colorDefault)) {
							corazonButonPlayerOne.setBackground(colorActivo);
							corazonButonPlayerOne.setForeground(colorActivo);
						}
						else {
							corazonButonPlayerOne.setBackground(colorDefault);
							corazonButonPlayerOne.setForeground(colorDefault);
						}
					}
				});
		
		/*El metodo de juego individual */
		jugarPlayerOne.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						configuracionPlayerOne();
						accionIrJugarIndividual();
						prepareJuego();
						procesoGuiActualizador.start();
						//procesoGuiBarriles.start();
						
					}
				});

		/*El metodo de finalizar el juego individual */
		acabarJuego.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						procesoGuiActualizador.stop();
						procesoGuiBarriles.stop();
						accionRegresar();
					}
				});
		
	}
	
	/**
	 * Prepara las acciones del menu de configuracion del Juego(dos jugadores)
	 */
	private void prepareAccionesMenuConfiguracionTwoPlayers() {
		/*el metodo regresar menu de configuracion*/
		regresarTwoPlayers.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						accionIrGameTypeChooser();
					}
				});
		
		/*el metodo de seleccion de barriles*/
		barrilRojoButonTwoPlayers.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(barrilRojoButonTwoPlayers.getBackground().equals(colorDefault)) {
							barrilRojoButonTwoPlayers.setBackground(colorActivo);
						}
						else {
							barrilRojoButonTwoPlayers.setBackground(colorDefault);
						}
					}
				});
		
		barrilAmarilloButonTwoPlayers.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(barrilAmarilloButonTwoPlayers.getBackground().equals(colorDefault)) {
							barrilAmarilloButonTwoPlayers.setBackground(colorActivo);
						}
						else {
							barrilAmarilloButonTwoPlayers.setBackground(colorDefault);
						}
					}
				});
		
		barrilVerdeButonTwoPlayers.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(barrilVerdeButonTwoPlayers.getBackground().equals(colorDefault)) {
							barrilVerdeButonTwoPlayers.setBackground(colorActivo);
						}
						else {
							barrilVerdeButonTwoPlayers.setBackground(colorDefault);
						}
					}
				});
		
		barrilAzulButonTwoPlayers.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(barrilAzulButonTwoPlayers.getBackground().equals(colorDefault)) {
							barrilAzulButonTwoPlayers.setBackground(colorActivo);
						}
						else {
							barrilAzulButonTwoPlayers.setBackground(colorDefault);
						}
					}
				});
		/*el metodo de seleccion de sorpresas*/
		martilloButonTwoPlayers.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(martilloButonTwoPlayers.getBackground().equals(colorDefault)) {
							martilloButonTwoPlayers.setBackground(colorActivo);
							martilloButonTwoPlayers.setForeground(colorActivo);
						}
						else {
							martilloButonTwoPlayers.setBackground(colorDefault);
							martilloButonTwoPlayers.setForeground(colorDefault);
						}
					}
				});
		
		cerezaButonTwoPlayers.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(cerezaButonTwoPlayers.getBackground().equals(colorDefault)) {
							cerezaButonTwoPlayers.setBackground(colorActivo);
							cerezaButonTwoPlayers.setForeground(colorActivo);
						}
						else {
							cerezaButonTwoPlayers.setBackground(colorDefault);
							cerezaButonTwoPlayers.setForeground(colorDefault);
						}
					}
				});
		
		manzanaButonTwoPlayers.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(manzanaButonTwoPlayers.getBackground().equals(colorDefault)) {
							manzanaButonTwoPlayers.setBackground(colorActivo);
							manzanaButonTwoPlayers.setForeground(colorActivo);
						}
						else {
							manzanaButonTwoPlayers.setBackground(colorDefault);
							manzanaButonTwoPlayers.setForeground(colorDefault);
						}
					}
				});
		
		hongoButonTwoPlayers.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(hongoButonTwoPlayers.getBackground().equals(colorDefault)) {
							hongoButonTwoPlayers.setBackground(colorActivo);
							hongoButonTwoPlayers.setForeground(colorActivo);
						}
						else {
							hongoButonTwoPlayers.setBackground(colorDefault);
							hongoButonTwoPlayers.setForeground(colorDefault);
						}
					}
				});
		
		sogaButonTwoPlayers.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(sogaButonTwoPlayers.getBackground().equals(colorDefault)) {
							sogaButonTwoPlayers.setBackground(colorActivo);
							sogaButonTwoPlayers.setForeground(colorActivo);
						}
						else {
							sogaButonTwoPlayers.setBackground(colorDefault);
							sogaButonTwoPlayers.setForeground(colorDefault);
						}
					}
				});
		
		corazonButonTwoPlayers.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(corazonButonTwoPlayers.getBackground().equals(colorDefault)) {
							corazonButonTwoPlayers.setBackground(colorActivo);
							corazonButonTwoPlayers.setForeground(colorActivo);
						}
						else {
							corazonButonTwoPlayers.setBackground(colorDefault);
							corazonButonTwoPlayers.setForeground(colorDefault);
						}
					}
				});
		/*El metodo de juego de dos */
		jugarTwoPlayers.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						configuracionTwoPlayers();
						accionIrJugarDeDos();
					}
				});


		/*El metodo de finalizar el juego de dos*/
		acabarJuego.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						accionRegresar();
					}
				});
				 
	}

	/**
	 * Prepara las acciones del menu de configuracion del Juego(vs maquina)
	 */
	private void prepareAccionesMenuConfiguracionVsMaquina() {
		/*el metodo regresar menu de configuracion*/
		regresarVsMaquina.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						accionIrGameTypeChooser();
					}
				});
		
		/*el metodo de seleccion de barriles*/
		barrilRojoButonVsMaquina.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(barrilRojoButonVsMaquina.getBackground().equals(colorDefault)) {
							barrilRojoButonVsMaquina.setBackground(colorActivo);
						}
						else {
							barrilRojoButonVsMaquina.setBackground(colorDefault);
						}
					}
				});
		
		barrilAmarilloButonVsMaquina.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(barrilAmarilloButonVsMaquina.getBackground().equals(colorDefault)) {
							barrilAmarilloButonVsMaquina.setBackground(colorActivo);
						}
						else {
							barrilAmarilloButonVsMaquina.setBackground(colorDefault);
						}
					}
				});
		
		barrilVerdeButonVsMaquina.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(barrilVerdeButonVsMaquina.getBackground().equals(colorDefault)) {
							barrilVerdeButonVsMaquina.setBackground(colorActivo);
						}
						else {
							barrilVerdeButonVsMaquina.setBackground(colorDefault);
						}
					}
				});
		
		barrilAzulButonVsMaquina.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(barrilAzulButonVsMaquina.getBackground().equals(colorDefault)) {
							barrilAzulButonVsMaquina.setBackground(colorActivo);
						}
						else {
							barrilAzulButonVsMaquina.setBackground(colorDefault);
						}
					}
				});
		/*el metodo de seleccion de sorpresas*/
		martilloButonVsMaquina.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(martilloButonVsMaquina.getBackground().equals(colorDefault)) {
							martilloButonVsMaquina.setBackground(colorActivo);
							martilloButonVsMaquina.setForeground(colorActivo);
						}
						else {
							martilloButonVsMaquina.setBackground(colorDefault);
							martilloButonVsMaquina.setForeground(colorDefault);
						}
					}
				});
		
		cerezaButonVsMaquina.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(cerezaButonVsMaquina.getBackground().equals(colorDefault)) {
							cerezaButonVsMaquina.setBackground(colorActivo);
							cerezaButonVsMaquina.setForeground(colorActivo);
						}
						else {
							cerezaButonVsMaquina.setBackground(colorDefault);
							cerezaButonVsMaquina.setForeground(colorDefault);
						}
					}
				});
		
		manzanaButonVsMaquina.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(manzanaButonVsMaquina.getBackground().equals(colorDefault)) {
							manzanaButonVsMaquina.setBackground(colorActivo);
							manzanaButonVsMaquina.setForeground(colorActivo);
						}
						else {
							manzanaButonVsMaquina.setBackground(colorDefault);
							manzanaButonVsMaquina.setForeground(colorDefault);
						}
					}
				});
		
		hongoButonVsMaquina.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(hongoButonVsMaquina.getBackground().equals(colorDefault)) {
							hongoButonVsMaquina.setBackground(colorActivo);
							hongoButonVsMaquina.setForeground(colorActivo);
						}
						else {
							hongoButonVsMaquina.setBackground(colorDefault);
							hongoButonVsMaquina.setForeground(colorDefault);
						}
					}
				});
		
		sogaButonVsMaquina.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(sogaButonVsMaquina.getBackground().equals(colorDefault)) {
							sogaButonVsMaquina.setBackground(colorActivo);
							sogaButonVsMaquina.setForeground(colorActivo);
						}
						else {
							sogaButonVsMaquina.setBackground(colorDefault);
							sogaButonVsMaquina.setForeground(colorDefault);
						}
					}
				});
		
		corazonButonVsMaquina.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(corazonButonVsMaquina.getBackground().equals(colorDefault)) {
							corazonButonVsMaquina.setBackground(colorActivo);
							corazonButonVsMaquina.setForeground(colorActivo);
						}
						else {
							corazonButonVsMaquina.setBackground(colorDefault);
							corazonButonVsMaquina.setForeground(colorDefault);
						}
					}
				});
		
		/*El metodo de juego contra la maquina */
		jugarVsMaquina.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						configuracionVsMaquina();
						accionIrJugarVSMaquina();
					}
				});


		/*El metodo de finalizar el juego contra la maquina */
		acabarJuego.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						accionRegresar();
					}
				});
				
	}
	
	/**
	 * Muestra el tablero de la informacion del juego(vs maquina) 
	 */
	private void accionIrJugarVSMaquina() {
		((CardLayout)panelCards.getLayout()).show(panelCards,"Tablero");
	}
	
	/**
	 * Muestra el tablero de la informacion del juego(dos jugadores)
	 */
    private void accionIrJugarDeDos() {
    	((CardLayout)panelCards.getLayout()).show(panelCards,"Tablero");
		
	}
    
    /**
	 * Muestra el tablero de la informacion del juego(un jugador)
	 */
    private void accionIrJugarIndividual() {
    	((CardLayout)panelCards.getLayout()).show(panelCards,"Tablero");
	}
	
    /**
	 * Abre un Tablero guardado ya configurado
	 */
	private void accionAbrirJuego() {
		fileChooser.setVisible(true);
    	fileChooser.setDialogTitle("Abrir");
    	/*fileChooser.setFileFilter(new FileNameExtensionFilter(aun no sabemos));
    	int confirmado = fileChooser.showOpenDialog(this);
    	try {
    		if(confirmado== fileChooser.APPROVE_OPTION) {
    			tablero.abrir(fileChooser.getSelectedFile());
    			actualice();
    		}
    	}catch(DKoongException e) {
    		JOptionPane.showMessageDialog(this,e.getMessage());
    	}
    	*/
	}
	
	/**
	 * Muestra el tablero de las instrucciones(como jugar)
	 */
	private void accionIrInstrucciones() {
		((CardLayout)panelCards.getLayout()).show(panelCards,"Instrucciones");
	}
	
	/**
	 * Muestra el tablero del menu principal
	 */
	private void accionRegresar() {
		((CardLayout)panelCards.getLayout()).show(panelCards,"menu");
	}
	
	/**
	 * Muestra el tablero de la seleccion del tipo de juego
	 */
	private void accionIrGameTypeChooser() {
		((CardLayout)panelCards.getLayout()).show(panelCards,"GameTypeChooser");
	}
	
	/**
	 * Muestra el tablero del juego(un jugador)
	 */
	private void accionIrJugarPlayerOne() {		
		((CardLayout)panelCards.getLayout()).show(panelCards,"panelPlayerOne");
	}
	
	/**
	 * Muestra el tablero del juego(dos jugadores)
	 */
	private void accionIrJugarTwoPlayers() {
		((CardLayout)panelCards.getLayout()).show(panelCards,"panelTwoPlayers");
	}
	
	/**
	 * Muestra el tablero del juego(vs maquina)
	 */
	private void accionIrJugarVsMaquina() {
		((CardLayout)panelCards.getLayout()).show(panelCards,"panelVsMaquina");
	}
	
	/**
	 * Guarda la imformacion de la configuracion del juego(un solo jugador)
	 */
	private void configuracionPlayerOne() {
		ArrayList<String> barriles= new ArrayList<String>();
		ArrayList<String> sorpresas= new ArrayList<String>();
		String colorJugador= null;
		String colorPrincesa= null;
		String valorColorJugador=  String.valueOf(colorPlayerMenuPlayerOne.getSelectedItem());
		String valorColorPrincesa=  String.valueOf(colorPrincesMenuPlayerOne.getSelectedItem());
		
		/* elementos */
		for(JButton boton: botonesPlayerOne) {
			if(boton.getBackground().equals(colorActivo)) {
				/* barriles */
				if(boton.getText().equals("barrilRojoButonPlayerOne")){
					barriles.add("rojo");
				}
				else if(boton.getText().equals("barrilAmarilloButonPlayerOne")){
					barriles.add("amarillo");
				}
				else if(boton.getText().equals("barrilAzulButonPlayerOne")){
					barriles.add("azul");
				}
				else if(boton.getText().equals("barrilVerdeButonPlayerOne")){
					barriles.add("verde");
				}
				/* sorpresas */
				else if(boton.getText().equals("martilloButonPlayerOne")){
					sorpresas.add("martillo");
				}
				else if(boton.getText().equals("cerezaButonPlayerOne")){
					sorpresas.add("cereza");
				}
				else if(boton.getText().equals("manzanaButonPlayerOne")){
					sorpresas.add("manzana");
				}
				else if(boton.getText().equals("hongoButonPlayerOne")){
					sorpresas.add("hongo");
				}
				else if(boton.getText().equals("sogaButonPlayerOne")){
					sorpresas.add("soga");
				}
				else if(boton.getText().equals("corazonButonPlayerOne")){
					sorpresas.add("corazon");
				}					
			}
			/* ningun barril seleccionado*/
			if(barriles.size()== 0) {
				barriles.add("amarillo");
			}
			
			/*color del jugador*/
			if(valorColorJugador.equals("Mario Rojo")) {
				colorJugador= "rojo";
			}
			else if(valorColorJugador.equals("Mario Blanco")) {
				colorJugador= "blanco";
			}
			else if(valorColorJugador.equals("Mario Gris")) {
				colorJugador= "gris";
			}
			else if(valorColorJugador.equals("Mario Morado")) {
				colorJugador= "mora";
			}
			else if(valorColorJugador.equals("Mario Naranja")) {
				colorJugador= "naranja";
			}
			else if(valorColorJugador.equals("Mario Negro")) {
				colorJugador= "negro";
			}
			else if(valorColorJugador.equals("Mario Verde")) {
				colorJugador= "verde";
			}
			else if(valorColorJugador.equals("Mario Rosa")) {
				colorJugador= "rosa";
			}
			
			/*color de la Princesa*/
			if(valorColorPrincesa.equals("Princesa Azul")) {
				colorPrincesa= "princesaazul";
				}
				else if(valorColorPrincesa.equals("Princesa Cafe")) {
				colorPrincesa= "princesacafe";
				}
				else if(valorColorPrincesa.equals("Princesa Morada")) {
				colorPrincesa= "princesamorada";
				}
				else if(valorColorPrincesa.equals("Princesa Roja")) {
				colorPrincesa= "princesaroja";
				}
				else if(valorColorPrincesa.equals("Princesa Rosa")) {
				colorPrincesa= "princesarosa";
				}
				else if(valorColorPrincesa.equals("Princesa Verde")) {
				colorPrincesa= "princesaverde";
				}
			
			tabUpPanel.infoConfigPlayerOne(colorJugador, colorPrincesa, barriles, sorpresas);
		}
	}
	
	/**
	 * Guarda la imformacion de la configuracion del juego(dos jugadores)
	 */
	private void configuracionTwoPlayers() {
		ArrayList<String> barriles= new ArrayList<String>();
		ArrayList<String> sorpresas= new ArrayList<String>();
		String colorJugador= null;
		String colorJugador2= null;
		String colorPrincesa= null;
		String valorColorJugador=  String.valueOf(colorPlayerMenuTwoPlayersOne.getSelectedItem());
		String valorColorJugador2=  String.valueOf(colorPlayerMenuTwoPlayersTwo.getSelectedItem());
		String valorColorPrincesa=  String.valueOf(colorPrincesMenuTwoPlayers.getSelectedItem());
		
		/* elementos */
		for(JButton boton: botonesTwoPlayers) {
			if(boton.getBackground().equals(colorActivo)) {
				/* barriles */
				if(boton.getText().equals("barrilRojoButonTwoPlayers")){
					barriles.add("rojo");
				}
				else if(boton.getText().equals("barrilAmarilloButonTwoPlayers")){
					barriles.add("amarillo");
				}
				else if(boton.getText().equals("barrilAzulButonTwoPlayers")){
					barriles.add("azul");
				}
				else if(boton.getText().equals("barrilVerdeButonTwoPlayers")){
					barriles.add("verde");
				}
				/* sorpresas */
				else if(boton.getText().equals("martilloButonTwoPlayers")){
					sorpresas.add("martillo");
				}
				else if(boton.getText().equals("cerezaButonTwoPlayers")){
					sorpresas.add("cereza");
				}
				else if(boton.getText().equals("manzanaButonTwoPlayers")){
					sorpresas.add("manzana");
				}
				else if(boton.getText().equals("hongoButonTwoPlayers")){
					sorpresas.add("hongo");
				}
				else if(boton.getText().equals("sogaButonTwoPlayers")){
					sorpresas.add("soga");
				}
				else if(boton.getText().equals("corazonButonTwoPlayers")){
					sorpresas.add("corazon");
				}					
			}
			/* ningun barril seleccionado*/
			if(barriles.size()== 0) {
				barriles.add("amarillo");
			}
			
			/*color del jugador1*/
			if(valorColorJugador.equals("Mario Rojo")) {
				colorJugador= "rojo";
			}
			else if(valorColorJugador.equals("Mario Blanco")) {
				colorJugador= "blanco";
			}
			else if(valorColorJugador.equals("Mario Gris")) {
				colorJugador= "gris";
			}
			else if(valorColorJugador.equals("Mario Morado")) {
				colorJugador= "mora";
			}
			else if(valorColorJugador.equals("Mario Naranja")) {
				colorJugador= "naranja";
			}
			else if(valorColorJugador.equals("Mario Negro")) {
				colorJugador= "negro";
			}
			else if(valorColorJugador.equals("Mario Verde")) {
				colorJugador= "verde";
			}
			else if(valorColorJugador.equals("Mario Rosa")) {
				colorJugador= "rosa";
			}
			
			/*color del jugador2*/
			if(valorColorJugador2.equals("Mario Rojo")) {
				colorJugador2= "rojo";
			}
			else if(valorColorJugador2.equals("Mario Blanco")) {
				colorJugador2= "blanco";
			}
			else if(valorColorJugador2.equals("Mario Gris")) {
				colorJugador2= "gris";
			}
			else if(valorColorJugador2.equals("Mario Morado")) {
				colorJugador2= "morado";
			}
			else if(valorColorJugador2.equals("Mario Naranja")) {
				colorJugador2= "naranja";
			}
			else if(valorColorJugador2.equals("Mario Negro")) {
				colorJugador2= "negro";
			}
			else if(valorColorJugador2.equals("Mario Verde")) {
				colorJugador2= "verde";
			}
			else if(valorColorJugador2.equals("Mario Rosa")) {
				colorJugador2= "rosa";
			}
			
			/*color de la Princesa*/
			if(valorColorPrincesa.equals("Princesa Azul")) {
				colorPrincesa= "princesaazul";
				}
				else if(valorColorPrincesa.equals("Princesa Cafe")) {
				colorPrincesa= "princesacafe";
				}
				else if(valorColorPrincesa.equals("Princesa Morada")) {
				colorPrincesa= "princesamorada";
				}
				else if(valorColorPrincesa.equals("Princesa Roja")) {
				colorPrincesa= "princesaroja";
				}
				else if(valorColorPrincesa.equals("Princesa Rosa")) {
				colorPrincesa= "princesarosa";
				}
				else if(valorColorPrincesa.equals("Princesa Verde")) {
				colorPrincesa= "princesaverde";
				}
			}
			
			tabUpPanel.infoConfigTwoPlayers(colorJugador, colorJugador2, colorPrincesa, barriles, sorpresas);
		}
	
	/**
	 * Guarda la imformacion de la configuracion del juego(vs maquina)
	 */
	private void configuracionVsMaquina() {
		ArrayList<String> barriles= new ArrayList<String>();
		ArrayList<String> sorpresas= new ArrayList<String>();
		String tipoJugador= null;
		String colorJugador= null;
		String tipoJugador2= null;
		String colorPrincesa= null;
		String valorTipoJugador=  String.valueOf(PlayerTypeOne.getSelectedItem());
		String valorColorJugador=  String.valueOf(colorPlayerMenuVsMaquina.getSelectedItem());
		String valorTipoJugador2=  String.valueOf(PlayerTypeTwo.getSelectedItem());
		String valorColorPrincesa=  String.valueOf(colorPrincesMenuVsMaquina.getSelectedItem());
		
		/* elementos */
		for(JButton boton: botonesVSMaquina) {
			if(boton.getBackground().equals(colorActivo)) {
				/* barriles */
				if(boton.getText().equals("barrilRojoButonVsMaquina")){
					barriles.add("Rojo");
				}
				else if(boton.getText().equals("barrilAmarilloButonVsMaquina")){
					barriles.add("Amarillo");
				}
				else if(boton.getText().equals("barrilAzulButonVsMaquina")){
					barriles.add("Azul");
				}
				else if(boton.getText().equals("barrilVerdeButonVsMaquina")){
					barriles.add("Verde");
				}
				/* sorpresas */
				else if(boton.getText().equals("martilloButonVsMaquina")){
					sorpresas.add("Martillo");
				}
				else if(boton.getText().equals("cerezaButonVsMaquina")){
					sorpresas.add("Cereza");
				}
				else if(boton.getText().equals("manzanaButonVsMaquina")){
					sorpresas.add("Manzana");
				}
				else if(boton.getText().equals("hongoButonVsMaquina")){
					sorpresas.add("Hongo");
				}
				else if(boton.getText().equals("sogaButonVsMaquina")){
					sorpresas.add("Soga");
				}
				else if(boton.getText().equals("corazonButonVsMaquina")){
					sorpresas.add("Corazon");
				}					
			}
			/* ningun barril seleccionado*/
			if(barriles.size()== 0) {
				barriles.add("Amarillo");
			}
			
			/*tipo del jugador1*/
			if(valorTipoJugador.equals("Jugador")) {
				tipoJugador= "Jugador";
			}
			else if(valorTipoJugador.equals("Mimo")) {
				tipoJugador= "Mimo";
			}
			else if(valorTipoJugador.equals("Protector")) {
				tipoJugador= "Protector";
			}
			else if(valorTipoJugador.equals("Temeroso")) {
				tipoJugador= "Temeroso";
			}
			
			/*color del jugador1*/
			if(valorColorJugador.equals("Mario Rojo")) {
				colorJugador= "Rojo";
			}
			else if(valorColorJugador.equals("Mario Blanco")) {
				colorJugador= "Blanco";
			}
			else if(valorColorJugador.equals("Mario Gris")) {
				colorJugador= "Gris";
			}
			else if(valorColorJugador.equals("Mario Morado")) {
				colorJugador= "Morado";
			}
			else if(valorColorJugador.equals("Mario Naranja")) {
				colorJugador= "Naranja";
			}
			else if(valorColorJugador.equals("Mario Negro")) {
				colorJugador= "Negro";
			}
			else if(valorColorJugador.equals("Mario Verde")) {
				colorJugador= "Verde";
			}
			else if(valorColorJugador.equals("Mario Rosa")) {
				colorJugador= "Rosa";
			}
			
			/*tipo del jugador2*/
			if(valorTipoJugador2.equals("Mimo")) {
				tipoJugador2= "Mimo";
			}
			else if(valorTipoJugador2.equals("Protector")) {
				tipoJugador2= "Protector";
			}
			else if(valorTipoJugador2.equals("Temeroso")) {
				tipoJugador2= "Temeroso";
			}
			
			/*color de la Princesa*/
			if(valorColorPrincesa.equals("Princesa Azul")) {
				colorPrincesa= "princesaazul";
				}
				else if(valorColorPrincesa.equals("Princesa Cafe")) {
				colorPrincesa= "princesacafe";
				}
				else if(valorColorPrincesa.equals("Princesa Morada")) {
				colorPrincesa= "princesamorada";
				}
				else if(valorColorPrincesa.equals("Princesa Roja")) {
				colorPrincesa= "princesaroja";
				}
				else if(valorColorPrincesa.equals("Princesa Rosa")) {
				colorPrincesa= "princesarosa";
				}
				else if(valorColorPrincesa.equals("Princesa Verde")) {
				colorPrincesa= "princesaverde";
				}
			
			tabUpPanel.infoConfigVsMaquina(tipoJugador, colorJugador, tipoJugador2, colorPrincesa, barriles, sorpresas);
		}
	}
	
	@Override
	/**
	  * El evento a relizar cuando preciona la tecla
	  * @param e, el evento a atender
	  */
	 public void keyPressed(KeyEvent e) {
	  int key = e.getKeyCode();
	  
	 //Comandos Jugador1 
	  if (key == KeyEvent.VK_ENTER) {
		  System.out.println("Presion� Enter!");
	      //tabUpPanel.getTablero().JugadorMoveUp(0);
	  }
	  else if (key == KeyEvent.VK_UP) {
		  //System.out.println("Presion� Arriba!");
		  tabUpPanel.getTablero().JugadorMoveEscalar(0);
		  puntos.setText("SCORE: "+tabUpPanel.getPuntos());
		  vida.setText("LIFES:"+tabUpPanel.getVidas());
		  chequeoGano();
		  }
	  else if (key == KeyEvent.VK_DOWN) {
		  //System.out.println("Presion� Abajo!");
		  tabUpPanel.getTablero().JugadorMoveDown(0);
		  puntos.setText("SCORE: "+tabUpPanel.getPuntos());
		  vida.setText("LIFES:"+tabUpPanel.getVidas());
		  chequeoGano();
		  }
	  else if (key == KeyEvent.VK_RIGHT) {
		  //System.out.println("Presion� Derecha!");
		  tabUpPanel.getTablero().JugadorMoveRight(0);
		  puntos.setText("SCORE: "+tabUpPanel.getPuntos());
		  vida.setText("LIFES:"+tabUpPanel.getVidas());
		  chequeoGano();
		  }
	  else if (key == KeyEvent.VK_LEFT) {
		  //System.out.println("Presion� Izquierda!");
		  tabUpPanel.getTablero().JugadorMoveLeft(0);
		  puntos.setText("SCORE: "+tabUpPanel.getPuntos());
		  vida.setText("LIFES:"+tabUpPanel.getVidas());
		  chequeoGano();
		  }
	  
	  //Comandos Jugador2
	  else if(key == KeyEvent.VK_SPACE) {
		   System.out.println("Presion� Espacio!");
		  }
	  else if (key == KeyEvent.VK_A) {
		   System.out.println("Presion� Izquierda 2!");
		  }
	  else if  (key == KeyEvent.VK_S) {
		  System.out.println("Presion� Abajo 2!");
		  }
	  else if  (key == KeyEvent.VK_D) {
		   System.out.println("Presion� Derecha 2!");
		  }
	  else if (key == KeyEvent.VK_W) {
		   System.out.println("Presion� Arriba 2!");
		  }
	 }
	 
	 @Override
	 /**
	  * El evento a relizar cuando suelta la tecla
	  * @param e, el evento a atender
	  */
	 public void keyReleased(KeyEvent e) {
	 }
	 
	 @Override
	 /**
	  * El evento a relizar cuando escribe la tecla
	  * @param e, el evento a atender
	  */
	 public void keyTyped(KeyEvent e) {
	 }
	
	/**
	 * Coloca el fondo en el JComponent
	 * @param componente, el componente al cual le colocamos el fondo
	 * @param rutaImagen, la ruta del fondo (imagen) a colocar
	 */
	private void ponerFondo(JComponent componente, String rutaImagen) {
		try {
			DKoongFondo fondo= new DKoongFondo(ImageIO.read(new File(rutaImagen)));
			componente.setBorder(fondo);
		}catch(IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Prepara el juego(todo lo que esta por default, como debe estar)
	 */
	private void prepareJuego(){
		tabUpPanel.addPlayer();
		tabUpPanel.repaint();
	}
	
	public void chequeoGano() {
		if(tabUpPanel.getGano()) {
			JOptionPane.showMessageDialog(null,"  GANASTE!!! :)","Game Dialog",1);
		}
	}
	
	/**
	 * Inicializa la aplicacion del Juego
	 */
	public static void main(String[] args) throws IOException{
		DKoongGUI gui= new DKoongGUI();
		gui.setVisible(true);
	}

}