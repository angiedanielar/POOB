package pruebas;

import aplicacion.*;
import static org.junit.Assert.*;
import junit.framework.Assert;
import org.junit.Test;

public class ReplicateTest {
	@Test
	public void deberiaReplicarCorrectamente() {
		Replicate prueba= new Replicate(3,3);
		prueba.cambieEstadoCasilla(1, 1);
		int a = prueba.consulteEstadoCasilla(1, 1);
		int b = 1;
		assertEquals(a,b);
		}
	
    @Test
	public void noDeberiaDejarColocarMedidasInvalidas() throws ReplicateException {
		try{
			Replicate prueba= new Replicate(3,3);
			prueba.changeSize(-1, 0);			
			}
		catch(ReplicateException e){
			assertTrue(e.getMessage().equals(ReplicateException.WRONG_DIMENSIONS));
			} 
		}
}

