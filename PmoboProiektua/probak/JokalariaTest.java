import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xakea.MugimenduOkerraException;
import xakea.Taula;
import xakea.Peoia;
import xakea.Jokalaria;

public class JokalariaTest {
    
    Peoia p1;
    Jokalaria j1;

    @Before
    public void setUp() throws Exception{
        p1 = ((Peoia)Taula.getTaula().getLaukikoPieza(1, 1));
        Taula.getTaula().setLaukianPieza(1, 1, p1);

        j1= new Jokalaria("j1", "Zuria");
    }
    @After
    public void tearDown()throws Exception{
        p1=null;
        j1=null;
        Taula.getTaula().taulaErreseteatu();
    }
    @Test 
    public void posizioaMehatxatzenAriDa(){

        assertTrue(j1.posizioaMehatxatzenAriDa(1, 1));
        assertTrue(j1.posizioaMehatxatzenAriDa(2, 2));
        assertTrue(j1.posizioaMehatxatzenAriDa(3, 0));
        assertTrue(j1.posizioaMehatxatzenAriDa(3, 3));
        assertFalse(j1.posizioaMehatxatzenAriDa(4, 0));
        assertFalse(Taula.getTaula().getLaukikoPieza(1, 2)==null);
        assertFalse(Taula.getTaula().getLaukikoPieza(0, 0)==null);
        assertTrue(Taula.getTaula().getLaukikoPieza(2, 2)==null);
        // 3. errenkada osoa mehatxatuta dago 2. errenkadan dauden peoiengatik
    }

}
