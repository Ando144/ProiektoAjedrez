import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xakea.MugimenduOkerraException;
import xakea.Erregina;
import xakea.Taula;

public class ErreginaTest {
    
    Erregina e1,e2,e3;

    @Before
    public void setUp() throws Exception{
        e1 = new Erregina(true, 4, 4, "zuria");
        e2 = new Erregina(true,6,6,"zuria");
        e3 = new Erregina(false,2,6,"beltza");
    }
    @After 
    public void tearDown() throws Exception{
        e1=null;
        e2=null;
        e3=null;
        Taula.getTaula().taulaErreseteatu();
    }
    @Test
    public void mugituDaiteke(){
        try{
            //Mugimendu diagonalak
            assertTrue(e1.mugituDaiteke(1, 1));
            assertTrue(e1.mugituDaiteke(5, 5));
            assertTrue(e1.mugituDaiteke(3, 5));
            assertTrue(e1.mugituDaiteke(2, 6));//Beste koloreko pieza bat egotekotan hau jaten du

            //Mugimendu zuzenak
            Taula.getTaula().piezaJarri(e3, 5, 4);
            assertTrue(e1.mugituDaiteke(4, 0));
            assertTrue(e1.mugituDaiteke(4, 6));
            assertTrue(e1.mugituDaiteke(3, 4));
            assertTrue(e1.mugituDaiteke(5, 4));//Beste koloreko pieza bat egotekotan hau jaten du
        }
        catch(MugimenduOkerraException e){fail();}
        try{
            //Mugimendu diagonalak
            Taula.getTaula().piezaJarri(e3, 2, 2);
            Taula.getTaula().piezaJarri(e2, 6, 6);
            assertFalse(e1.mugituDaiteke(1, 1));//Ezin da beste pieza baten gainetik pasa, hau kontrako kolorekoa bada ere
            assertFalse(e1.mugituDaiteke(6,6));//Ezin da bere koloreko pieza baten posiziora mugitu

            //Mugimendu zuzenak
            Taula.getTaula().piezaJarri(e3, 4, 5);
            assertFalse(e1.mugituDaiteke(4, 6));//Dorrea ezin da beste piezen gainetik pasa, kontrako kolorekoak badira ere
            Taula.getTaula().piezaJarri(e2, 0, 4);
            assertFalse(e1.mugituDaiteke(0, 4));//Ezin da mugitu bere kolore berdineko pieza baten posiziora
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
