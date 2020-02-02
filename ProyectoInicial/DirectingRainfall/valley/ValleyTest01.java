package valley;

import org.junit.Assert;
import org.junit.Test;

public class ValleyTest01 {
    @Test
    public void shouldOpenVineyard() {
        // Assume
        Valley v = new Valley(100, 100);

        // Action
        v.openVineyard("red", 0, 10);

        // Assert
        Assert.assertTrue(v.ok());
    }

    @Test
    public void shouldNotOpenVineyardOutOfValley() {
        // Assume
        Valley v = new Valley(100, 100);

        // Action
        v.openVineyard("red", 200, 210);

        // Assert
        Assert.assertFalse(v.ok());
    }

    @Test
    public void shouldCloseVineyard() {
        // Assume
        Valley v = new Valley(100, 100);
        v.openVineyard("red", 0, 10);

        // Action
        v.closeVineyard("red");

        // Assert
        Assert.assertTrue(v.ok());
    }

    @Test
    public void shouldNotCloseNonExistentVineyard() {
        // Assume
        Valley v = new Valley(100, 100);
        v.openVineyard("red", 0, 10);

        // Action
        v.closeVineyard("green");

        // Assert
        Assert.assertFalse(v.ok());
    }

    @Test
    public void shouldAddTrap() {
        // Assume
        Valley v = new Valley(100, 100);

        // Action
        v.addTarp("Normal",new int[]{0, 30}, new int[]{10, 50});

        // Assert
        Assert.assertTrue(v.ok());
    }

    @Test
    public void shouldNotAddTrapOutOfValley() {
        // Assume
        Valley v = new Valley(100, 100);

        // Action
        v.addTarp("Normal", new int[]{0, 200}, new int[]{10, 50});

        // Assert
        Assert.assertFalse(v.ok());
    }

    @Test
    public void shouldRemoveTrap() {
        // Assume
        Valley v = new Valley(100, 100);
        v.addTarp("Normal",new int[]{0, 30}, new int[]{10, 50});

        // Action
        v.removeTarp(1);

        // Assert
        Assert.assertTrue(v.ok());
    }

    @Test
    public void shouldNotRemoveNonExistentTrap() {
        // Assume
        Valley v = new Valley(100, 100);
        v.addTarp("Normal",new int[]{0, 30}, new int[]{10, 50});

        // Action
        v.removeTarp(10);

        // Assert
        Assert.assertFalse(v.ok());
    }

    @Test
    public void shouldMakePuncture() {
        // Assume
        Valley v = new Valley(100, 100);
        v.addTarp("Normal",new int[]{0, 30}, new int[]{10, 50});

        // Action
        v.makePuncture(1, 5);

        // Assert
        Assert.assertTrue(v.ok());
    }

    @Test
    public void shouldNotMakePunctureOnNonExistentTrap() {
        // Assume
        Valley v = new Valley(100, 100);
        v.addTarp("Normal",new int[]{0, 30}, new int[]{10, 50});

        // Action
        v.makePuncture(10, 5);

        // Assert
        Assert.assertFalse(v.ok());
    }

    @Test
    public void shouldNotMakePunctureOutOfTrap() {
        // Assume
        Valley v = new Valley(100, 100);
        v.addTarp("Normal",new int[]{0, 30}, new int[]{10, 50});

        // Action
        v.makePuncture(1, 50);

        // Assert
        Assert.assertFalse(v.ok());
    }

    @Test
    public void shouldPatchPuncture() {
        // Assume
        Valley v = new Valley(100, 100);
        v.addTarp("Normal",new int[]{0, 30}, new int[]{10, 50});
        v.makePuncture(1, 5);

        // Action
        v.patchPuncture(1, 1);

        // Assert
        Assert.assertTrue(v.ok());
    }

    @Test
    public void shouldNotPatchNonExistentPuncture() {
        // Assume
        Valley v = new Valley(100, 100);
        v.addTarp("Normal",new int[]{0, 30}, new int[]{10, 50});
        v.makePuncture(1, 5);

        // Action
        v.patchPuncture(1, 10);

        // Assert
        Assert.assertFalse(v.ok());
    }

    @Test
    public void shouldStartRain() {
        // Assume
        Valley v = new Valley(100, 100);
        v.addTarp("Normal",new int[]{0, 30}, new int[]{10, 50});

        // Action
        v.startRain("Normal",5);

        // Assert
        Assert.assertTrue(v.ok());
    }

    @Test
    public void shouldNotStartRainOutOfValley() {
        // Assume
        Valley v = new Valley(100, 100);
        v.addTarp("Normal",new int[]{0, 30}, new int[]{10, 50});

        // Action
        v.startRain("Normal",500);

        // Assert
        Assert.assertFalse(v.ok());
    }

    @Test
    public void shouldStopRain() {
        // Assume
        Valley v = new Valley(100, 100);
        v.addTarp("Normal",new int[]{0, 30}, new int[]{10, 50});
        v.startRain("Normal",5);

        // Action
        v.stopRain(1);

        // Assert
        Assert.assertTrue(v.ok());
    }

    @Test
    public void shouldNotStopNonExistentRain() {
        // Assume
        Valley v = new Valley(100, 100);
        v.addTarp("Normal",new int[]{0, 30}, new int[]{10, 50});
        v.startRain("Normal",5);

        // Action
        v.stopRain(10);

        // Assert
        Assert.assertFalse(v.ok());
    }

    @Test
    public void someRainShouldReachVineyard() {
        // Assume
        Valley v = new Valley(100, 100);
        v.openVineyard("red", 10, 20);
        v.addTarp("Normal",new int[]{15, 10}, new int[]{30, 50});
        v.addTarp("Normal",new int[]{150, 150}, new int[]{250, 250});
        v.startRain("Normal",18);

        // Action
        String[] reachedVineyards = v.rainFalls();

        // Assert
        Assert.assertArrayEquals(new String[]{"red"}, reachedVineyards);
    }

    @Test
    public void noRainShouldReachVineyard() {
        // Assume
        Valley v = new Valley(100, 100);
        v.openVineyard("red", 10, 20);
        v.addTarp("Normal",new int[]{15, 10}, new int[]{30, 50});
        v.startRain("Normal",2);

        // Action
        String[] reachedVineyards = v.rainFalls();

        // Assert
        Assert.assertArrayEquals(new String[]{}, reachedVineyards);
    }
}
