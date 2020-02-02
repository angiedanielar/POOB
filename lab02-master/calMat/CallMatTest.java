import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CallMatTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CallMatTest
{
    /**
     * Default constructor for test class CallMatTest
     */
    public CallMatTest(){
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    
    @Test
    public void deberiaEmpilarUnaMatriz(){
         int [][] dA={{1,2,3},{4,5,6},{7,8,9}};
         Matriz mat= new Matriz(dA);
         String mat1= mat.toString();
         CalMat cM= new CalMat();
         cM.empile(dA);
         String mat2= cM.consulte();
         assertEquals(mat1,mat2);
    }
    
    @Test
    public void deberiaDesempilarUnaMatriz(){
        int [][] dA={{1,2,3},{4,5,6},{7,8,9}};
        int [] dB= {1,2,3,4,5,6};
        Matriz matriz1= new Matriz(dA);
        Matriz matriz2= new Matriz(dB);
        String mat1= matriz1.toString();
        String mat2= matriz2.toString();
        CalMat cM= new CalMat();
        cM.empile(dB);
        cM.empile(dA);
        cM.desempile();
        String mat3= cM.consulte();
        assertEquals(mat2,mat3);
    }
    
    @Test
    public void deberiaOperarMatrices(){
        int [][] dA={{1,2,3},{4,5,6},{7,8,9}};
        int dB= 3;
        Matriz matriz1= new Matriz(dA);
        Matriz matriz2= new Matriz(dB);
        CalMat cM= new CalMat();
        cM.empile(dB);
        cM.empile(dA);
        cM.opereMatrices('+');
        String mat= cM.consulte();
        String mat1= "247 268 379";
        assertEquals(mat,mat1);
    }
    
    @Test
    public void noDeberiaOperarMatrices(){
        int [][] dA={{1,2,3},{4,5,6},{7,8,9}};
        int [] dB= {1,2,3,4,5,6};
        Matriz matriz1= new Matriz(dA);
        Matriz matriz2= new Matriz(dB);
        CalMat cM= new CalMat();
        cM.empile(dB);
        cM.empile(dA);
        cM.opereMatrices('+');
        boolean valor= cM.ok();
        assertEquals(valor,false);
    }
    
    @Test 
    public void deberiaOperarMatriz(){
        int [][] dA={{1,2,3},{4,5,6},{7,8,9}};
        Matriz matriz1= new Matriz(dA);
        CalMat cM= new CalMat();
        cM.empile(dA);
        cM.opereMatriz('+');
        boolean valor= cM.ok();
        assertEquals(valor,true);
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
