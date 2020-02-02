package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import aplicacion.*;

/**
 * @author ECI 2014
 * 
 */

/**
 * Clase TeatroColonGUI dada por la ECI
 * @author ECI
 */
public class TeatroColonGUI extends JFrame {
    private Teatro teatro=null;
    private JPanel botones;
    private JScrollPane contenedor;
    private JButton botonAccion;
    private JButton botonCorten;
    private JButton botonDecision;  
    private FotoTeatro foto;
    private JMenuBar barra;
    private JButton botonReinicien;
    private JMenuItem salvar, abrir, exportar, importar;
    
    /**
     * Crea al TeatroColonGUI
     */
    private TeatroColonGUI() {
        super("Teatro Colon");
        try {
            teatro=Teatro.demeTeatro();     
            teatro.algunosEnEscena();
            elementos();
            acciones();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Crea al TeatroColonGUI
     * @trows, Exception 
     */
    private void elementos() throws Exception {
        setLayout(new BorderLayout());    
        contenedor = new JScrollPane();
        
        foto= new FotoTeatro();
        contenedor.getViewport().add(foto);
        
        botones=new JPanel(new GridLayout(1,4));
        botonAccion=new JButton("Actuen");
        botonCorten=new JButton("Corten");
        botonDecision=new JButton("Decidan"); 
	botonReinicien=new JButton("Reiniciar"); 

        botones.add(botonAccion);
        botones.add(botonCorten);
        botones.add(botonDecision); 
	botones.add(botonReinicien);
        
        add(contenedor,BorderLayout.CENTER);
        add(botones,BorderLayout.SOUTH);
        
        pack();
        setSize(Teatro.MAXIMO+100,Teatro.MAXIMO+135);

        setResizable(false);
    }
    
    /**
     * Crea los botones de acciones para el teatro TeatroColonGUI
     */
    private void acciones() {
        ActionListener oyenteBotonAccion=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                accion();
            }   
        };  
        botonAccion.addActionListener(oyenteBotonAccion);
        
        ActionListener oyenteBotonCorten=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                corten();
            }   
        };  
        botonCorten.addActionListener(oyenteBotonCorten);
        
        ActionListener oyenteBotonDecision=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                decidan();
            }   
        }; 

	botonDecision.addActionListener(oyenteBotonDecision);
	
	ActionListener oyenteBotonReinicien =new ActionListener(){
            public void actionPerformed(ActionEvent e){
                reinicien();
            }   
        }; 
        
	botonReinicien.addActionListener(oyenteBotonReinicien);    
        
        WindowListener w = new WindowAdapter() { 
            public void windowClosing(WindowEvent e) {
                salir();
            }
        };  
        
        this.addWindowListener(w);
        
    }
    
    /**
     * Pone en accion a los elementos del TeatroColonGUI
     */
    private void accion() {
         teatro.accion();
         actualice();
    }
    
    /**
     * Para la accion de los elementos del TeatroColonGUI
     */
    private void corten() {       
        teatro.corten();
        actualice();
    }       
    
    /**
     * Pone en accion a los elementos del TeatroColonGUI
     */
    private void decidan() {       
        teatro.decidan();
        actualice();
    }   

    /**
      * Reinicia los elementos del TeatroColonGUI
      */
     private void reinicien() {       
         teatro.reinicien();
         actualice();
     }
    
    /**
     * Actualiza las acciones de los elemntos del TeatroColonGUI
     */
    private void actualice() {
        foto.actualice();
    }

    /**
     * Acaba la ejecucion del programa
     */
    private void salir() {
        dispose();
        System.exit(0);
    }   
    
    /**
     * Pone en accion a todo el TeatroColonGUI
     */
    public static void main(String[] args) {
        TeatroColonGUI gui=new TeatroColonGUI();
        gui.setVisible(true);
    }   
    
 /**
  * Clase FotoTeatro dada por la ECI
  * @author ECI
  */
 class FotoTeatro extends JComponent {
        private int x,y;
        private static final int MAX=Teatro.MAXIMO;

        /**
         * Actualiza graficamente al TeatroColonGUI 
         */
        public void actualice() {
            teatro=Teatro.demeTeatro();
            repaint();
        }
        
        /**
         * Pinta a TeatroColonGUI 
         */
        public void paintComponent(Graphics g) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 8)); 
            
            for (int i=1; i<=teatro.numeroEnEscena(); i++) {
                EnEscena e=teatro.demeEnEscena(i);
                int x=e.getPosicionX();
                int y=MAX-e.getPosicionY();  
                
                g.setColor(e.getColor()); 
                g.drawString(e.mensaje(),x+20,y+10);   
                
                if (e.forma().equals("Persona")){
                    humano(g,(Persona)e,x,y);
                } else  if (e.forma().equals("Circulo")){
                    g.fillOval(x+10,y+0,20,20);
                } else  if (e.forma().equals("Cuadrado")){
                    g.fillRect(x,y,20,20);
                }
            }
            super.paintComponent(g);
        }
        
        /**
         * Crea el humano
         * @param g, Graficos
         * @param e, la persona
         * @param x, las coordenadas en equis del humano
         * @param y, las coordenadas en ye del humano
         */
        public void humano(Graphics g, Persona e,int x, int y) {
            int pos;
            g.setColor(Color.PINK);
            g.fillOval(x+10,y+0,10,10);/*cabeza*/
            g.setColor(e.getColor()); 
            g.drawLine(x+10+5,y+10,x+10+5,y+10+20);
            
            pos=e.getPosicionBrazo('I');
            if (pos==Persona.ARRIBA){
                g.drawLine(x+10+5,y+10+5,x+10+15,y+10);/*brazo izq arriba*/
            } else if (pos==Persona.FRENTE){
                g.drawLine(x+10+5,y+10+5,x+10+15,y+10+5);/*brazo izq al frente*/
            } else {
                g.drawLine(x+10+5,y+10+5,x+10+15,y+10+10);/*brazo izq abajo*/
            }
            
            pos=e.getPosicionBrazo('D');
            if (pos==Persona.ARRIBA){
                g.drawLine(x+10+5,y+10+5,x+5,y+10);/*brazo der arriba*/
            } else if  (pos==Persona.FRENTE){
                g.drawLine(x+10+5,y+10+5,x+5,y+10+5);/*brazo der al frente*/
            } else{
                g.drawLine(x+10+5,y+10+5,x+5,y+10+10);/*brazo der abajo*/
            }
            
            g.drawLine(x+10+5,(y+15)+10+5,x+10+15,(y+15)+10+15);
            g.drawLine(x+10+5,(y+15)+10+5,x+5,(y+15)+10+15);
            
            pos=e.getPosicionPierna('D');
            if (pos==Persona.ARRIBA){
                g.drawLine(x+5,(y+15)+10+15,x+5+10,(y+15)+10+15);/*pierna der arriba*/
            } else if  (pos==Persona.FRENTE){
                g.drawLine(x+5,(y+15)+10+15,x+5-10,(y+15)+10+15+5);/*pierna der al frente*/
            } else{
                g.drawLine(x+5,(y+15)+10+15,x+5,(y+15)+10+15+10);/*pierna der abajo*/
            }
            
            pos=e.getPosicionPierna('I');
            if (pos==Persona.ARRIBA){
                g.drawLine(x+10+15,(y+15)+10+15,x+10+15-10,(y+15)+10+15);/*pierna izq arriba*/
            } else if  (pos==Persona.FRENTE){
                g.drawLine(x+10+15,(y+15)+10+15,x+10+15+10,(y+15)+10+15+5);/*pierna izq al frente*/
            }else {
                g.drawLine(x+10+15,(y+15)+10+15,x+10+15,(y+15)+10+15+10);/*piernaizqabajo*/
            }
        }
    }
}
