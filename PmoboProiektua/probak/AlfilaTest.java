import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xakea.MugimenduOkerraException;
import xakea.Alfila;
import xakea.Taula;

public class AlfilaTest {

    Alfila a1,a2,a3;

    @Before
    public void setUp()throws Exception{
        a1 = new Alfila(true, 4, 4, "zuria");
        a2 = new Alfila(false,2, 6, "beltza");
        a3 = new Alfila(true, 6, 6, "zuria");

        Taula.getTaula().setLaukianPieza(4, 4, a1);
        Taula.getTaula().setLaukianPieza(2, 6, a2);
        Taula.getTaula().setLaukianPieza(6, 6, a3);
    }
    @After 
    public void tearDown()throws Exception{
        a1=null;
        a2=null;
        a3=null;
        Taula.getTaula().taulaErreseteatu();
    }
    @Test
    public void mugituDaiteke(){
        try{
            assertTrue(a1.mugituDaiteke(1, 1));
            assertTrue(a1.mugituDaiteke(5, 5));
            assertTrue(a1.mugituDaiteke(3, 5));
            assertTrue(a1.mugituDaiteke(2, 6));//Beste koloreko pieza bat egotekotan hau jaten du
        }
        catch(MugimenduOkerraException e){fail();}
        try{
            Taula.getTaula().piezaJarri(a2, 2, 2);
            assertFalse(a1.mugituDaiteke(1, 1));//Ezin da beste pieza baten gainetik pasa, hau kontrako kolorekoa bada ere
            assertFalse(a1.mugituDaiteke(6,6));//Ezin da bere koloreko pieza baten posiziora mugitu
        }
        catch(MugimenduOkerraException e){}
    }
    
}
