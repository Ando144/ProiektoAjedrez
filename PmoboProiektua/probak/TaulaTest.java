import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xakea.MugimenduOkerraException;
import xakea.Taula;
import xakea.Peoia;

public class TaulaTest {
    
    Peoia p1;

    @Before
    public void setUp(){
        p1=new Peoia(true, 0, 0, "zuria");
    }
    @After 
    public void tearDown(){
        p1=null;
        Taula.getTaula().taulaErreseteatu();
    }
    @Test
    public void piezaJarri(){
        assertTrue(Taula.getTaula().getLaukikoPieza(4, 4)==null);
        Taula.getTaula().piezaJarri(p1, 4, 4);
        assertFalse(Taula.getTaula().getLaukikoPieza(4, 4)==null);
        assertTrue(Taula.getTaula().getLaukikoPieza(0, 0)==null);
    }
    @Test
    public void taulanDago(){
        assertFalse(Taula.getTaula().laukiaTaulanDago(10, 0));
        assertFalse(Taula.getTaula().laukiaTaulanDago(0, 9));
        assertTrue(Taula.getTaula().laukiaTaulanDago(1, 0));
    }
    @Test
    public void laukiaBetetaDago(){
        assertFalse(Taula.getTaula().laukiaBetetaDago(4, 4));
        Taula.getTaula().piezaJarri(p1, 4, 4);
        assertTrue(Taula.getTaula().laukiaBetetaDago(4, 4));
    }

}
