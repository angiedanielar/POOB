package aplicacion;

public class Replicate {
	private int[][] matrizTrabajo;
	private int[][] matrizVista;
	private int filas,columnas;
	private int replicaciones;
	
	public Replicate(int filas, int columnas) {
		matrizTrabajo= new int[filas][columnas];
		matrizVista= new int[filas][columnas];
		this.filas =filas;
		this.columnas= columnas;
		replicaciones= 0;
		lleneMatrices();
	}
	
	public void lleneMatrices() {
		for(int i= 0; i< filas; i++) {
			for(int j= 0;j< columnas; j++) {
				matrizTrabajo[i][j]=0;
				matrizVista[i][j]=0;
			}
		}
	}
	
	public void changeSize(int newFilas, int newColumnas) throws ReplicateException {
		if (newColumnas > 0){
			if (newFilas > 0) {
				this.filas= newFilas;
				this.columnas= newColumnas;
				matrizTrabajo= new int[filas][columnas];
				matrizVista= new int[filas][columnas];
				lleneMatrices();
				}
			}
		else{
			throw new ReplicateException(ReplicateException.WRONG_DIMENSIONS);
			}		
	}
	
	public void resetReplicaciones() {
		replicaciones= 0;
	}
	
	public void cambieEstadoCasilla(int posiX, int posiY) {
			matrizTrabajo[posiX][posiY]= 1;
			matrizVista[posiX][posiY]= 1;
			}

	
	
	public int[][] consulteEstado() {
		return matrizVista;
		}
	
	public int consulteEstadoCasilla(int i, int j) {
		return matrizVista[i][j];
	}
	
	public boolean consultaVida(int i, int j) {
		boolean valor= false;
		int[] paraI= {-1,-1,-1,0,0,0,1,1,1};
		int[] paraJ= {-1,0,1,-1,0,1,-1,0,1};
		int suma= 0;
		
		for (int v= 0; v< 9; v++) {
			if( (!((i + paraI[v])< 0)) && (!((i + paraI[v])>= filas))) {
				if( (!((j + paraJ[v])< 0)) && (!((j + paraJ[v])>= columnas))) {
					suma+= matrizTrabajo[i + paraI[v]][j + paraJ[v]];
				}
			}
		}
		if(suma%2 != 0) {
			valor= true;
		}
		
		return valor;
	}
	
	public void replicar() {
		replicaciones+= 1;
		
		for(int i= 0; i< filas; i++) {
			for(int j=0; j< columnas; j++) {
				if(consultaVida(i,j)) {
					matrizVista[i][j]= 1;
				}
				else {
					matrizVista[i][j]= 0;
				}
			}
		}
		
		for(int i= 0; i< filas; i++) {
			for(int j=0; j< columnas; j++) {
				matrizTrabajo[i][j]= matrizVista[i][j];
			}
		}		
	}
	
	public int getReplicaciones() {
		return replicaciones;
	}
}
