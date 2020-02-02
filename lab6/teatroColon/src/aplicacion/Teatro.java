package aplicacion;

import java.util.*;
import java.io.*;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ECI 2014
 * 
 */

/**
 * Clase Teatro dada por la ECI
 * @author ECI
 */
public class Teatro implements Serializable {
    public static final int MAXIMO = 500;
    private static Teatro teatro = null;
    private ArrayList<EnEscena> elementos;
    
    /**
     * Crea el teatro por default desde consola nulo
     */
    public static Teatro demeTeatro() {
        if (teatro==null){
            teatro=new Teatro();
        }
        return teatro;
    }
    
    /**
     * Crea un nuevo teatro
     */
    private static void nuevoTeatro() {
        teatro=new Teatro();
    }   
    
    /**
     * Cambia el teatro actual por otro
     * @param d, el nuevo teatro a  cambiar
     */
    public static void cambieTeatro(Teatro d) {
        teatro=d;
    }       
    
    /**
     * Crea el teatro con todos sus elementos en el
     */
    private Teatro() {
        elementos= new ArrayList<EnEscena>();
    }
    
    /**
     * Añade los elementos al actual teatro
     */
    public void algunosEnEscena() {  
        Actor actor1 = new Actor(this,"Romeo",20,150);
        Actor actor2 = new Actor(this,"Julieta",90,150);
        
        ActorNecio actor3 = new ActorNecio(this,"Homero",20,70);
        ActorNecio actor4 = new ActorNecio(this,"Bard",90,70);
        
        ActorPerezoso actor5 = new ActorPerezoso(this,"Edward",20,0);
        ActorPerezoso actor6 = new ActorPerezoso(this,"Bella",90,0);
        
        ActorEjemplar actor7 = new ActorEjemplar(this,"Ernesto",20,220);
        ActorEjemplar actor8 = new ActorEjemplar(this,"Daniela",90,220);
        
        Luz luz1= new Luz(this,"centralDerecha",240,250);
        Luz luz2= new Luz(this,"centralIzquierda",260,250);
        
        Escenografia mesa1 = new Escenografia(this,"Mobil",240,300,true);
        Escenografia mesa2 = new Escenografia(this,"inMobil",260,300,false);
        
        elementos.add(actor1);
        elementos.add(actor2);
        elementos.add(actor3);
        elementos.add(actor4);
        elementos.add(actor5);
        elementos.add(actor6);
        elementos.add(actor7);
        elementos.add(actor8);
        elementos.add(luz1);
        elementos.add(luz2);
        elementos.add(mesa1);
        elementos.add(mesa2);
    }   
    
    /**
     * @param n, el elemento a mirar si esta o  no en escena
     * @return h, retorna si el elemento esta en o no en escena
     */
    public EnEscena demeEnEscena(int n) {
        EnEscena h=null;
        if (1<=n && n<=elementos.size()){
            h=elementos.get(n-1);
        }    
        return h; 
    }
    
    /**
     * Adiciona los elementos del teatro a la escena
     * @param e, el elemento a adicionar
     */
    public void adicione(EnEscena e) {
        elementos.add(e);
    }
    
    /**
     * @return retorna el numero de elementos del teatro en escena
     */
    public int numeroEnEscena() {
        return elementos.size();
    }
    
    /**
     * Pone en accion a los elementos del teatro
     */
    public void accion() {
        for(EnEscena e: elementos){
            e.actue();
        }
    }
    
    /**
     * Para la accion de los elementos del teatro
     */
    public void corten() {
        for(EnEscena e: elementos){
            e.corte();
        }
    }    

    /**
     * Pone en decidir a los elementos del teatro
     */
    public void decidan() {
        for(EnEscena e: elementos){
            e.decida();
        }
    }

    /**
     * Pone a reiniciar a los elementos del teatro
     */
    public void reinicien() {
        for(EnEscena e: elementos){
            e.reinicien();
        }
    }
    
    /**
     * Borra los elementos del actual teatro
     */
    public void salir() {
    	elementos.clear();
    }

    /**
     * @return elementos, Retorna los elementos del teatro actual
     */
    public ArrayList<EnEscena> getElementos(){
	return elementos;
	}
    
    /**
     * Guarda el teatro actual
     *@throws, TeatroColonException
     */
    public void salvar(File file) throws TeatroColonException {
	try {
    		ObjectOutputStream salida= new ObjectOutputStream(new FileOutputStream(file));
    		salida.writeObject(this);
    		salida.close();
    	}catch(Exception e) {
    		throw new TeatroColonException("Ocurrio un error al salvar " + file.getName());    		
    	}
    }

    /**
     * Guarda el teatro actual
     *@throws, TeatroColonException
     */
    public void salvar01(File file) throws TeatroColonException {
    	if (!file.getName().endsWith(".dat")) { 
    		throw new TeatroColonException(TeatroColonException.TYPE_DAT_ERROR);
    	}
    	
    	try {
    		ObjectOutputStream salida= new ObjectOutputStream(new FileOutputStream(file));
    		salida.writeObject(this);
    		salida.close();
    	}catch(IOException e) {
    		throw new TeatroColonException("Ocurrio un error al salvar " + file.getName());    		
    	}
    }


    /**
     * Abre un teatro
     *@throws, TeatroColonException
     */
    public void abrir(File file) throws TeatroColonException {
    	Teatro temp= null;
    	try {
    		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			temp = (Teatro) in.readObject();
			in.close();
			cambieTeatro(temp);
    	}catch (Exception e) {
			throw new TeatroColonException("Ocurrio un error al abrir el archivo" + file.getName());
		}
    }

    /**
     * Abre un teatro
     *@throws, TeatroColonException
     */
    public void abrir01(File file) throws TeatroColonException {
    	Teatro temp= null;
    	if(!file.getName().endsWith(".dat")) {
    		throw new TeatroColonException(TeatroColonException.TYPE_DAT_ERROR);
    	}
    	try {
    		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			temp = (Teatro) in.readObject();
			in.close();    		
			cambieTeatro(temp);
    	}catch(ClassNotFoundException e) {
    		throw new TeatroColonException(TeatroColonException.FILE_NOT_FOUND_ERROR);
    	}catch (IOException e) {
			throw new TeatroColonException("Ocurrio un error al abrir el archivo" + file.getName());
		}
    }
    
    /**
     * Importa un teatro
     *@throws, TeatroColonException
     */
    public Teatro importar(File file) throws TeatroColonException {
	Teatro teatroTemp = null;
	try {
		Teatro.nuevoTeatro();
		teatroTemp = teatroTemp.demeTeatro();
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = in.readLine();
		while (line!=null){
			line = line.trim();
			if(line.equals("")){continue;}
			String[] linea = line.split(" ");
			if(linea[0].equals("Actor")){new Actor(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3]));}
			else if(linea[0].equals("ActorNecio")){new ActorNecio(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3]));}
			else if(linea[0].equals("ActorPerezoso")){new ActorPerezoso(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3]));}
			else if(linea[0].equals("ActorEjemplar")){new ActorEjemplar(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3]));}
			else if(linea[0].equals("Escenografia")){new Escenografia(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3]),Boolean.valueOf(linea[4]));}
			else if(linea[0].equals("Luz")){new Luz(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3]));}
			
			line = in.readLine();
		}
		in.close();
	}
	catch (Exception e) {
		//System.out.println(e.getMessage());
		throw new TeatroColonException("Ocurrio un error al importar " + file.getName());
		}
	return teatroTemp;
    }

    /**
     * Importa un teatro
     *@throws, TeatroColonException
     */
    public Teatro importar01(File file) throws TeatroColonException {
	Teatro teatroTemp = null;
	if (!file.getName().endsWith(".txt")) throw new TeatroColonException(TeatroColonException.TYPE_TXT_ERROR);	
	try {
		Teatro.nuevoTeatro();
		teatroTemp = teatroTemp.demeTeatro();
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = in.readLine();
		while (line!=null){
			line = line.trim();
			if(line.equals("")){continue;}
			String[] linea = line.split(" ");
			if(linea[0].equals("Actor")){teatroTemp.adicione(new Actor(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3])));}
			else if(linea[0].equals("ActorNecio")){teatroTemp.adicione(new ActorNecio(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3])));}
			else if(linea[0].equals("ActorPerezoso")){teatroTemp.adicione(new ActorPerezoso(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3])));}
			else if(linea[0].equals("ActorEjemplar")){teatroTemp.adicione(new ActorEjemplar(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3])));}
			else if(linea[0].equals("Escenografia")){teatroTemp.adicione(new Escenografia(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3]),Boolean.valueOf(linea[4])));}
			else if(linea[0].equals("Luz")){teatroTemp.adicione(new Luz(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3])));}
			
			line = in.readLine();
		}
		in.close();
	}
	catch (IOException e) {
		//System.out.println(e.getMessage());
		throw new TeatroColonException("Ocurrio un error al importar "+ file.getName());
		}
	return teatroTemp;
    }

    /**
     * Importa un teatro
     *@throws, TeatroColonException
     */
    public Teatro importar02(File file) throws TeatroColonException{
		int i = 1;
		Teatro teatroTemp = null;
		if (!file.getName().endsWith(".txt")) throw new TeatroColonException(TeatroColonException.TYPE_TXT_ERROR);
		try {
			Teatro.nuevoTeatro();
			teatroTemp = Teatro.demeTeatro();
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			if(line==null) {
				throw new TeatroColonException(TeatroColonException.NO_TEXT_FOUND);
			}
			while (line!=null){
				line = line.trim();
				if(line.equals("")){continue;}
				String[] linea = line.split(" ");
				if(linea[0].equals("Actor")){
					checkDataLength(4,linea);
					try {
						teatroTemp.adicione(new Actor(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3])));
					} catch(NumberFormatException e) {
						throw new TeatroColonException("Error : linea "+i+" No es posible convertir a entero");
					}
				}
				else if(linea[0].equals("ActorNecio")){
					checkDataLength(4,linea);
					try {
						teatroTemp.adicione(new ActorNecio(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3])));
					} catch(NumberFormatException e) {
						throw new TeatroColonException("Error : linea "+i+" No es posible convertir a entero");
					}
				}
				else if(linea[0].equals("ActorPerezoso")){
					checkDataLength(4,linea);
					try {
						teatroTemp.adicione(new ActorPerezoso(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3])));
					} catch(NumberFormatException e) {
						throw new TeatroColonException("Error : linea "+i+" No es posible convertir a entero");
					}
				}
				else if(linea[0].equals("ActorEjemplar")){
					checkDataLength(4,linea);
					try {
						teatroTemp.adicione(new ActorEjemplar(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3])));
					} catch(NumberFormatException e) {
						throw new TeatroColonException("Error : linea "+i+" No es posible convertir a entero");
					} 
				}
				else if(linea[0].equals("Escenografia")){
					checkDataLength(5,linea);
					try {
						checkBooleanData(linea);
						teatroTemp.adicione(new Escenografia(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3]),Boolean.valueOf(linea[4])));
					} catch(NumberFormatException e) {
						throw new TeatroColonException("Error : linea "+i+" No es posible convertir a entero");
					} catch(TeatroColonException e) {
						throw new TeatroColonException("Error : linea "+i+" No es correcto el valor de si es movil");
					}
				}
				else if(linea[0].equals("Luz")){
					checkDataLength(4,linea);
					try {
						teatroTemp.adicione(new Luz(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3])));
					} catch(NumberFormatException e) {
						throw new TeatroColonException("Error : linea "+i+" No es posible convertir a entero");
					} 
				}
				else {
					throw new TeatroColonException("Error : linea "+i+" La linea "+linea[0]+" no es una clase definida");
				}
				line = in.readLine();
				i+=1;
			}
			in.close();
		}catch (IOException e) {
			System.out.println(e.getMessage());
			throw new TeatroColonException("Ocurrio un error al importar " + file.getName());
		}
		return teatroTemp;
	}
    
    /**
     * Importa un teatro
     *@throws, TeatroColonException
     */
    public Teatro importar03(File file) throws TeatroColonException{
		int i = 1;
		Teatro teatroTemp = null;
		if (!file.getName().endsWith(".txt")) throw new TeatroColonException(TeatroColonException.TYPE_TXT_ERROR);
		try {
			Teatro.nuevoTeatro();
			teatroTemp = Teatro.demeTeatro();
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			if(line==null) {
				throw new TeatroColonException(TeatroColonException.NO_TEXT_FOUND);
			}
			while (line!=null){
				line = line.trim();
				if(line.equals("")){continue;}
				String[] linea = line.split(" ");
				if(linea[0].equals("Actor") || linea[0].equals("ActorNecio") || linea[0].equals("ActorPerezoso") || linea[0].equals("ActorEjemplar") || linea[0].equals("Luz")){
					checkDataLength(4,linea);
					try {
						Class c = Class.forName("aplicacion."+linea[0]);
						Object o = c.getDeclaredConstructor(Teatro.class , String.class , int.class , int.class).newInstance(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3]));
						EnEscena obj= (EnEscena)o;
						teatroTemp.adicione(obj);
					} catch(NumberFormatException e) {
						throw new TeatroColonException("Error : linea "+i+" No es posible convertir a entero");
					}catch(ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {	
						throw new TeatroColonException("Error: linea "+i+" dato "+linea[0]+" no es un elemento");
					}
				}
				else if(linea[0].equals("Escenografia")){
					checkDataLength(5,linea);
					try {
						checkBooleanData(linea);
						Class c = Class.forName("aplicacion."+linea[0]);
						Object o = c.getDeclaredConstructor(Teatro.class ,String.class, int.class, int.class, boolean.class).newInstance(teatroTemp,linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3]),Boolean.valueOf(linea[4]));
						EnEscena obj= (EnEscena)o;
						teatroTemp.adicione(obj);
					} catch(NumberFormatException e) {
						throw new TeatroColonException("Error : linea "+i+" No es posible convertir a entero");
					} catch(ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
						throw new TeatroColonException("Error: linea "+i+" dato "+linea[0]+" no es un elemento");
					} catch(TeatroColonException e) {
						throw new TeatroColonException("Error : linea "+i+" No es correcto el valor de si es movil");
					}
				}
				else {
					throw new TeatroColonException("Error: linea "+i+" dato "+linea[0]+" no es un elemento");
				}
				line = in.readLine();
				i+=1;
			}
			in.close();
		}catch (IOException e) {
			System.out.println(e.getMessage());
			throw new TeatroColonException("Ocurrio un error al importar " + file.getName());
		}
		return teatroTemp;
    }

    /**
     * Exporta el teatro actual
     *@throws, TeatroColonException
     */
    public void exportar(File file) throws TeatroColonException {
    	PrintWriter out = null;
    	try {
			out = new PrintWriter(new FileOutputStream(file));
			int size = elementos.size();
			for(int i=0;i<size;i++){
				String temp = getElementos().get(i).toString();
				out.println(getElementos().get(i).getClass().getSimpleName()+" "+temp);
			}
			out.close();
		} 
	catch (Exception e) {
			throw new TeatroColonException("Ocurrio un error al exportar " + file.getName());
		}		
    }

    /**
     * Exporta el teatro actual
     *@throws, TeatroColonException
     */
    public void exportar01(File file) throws TeatroColonException {
    	PrintWriter out = null;
    	if (!file.getName().endsWith(".txt")) { 
    		throw new TeatroColonException(TeatroColonException.TYPE_TXT_ERROR);
    	}
		try {
			out = new PrintWriter(new FileOutputStream(file));
			int size = elementos.size();
			for(int i=0;i<size;i++){
				String temp = getElementos().get(i).toString();
				out.println(getElementos().get(i).getClass().getSimpleName()+" "+temp);
			}
			out.close();
		} catch(FileNotFoundException e) {
			throw new TeatroColonException("No se encuentra el archivo " + file.getName());
		}		
    }
    
    /**
     * Exporta el teatro actual
     *@throws, TeatroColonException
     */
    public void exportar02(File file) throws TeatroColonException {
    	PrintWriter out = null;
    	if (!file.getName().endsWith(".txt")) { 
    		throw new TeatroColonException(TeatroColonException.TYPE_TXT_ERROR);
    	}
		try {
			out = new PrintWriter(new FileOutputStream(file));
			int size = elementos.size();
			for(int i=0;i<size;i++){
				String temp = getElementos().get(i).toString();
				out.println(getElementos().get(i).getClass().getSimpleName()+" "+temp);
			}
			out.close();
		} catch(FileNotFoundException e) {
			throw new TeatroColonException("No se encuentra el archivo " + file.getName());
		}		
    }
    
    /**
     * Exporta el teatro actual
     *@throws, TeatroColonException
     */
    public void exportar03(File file) throws TeatroColonException {
    	PrintWriter out = null;
    	if (!file.getName().endsWith(".txt")) { 
    		throw new TeatroColonException(TeatroColonException.TYPE_TXT_ERROR);
    	}
		try {
			out = new PrintWriter(new FileOutputStream(file));
			int size = elementos.size();
			for(int i=0;i<size;i++){
				String temp = getElementos().get(i).toString();
				out.println(getElementos().get(i).getClass().getSimpleName()+" "+temp);
			}
			out.close();
		} catch(FileNotFoundException e) {
			throw new TeatroColonException("No se encuentra el archivo " + file.getName());
		}		
    }
    
    private void checkDataLength(int size , String[] line) throws TeatroColonException{
		if(line.length!=size) {
			throw new TeatroColonException(TeatroColonException.SIZE_ERROR);
		}
	}
    
    private void checkBooleanData(String[] line) throws TeatroColonException{
    	if((!line[4].equals("true")) && (!line[4].equals("false"))) {
    		throw new TeatroColonException(TeatroColonException.BOOLEAN_FORMAT);
    	}
	}
}
