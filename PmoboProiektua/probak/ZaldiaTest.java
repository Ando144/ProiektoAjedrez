import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xakea.MugimenduOkerraException;
import xakea.Zaldia;
import xakea.Taula;

public class ZaldiaTest{

    Zaldia z1,z2,z3,z4;

    @Before
    public void setUp() throws Exception{
        z1 = new Zaldia(true, 4, 4, "zuria");
        z2 = new Zaldia(false, 6, 3, "beltza");
        z3 = new Zaldia(false, 3, 6, "beltza");
        z4 = new Zaldia(true, 0, 0, "zuria");

        Taula.getTaula().setLaukianPieza(4, 4, z1);
        Taula.getTaula().setLaukianPieza(6, 3, z2);
        Taula.getTaula().setLaukianPieza(3, 6, z3);
        Taula.getTaula().setLaukianPieza(0, 0, z4);
    }
    @After
    public void tearDown() throws Exception{
        z1=null;
        z2=null;
        z3=null;
        z4=null;
        Taula.getTaula().taulaErreseteatu();
    }
    @Test 
    public void mugituDaiteke(){
        try{
            assertTrue(z1.mugituDaiteke(6,3));//Beste koloreko pieza bat egotekotan hau jaten du
            assertTrue(z1.mugituDaiteke(6, 5));
            assertTrue(z1.mugituDaiteke(2, 3));
            assertTrue(z1.mugituDaiteke(2, 5));

            assertTrue(z1.mugituDaiteke(3, 6));//Beste koloreko pieza bat egotekotan hau jaten du
            assertTrue(z1.mugituDaiteke(5, 6));
            assertTrue(z1.mugituDaiteke(3, 2));
            assertTrue(z1.mugituDaiteke(5, 2));
        }
        catch(MugimenduOkerraException e){fail();}
        try{
            assertFalse(z1.mugituDaiteke(6, 6));//Zaldiak bakarrik zortzi mugimendu posible izango ditu
            assertFalse(z1.mugituDaiteke(4, 5));
            Taula.getTaula().piezaJarri(z4, 6, 3);
            assertFalse(z1.mugituDaiteke(6, 3));//Bere kolore berdineko pieza bat egotekotan hau ezin izango da mugitu hona
            assertFalse(z1.mugituDaiteke(4, 4));//Ezin da bere posizio berdinera mugitu
        }
        catch(MugimenduOkerraException e){}
    }
    @Test
    public void mugimenduLegalakDitu(){
        Taula.getTaula().setLaukianPieza(6,3, z4);
        Taula.getTaula().setLaukianPieza(6, 5, z4);
        Taula.getTaula().setLaukianPieza(2, 3, z4);
        Taula.getTaula().setLaukianPieza(2, 5, z4);
        assertTrue(z1.mugimenduLegalakDitu());
        Taula.getTaula().setLaukianPieza(3, 6, z4);
        Taula.getTaula().setLaukianPieza(5, 6, z4);
        Taula.getTaula().setLaukianPieza(3, 2, z4);
        assertTrue(z1.mugimenduLegalakDitu());
        Taula.getTaula().setLaukianPieza(5, 2, z4);
        assertFalse(z1.mugimenduLegalakDitu());
    }
}