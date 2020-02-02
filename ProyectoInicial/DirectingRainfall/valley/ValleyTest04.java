package valley;

import org.junit.Assert;
import org.junit.Test;

/**
 * The test class ValleyTest02.
 * @author  (Ernesto Camacho AC y Daniela Ruiz AR)
 */
public class ValleyTest04 {
    @Test
    public void segunACdeberiaCrearLluviaAcida() {
        Valley v = new Valley(100, 100);
        v.startRain("Acid",50);
        Assert.assertTrue(v.ok());
    }
    
    @Test
    public void segunACdeberiaCrearLluviaNormal() {
        Valley v = new Valley(100, 100);
        v.startRain("Normal",50);
        Assert.assertTrue(v.ok());
    }
    
    @Test
    public void segunACdeberiaCrearLluviaStraight() {
        Valley v = new Valley(100, 100);
        v.startRain("Straight",50);
        Assert.assertTrue(v.ok());
    }
    
    @Test
    public void segunAClaLluviaStraightNoDeberiaParar() {
        Valley v = new Valley(100, 100);
        v.openVineyard("red", 0, 50);
        v.startRain("Straight",40);
        v.stopRain(1);
        Assert.assertFalse(v.ok());
    }
    
    @Test
    public void segunAClaLluviaStraightDeberiaParar() {
        Valley v = new Valley(100, 100);
        v.openVineyard("red", 0, 50);
        v.startRain("Straight",80);
        v.stopRain(1);
        Assert.assertFalse(v.ok());
    }
        
    @Test
    public void segunARdeberiaCrearLonaNormal() {
        Valley v = new Valley(100, 100);
        v.addTarp("Normal",new int[]{0, 30}, new int[]{10, 50});
        Assert.assertTrue(v.ok());
    }
    
    @Test
    public void segunARdeberiaCrearLonaFlexible() {
        Valley v = new Valley(100, 100);
        v.addTarp("Flexible",new int[]{0, 30}, new int[]{10, 50});
        Assert.assertTrue(v.ok());
    }
    
    @Test
    public void segunARdeberiaCrearLonaRadical() {
        Valley v = new Valley(100, 100);
        v.addTarp("Radical",new int[]{0, 30}, new int[]{10, 50});
        Assert.assertTrue(v.ok());
    }
    
    @Test
    public void segunARdeberiaCrearLonaHard() {
        Valley v = new Valley(100, 100);
        v.addTarp("Hard",new int[]{0, 30}, new int[]{10, 50});
        Assert.assertTrue(v.ok());
    }
    
    @Test
    public void segunARnoDeberiaEliminarLonaHard() {
        Valley v = new Valley(100, 100);
        v.addTarp("Hard",new int[]{0, 30}, new int[]{10, 50});
        v.removeTarp(1);
        Assert.assertFalse(v.ok());
    }
    
    @Test
    public void segunARnoDeberiaAgujerarLonaHard() {
        Valley v = new Valley(100, 100);
        v.addTarp("Hard",new int[]{0, 30}, new int[]{10, 50});
        v.makePuncture(10, 5);
        Assert.assertFalse(v.ok());
    }    
    
    @Test
    public void segunARseDebeCrearLaLonaInmutable() {
        Valley v = new Valley(100, 100);
        v.addTarp("Inmutable",new int[]{0, 30}, new int[]{10, 50});
        Assert.assertTrue(v.ok());
    }
    
    @Test
    public void segunACseDebeCrearLaLluviaPegajosa() {
        Valley v = new Valley(100, 100);
        v.startRain("Pegajosa",50);
        Assert.assertTrue(v.ok());
    }
    
    @Test
    public void segunAClaLluviaPegajosaDebePararAlContactoDeUnaLona() {
        Valley v = new Valley(100, 100);
        v.openVineyard("red", 0, 50);
        v.addTarp("Hard",new int[]{30, 30}, new int[]{50, 50});
        v.startRain("Pegajosa",40);
        String[] vinedos= v.rainFalls();
        Assert.assertEquals(new String[]{},vinedos);
    }
        
}
