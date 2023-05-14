import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xakea.MugimenduOkerraException;
import xakea.Erregea;
import xakea.Taula;

public class ErregeaTest {
    
    Erregea e1,e2,e3;

    @Before
    public void setUp()throws Exception{
        e1 = new Erregea(true, 4, 4, "zuria");
        e2 = new Erregea(true,6,6,"zuria");
        e3 = new Erregea(false,4,5,"beltza");
    }
    @After
    public void tearDown()throws Exception{
        e1=null;
        e2=null;
        e3=null;
        Taula.getTaula().taulaErreseteatu();
    }
    @Test
    public void mugituDaiteke(){
        try{
            assertTrue(e1.mugituDaiteke(5, 5));
            assertTrue(e1.mugituDaiteke(5, 3));
            assertTrue(e1.mugituDaiteke(3, 5));
            assertTrue(e1.mugituDaiteke(3, 3));
            assertTrue(e1.mugituDaiteke(3, 4));
            assertTrue(e1.mugituDaiteke(5, 4));
            assertTrue(e1.mugituDaiteke(4, 3));
            assertTrue(e1.mugituDaiteke(4, 5));//Kontrako koloreko pieza bat egotekotan laukian hau jan egingo du
        }
        catch(MugimenduOkerraException e){fail();}
        try{
            assertFalse(e1.mugituDaiteke(6, 5));
            assertFalse(e1.mugituDaiteke(2, 3));
            assertFalse(e1.mugituDaiteke(4, 4));
            Taula.getTaula().piezaJarri(e2, 5, 5);
            assertFalse(e1.mugituDaiteke(5, 5));//Ezin da mugitu bere taldeko pieza bat dagoen lauki batera
            assertFalse(e1.mugituDaiteke(4, 4));//Ezin da bere posizio berdinera mugitu
        }
        catch(MugimenduOkerraException e){}
    }
    @Test
    public void mugimenduLegalakDitu(){
        Taula.getTaula().setLaukianPieza(5, 5, e2); 
        Taula.getTaula().setLaukianPieza(5, 3, e2); 
        Taula.getTaula().setLaukianPieza(3, 5, e2);
        assertTrue(e1.mugimenduLegalakDitu());
        Taula.getTaula().setLaukianPieza(3, 3, e2);
        assertTrue(e1.mugimenduLegalakDitu());
        Taula.getTaula().setLaukianPieza(3, 4, e2);
        Taula.getTaula().setLaukianPieza(5, 4, e2);
        Taula.getTaula().setLaukianPieza(4, 3, e2);
        assertTrue(e1.mugimenduLegalakDitu());
        Taula.getTaula().setLaukianPieza(4, 5, e2);
        assertFalse(e1.mugimenduLegalakDitu());
    }
}
