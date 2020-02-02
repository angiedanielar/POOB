import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author   ECI
 * @version 2019-2
 */
public class MatrizTest
{   
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        
    }
 
    @Test    
    public void deberiaPasar(){
    }
    
    @Test
    public void deberiaFallar(){
    }

    @Test
    public void deberiaCrearMatricesDadosLosElementos(){
        int [][] dA={{1,2,3},{4,5,6},{7,8,9}};
        int [][] dB={{1,2,3},{4,5,6},{7,8,9}};        
        Matriz A=new Matriz(dA);
        Matriz B=new Matriz(dB);
        assertEquals(A,B);
    }
        
    @Test
    public void deberiaProtegerLosDatos(){
        int [][] dA={{1,2,3},{4,5,6},{7,8,9}};
        int [][] dB={{1,2,3},{4,5,6},{7,8,9}};        
        Matriz A=new Matriz(dA);
        Matriz B=new Matriz(dB);
        dA[0][0]=-1;
        assertEquals(A,B);
    }

    @Test
    public void deberiaCrearMatricesDadoValor(){
        int [][] dA={{0,0,0},{0,0,0},{0,0,0}};
        Matriz A=new Matriz(dA);
        Matriz B=new Matriz(0,3,3);
        assertEquals(A,B);
    }
    
    @Test
    public void deberiaTransponerLaMatriz(){
        int [][] dA={{1,2,3},{4,5,6},{7,8,9}};
        int [][] dB={{1,4,7},{2,5,8},{3,6,9}};        
        Matriz A=new Matriz(dA);
        Matriz B=new Matriz(dB);
        A.transpuesta();
        assertEquals(A,B);
    }
    
    @Test
    public void deberiaSacarLaOpuestaDeLaMatriz(){
        int [][] dA={{1,-2,-3},{-4,5,-6},{7,8,9}};
        int [][] dB={{-1,2,3},{4,-5,6},{-7,-8,-9}};       
        Matriz A=new Matriz(dA);
        Matriz B=new Matriz(dB);
        A.opuesta();
        assertEquals(A,B);
    }
    
    @Test
    public void deberiaCrearMatricesDiagonales(){
        int [] d={1,2,3,4};
        int [][] dD={{1,0,0,0},{0,2,0,0},{0,0,3,0},{0,0,0,4}};
        Matriz A=new Matriz(d);
        Matriz B=new Matriz(dD);
        assertEquals(A,B);
    }    
    
    public void deberiaCrearMatricesIdentidad(){
        int [][] dI={{1,0,0},{0,1,0},{0,0,1}};     
        Matriz A=new Matriz(3);
        Matriz I=new Matriz(dI);
        assertEquals(A,I);
    }
    
    @Test
    public void noDeberiaCrearMatricesInValidas(){
        
        int [][] dA={{1,2,3},{4,5},{7,8,9}};
        int [][] dB={{1,2,3},{4,5,6},{7,8,9,7}};
        assertEquals(new Matriz(dA),Matriz.UNCERO);
        assertEquals(new Matriz(dB),Matriz.UNCERO);
        
        int [] d={};
        assertEquals(new Matriz(d),Matriz.UNCERO);


        assertEquals(new Matriz(10,-1,2),Matriz.UNCERO);
        assertEquals(new Matriz(10,1,-2),Matriz.UNCERO);  
        
        assertEquals(new Matriz(0),Matriz.UNCERO);
        assertEquals(new Matriz(-1),Matriz.UNCERO);       
    }   
    
    @Test
    public void noDeberiaSumarMatricesInValidas(){
        int [][] dA={{1,2,3},{4,4,9},{7,8,9}};
        int [][] dB={{1,2,3},{7,8,9}};
  
        Matriz A = new Matriz(dA);
        Matriz B = new Matriz(dB);
        Matriz matrizNueva = A.sume(B);
        assertEquals(matrizNueva,Matriz.UNCERO);
    } 

    @After
    public void tearDown()
    {
    }
}
