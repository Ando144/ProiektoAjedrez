import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xakea.MugimenduOkerraException;
import xakea.Peoia;
import xakea.Taula;

public class PeoiaTest {

    Peoia p1,p2,p3,p4;
    @Before
    public void setUp() throws Exception{
        p1=new Peoia(true,2,2,"zuria");
        p2=new Peoia(true,1,1,"zuria");
        p3=new Peoia(false,6,1,"beltza");
        p4=new Peoia(false,5,2,"beltza");
        
        Taula.getTaula().setLaukianPieza(2, 2, p1);
        Taula.getTaula().setLaukianPieza(1, 1, p2);
        Taula.getTaula().setLaukianPieza(6, 1, p3);
        Taula.getTaula().setLaukianPieza(5, 2, p4);

    }

    @After
    public void tearDown() throws Exception{
        p1=null;
        p2=null;
        p3=null;
        p4=null;
        Taula.getTaula().taulaErreseteatu();
    }

    @Test
    public void mugituDaiteke(){
        try{
            assertTrue(p2.mugituDaiteke(2,1));
            assertTrue(p2.mugituDaiteke(3,1)); //Hasieran bi posizio mugitu daiteke
            assertTrue(p1.mugituDaiteke(3,2)); //Beste kasutan bakarrik bat
            Taula.getTaula().piezaJarri(p3, 3, 3);
            assertTrue(p1.mugituDaiteke(3, 3)); //Diagonalki mugitzeko beste koloreko piza bat egon behar da
        }
        catch(MugimenduOkerraException e){fail();}
        try{
            Taula.getTaula().piezaJarri(p3, 7, 1);
            assertFalse(p1.mugituDaiteke(4, 2)); //Pieza ez dago hasieran bi lauki mugitzeko
            assertFalse(p1.mugituDaiteke(3, 3)); //Ez dago piezarik diagonalean hau jateko
        }
        catch(MugimenduOkerraException e){}
        //Test berdinak kontrako kolorearekin
        try{
            Taula.getTaula().piezaJarri(p3, 6, 1);
            assertTrue(p3.mugituDaiteke(5,1));
            assertTrue(p4.mugituDaiteke(4,2)); //Beste kasutan bakarrik bat
            Taula.getTaula().piezaJarri(p2, 4, 3);
            assertTrue(p4.mugituDaiteke(4, 3)); //Diagonalki mugitzeko beste koloreko piza bat egon behar da
        }
        catch(MugimenduOkerraException e){fail();}
        try{
            Taula.getTaula().piezaJarri(p2, 1, 1);
            assertFalse(p4.mugituDaiteke(3, 2)); //Pieza ez dago hasieran bi lauki mugitzeko
            assertFalse(p4.mugituDaiteke(4, 3)); //Ez dago piezarik diagonalean hau jateko
        }
        catch(MugimenduOkerraException e){}
        
    }
}
