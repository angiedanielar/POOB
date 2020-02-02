package valley;

import org.junit.Assert;
import org.junit.Test;

/**
 * The test class ValleyTest02.
 * @author  (Ernesto Camacho AC y Daniela Ruiz AR)
 */
public class ValleyTest02 {
    @Test
    public void segunACdeberiaAgrandarElValle() {
        Valley v = new Valley(100, 100);
        v.zoom('+');
        Assert.assertTrue(v.ok());
    }
    
    @Test
    public void segunACdeberiaEncogerElValle() {
        Valley v = new Valley(100, 100);
        v.zoom('-');
        Assert.assertTrue(v.ok());
    } 
    
    @Test
    public void segunACnoDeberiaDeshacerSiNoHaRealizadoNingunaOperacion() {
        Valley v = new Valley(100, 100);
        v.does('U');
        Assert.assertFalse(v.ok());
    }
    
    @Test
    public void segunACnoDeberiaRehacerSiNoHaRealizadoNingunaOperacion() {
        Valley v = new Valley(100, 100);
        v.does('R');
        Assert.assertFalse(v.ok());
    }
    
    @Test
    public void segunACdeberiaCrearVinedosConNombreDeSuColor() {
        Valley v = new Valley(100, 100);
        v.openVineyard("red",0,20);
        Assert.assertTrue(v.ok());
    }
    
    @Test
    public void segunACnoDeberiaCrearVinedosConNombreDiferenteDeSuColor() {
        Valley v = new Valley(100, 100);
        v.openVineyard("algo",0,20);
        Assert.assertFalse(v.ok());
    }
    
    @Test
    public void segunARdeberiaDeshacerLaUltimaOperacion() {
        Valley v = new Valley(100, 100);
        v.openVineyard("red",0,20);
        v.does('U');
        Assert.assertTrue(v.ok());
    }
    
    @Test
    public void segunARnodeberiaDejarCerrarUnHuecoQueYaEstaCerrado() {
        Valley v = new Valley(100, 100);
        v.addTarp("Normal",new int[]{0, 30}, new int[]{10, 50});
        v.makePuncture(1, 5);
        v.patchPuncture(1, 5);
        v.patchPuncture(1, 5);
        Assert.assertFalse(v.ok());
    }
    
    @Test
    public void segunARdeberiaRehacerLaUltimaOperacion() {
        Valley v = new Valley(100, 100);
        v.openVineyard("red",0,20);
        v.does('U');
        v.does('R');
        Assert.assertTrue(v.ok());
    }
    
    @Test
    public void segunARdeberiaConsultarLaInformacionDelosVinedos() {
        Valley v = new Valley(100, 100);
        v.openVineyard("red",0,20);
        v.vineyards();
        Assert.assertTrue(v.ok());
    } 
    
    @Test
    public void segunARdeberiaConsultarLaInformacionDelasTrampas() {
        Valley v = new Valley(100, 100);
        v.openVineyard("red",0,20);
        v.tarps();
        Assert.assertTrue(v.ok());
    } 
    
    @Test
    public void segunARdeberiaConsultarLaInformacionDelaLluvia() {
        Valley v = new Valley(100, 100);
        v.openVineyard("red",0,20);
        v.rains();
        Assert.assertTrue(v.ok());
    } 
}
