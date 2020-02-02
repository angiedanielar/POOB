package presentacion;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;  
import aplicacion.*;


public class ReplicateGUI extends JFrame{
	private JMenuBar barra;
	private JMenu menu;
	private JMenuItem nuevo, abrir, salvar, salvarComo, salir;
	private JFileChooser file;
	private JPanel panelOpciones, panelGrid, panelConfigFilas , panelConfigColumnas;
	private JButton colorBlock,gridColor,reinicie,replicar,iniciar,changeSize;
	private JLabel noReplicaciones;
	private JButton[][] matrizBotones;
	private JTextField dimensionX, dimensionY;
	private Color colorCasillaActiva, colorGridDefault;
	private int filas, columnas;
	private Replicate app;
	
		
	private ReplicateGUI(){
		filas= 10;
		columnas= 10 ;
		prepareElementos();  
		prepareAcciones();
	}
	
private void prepareElementos(){
	setTitle("Replicate");
	setSize((Toolkit.getDefaultToolkit().getScreenSize().width)/2 , (Toolkit.getDefaultToolkit().getScreenSize().height)/2);
	setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/4, (Toolkit.getDefaultToolkit().getScreenSize().height)/4 );
	setLayout(new BorderLayout());
	colorCasillaActiva= Color.RED;
	colorGridDefault= Color.BLUE;
	app= new Replicate(filas,columnas);
	prepareElementosMenu();
	elementosPanelOpciones();
	elementosGrid();
	add(panelGrid, BorderLayout.CENTER);
	add(panelOpciones, BorderLayout.WEST);
	panelOpciones.setVisible(true);
	file= new JFileChooser();	
}

private void elementosPanelOpciones() {
	panelOpciones= new JPanel();
	panelOpciones.setLayout(new GridLayout(10,1));
	
	colorBlock= new JButton("Color Casillas");
	gridColor= new JButton("Color Tablero");
	reinicie= new JButton("Reiniciar");
	replicar= new JButton("Replicar");
	iniciar= new JButton("Iniciar");
	changeSize= new JButton("Cambie el Grid");
	noReplicaciones= new JLabel(Integer.toString(app.getReplicaciones()));
	panelConfigFilas= new JPanel();
	panelConfigColumnas= new JPanel();
	panelConfigFilas.setLayout(new BorderLayout());
	panelConfigColumnas.setLayout(new BorderLayout());
	panelConfigFilas.add(new JLabel("Filas"), BorderLayout.NORTH);
	panelConfigColumnas.add(new JLabel("Columnas"), BorderLayout.NORTH);
	dimensionX= new JTextField();
	dimensionY= new JTextField();
	dimensionX.setBounds(new Rectangle(25, 15, 250, 21));
	dimensionY.setBounds(new Rectangle(25, 15, 250, 21));
	panelConfigFilas.add(dimensionX, BorderLayout.SOUTH);
	panelConfigColumnas.add(dimensionY, BorderLayout.SOUTH);
	panelOpciones.add(new JLabel("Replicate"));
	panelOpciones.add(colorBlock);
	panelOpciones.add(gridColor);
	panelOpciones.add(panelConfigFilas);
	panelOpciones.add(panelConfigColumnas);
	panelOpciones.add(changeSize);
	panelOpciones.add(reinicie);
	panelOpciones.add(iniciar);
	panelOpciones.add(replicar);
	panelOpciones.add(noReplicaciones);
	
	
}

private void elementosGrid() {
	panelGrid= new JPanel();
	panelGrid.setLayout(new GridLayout(filas,columnas,3,3));
	matrizBotones= new JButton[filas][columnas];
	
	for (int i= 0; i< filas; i++) {
		for(int j= 0; j< columnas; j++) {
			JButton boton= new JButton();
			boton.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(boton.getBackground().equals(colorGridDefault)){
								boton.setBackground(colorCasillaActiva);
							}
							else {
								boton.setBackground(colorGridDefault);
							}
						}
					});
			
			
			boton.setBackground(colorGridDefault);
			
			matrizBotones[i][j]= boton;
			panelGrid.add(boton);
		}
	}
}

private void prepareElementosMenu() {
	barra= new JMenuBar();
	menu= new JMenu("Menu");
	nuevo= new JMenuItem("Nuevo");
	abrir= new JMenuItem("Abrir");
	salvar= new JMenuItem("Salvar");
	salvarComo= new JMenuItem("Salvar Como");
	salir= new JMenuItem("Salir");	
	menu.add(nuevo);
	menu.add(abrir);
	menu.add(salvar);
	menu.add(salvarComo);
	menu.add(salir);
	barra.add(menu);
	setJMenuBar(barra);
}

private void prepareAcciones(){
	//default de cerrar
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	
	// botones del JFrame
	addWindowListener(new WindowAdapter() { 
		public void windowClosing(WindowEvent ev){ 
		accionSalir();} 
		}); 
	//opciones del menu
	
	//opcion Salir
	salir.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accionSalir();
				}
			});
	//opcion de Abrir
	abrir.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accionAbrir();
				}
			});
	//opciones de Guardado
	salvar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accionGuardar();
				}
			}
	);
	salvarComo.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accionGuardar();
				}
			});
	//opciones del panel Cambio de color
	colorBlock.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					accionCambioColorCasilla();
		            }
				});
	gridColor.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					accionCambioColorGrid();
					}
				});
	// opcion para cmabiar el Grid
	changeSize.addActionListener(
			new  ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accionChangeGrid();
				}
			});
	// opcion para reiniciar
	reinicie.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accionReinicio();
				} 
			});
	// opcion para iniciar
	iniciar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					configuracionInicial();
				}
			});
	// opcion para replicar
	replicar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accionReplicar();
				}
			});
}

private void accionReinicio() {
	for (int i= 0; i< filas; i++) {
		for(int j= 0; j< columnas; j++) {
			matrizBotones[i][j].setBackground(colorGridDefault);
			matrizBotones[i][j].setEnabled(true);
			app.lleneMatrices();			
		}
		iniciar.setEnabled(true);
		changeSize.setEnabled(true);
		app.resetReplicaciones();
		noReplicaciones.setText(Integer.toString(app.getReplicaciones()));
	}
}

private void accionSalir(){
	int confirmacion= JOptionPane.showConfirmDialog(null,"Esta seguro de querer salir?","Confirmacion",JOptionPane.YES_NO_OPTION);
	if (JOptionPane.YES_OPTION == confirmacion){  
		System.exit(0);
	}
} 

private void accionAbrir() {
	int confirmacion= file.showOpenDialog(null);
	if (file.APPROVE_OPTION == confirmacion) {
		mensajeTrabajandoEnEso();
	}
}

private void accionGuardar() {
	int confirmacion= file.showSaveDialog(null);
	if (file.APPROVE_OPTION == confirmacion) {
		mensajeTrabajandoEnEso();
	}
}

private void accionCambioColorCasilla() {
	JColorChooser Selectorcolor=new JColorChooser();
    Color temporal= Selectorcolor.showDialog(null, "Seleccione un color", Color.RED);
    for (int i= 0; i< filas; i++) {
		for(int j= 0; j< columnas; j++) {
			if(matrizBotones[i][j].getBackground().equals(colorCasillaActiva)) {
				matrizBotones[i][j].setBackground(temporal);
			}
		}
	}
    
    colorCasillaActiva= temporal;
    
}

private void accionCambioColorGrid() {
	JColorChooser Selectorcolor=new JColorChooser();
    Color temporal= Selectorcolor.showDialog(null, "Seleccione un color", Color.BLUE);
    for (int i= 0; i< filas; i++) {
		for(int j= 0; j< columnas; j++) {
			if(matrizBotones[i][j].getBackground().equals(colorGridDefault)) {
				matrizBotones[i][j].setBackground(temporal);
			}
		}
	}
    
    colorGridDefault= temporal;
    
	
}

private void configuracionInicial() {
	for(int i= 0; i< filas; i++) {
		for(int j= 0; j< columnas; j++) {
			if(matrizBotones[i][j].getBackground().equals(colorCasillaActiva)) {
				app.cambieEstadoCasilla(i, j);
			}
			matrizBotones[i][j].setEnabled(false);
		}
	}
}

private void accionReplicar() {
	app.replicar();
	for (int i= 0; i< filas; i++) {
		for(int j= 0; j< columnas; j++) {
			if (app.consulteEstadoCasilla(i, j) == 1) {
				matrizBotones[i][j].setBackground(colorCasillaActiva);
				}
			else {
				matrizBotones[i][j].setBackground(colorGridDefault);
			}
		}
	}
	iniciar.setEnabled(false);
	changeSize.setEnabled(false);
	noReplicaciones.setText(Integer.toString(app.getReplicaciones()));
}

private void accionChangeGrid() {
	try{
		this.filas= Integer.parseInt(dimensionX.getText());
		this.columnas= Integer.parseInt(dimensionY.getText());
		app.changeSize(filas, columnas);
	
		panelGrid.setVisible(false);
		remove(panelGrid);
		elementosGrid();
		add(panelGrid, BorderLayout.CENTER);
		}
	catch(ReplicateException e){
		JOptionPane.showMessageDialog(null,"Error al construir tablero, por favor vuelva a intentar","Error",JOptionPane.ERROR_MESSAGE);
		}
}

private void mensajeTrabajandoEnEso() {
	JOptionPane.showMessageDialog(this, "Estamos trabajando en esto");
}

public static void main(String[] args){
	ReplicateGUI gui = new ReplicateGUI();
	gui.setVisible(true);
	}
}
