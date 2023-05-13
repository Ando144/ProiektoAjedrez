import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xakea.MugimenduOkerraException;
import xakea.Dorrea;
import xakea.Taula;

public class DorreaTest {
    
    Dorrea d1,d2,d3;
    
    @Before
    public void setUp() throws Exception{
        d1 = new Dorrea(true, 4, 4, "zuria");
        d2 = new Dorrea(false, 5, 4, "Beltza");
        d3 = new Dorrea(true, 1, 1, "Beltza");
        
        Taula.getTaula().setLaukianPieza(4, 4, d1);
        Taula.getTaula().setLaukianPieza(5, 4, d2);
        Taula.getTaula().setLaukianPieza(1, 1, d3);
    }   
    @After
    public void tearDown() throws Exception{
        d1=null;
        d2=null;
        d3=null;
        Taula.getTaula().taulaErreseteatu();
    }
    @Test
    public void mugituDaiteke(){
        try{
            assertTrue(d1.mugituDaiteke(4, 0));
            assertTrue(d1.mugituDaiteke(4, 6));
            assertTrue(d1.mugituDaiteke(3, 4));
            assertTrue(d1.mugituDaiteke(5, 4));//Beste koloreko pieza bat egotekotan hau jaten du
        }
        catch(MugimenduOkerraException e){fail();}
        try{
            Taula.getTaula().piezaJarri(d2, 4, 5);
            assertFalse(d1.mugituDaiteke(4, 6));//Dorrea ezin da beste piezen gainetik pasa, kontrako kolorekoak badira ere
            Taula.getTaula().piezaJarri(d3, 0, 4);
            assertFalse(d1.mugituDaiteke(0, 4));//Ezin da mugitu bere kolore berdineko pieza baten posiziora
        }
        catch(MugimenduOkerraException e){}
    }
}
