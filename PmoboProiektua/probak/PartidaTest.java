import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xakea.*;

public class PartidaTest {

    Partida p1,p2;

	@Before
	public void setUp() throws Exception {
        p2 = new Partida();
	}

	@After
	public void tearDown() throws Exception {
        
        Taula.getTaula().reset();
	}

	@Test
	public void testPartida() {
		assertNull(p1);
        p1=new Partida();
        assertNotNull(p1);
	}

	@Test
	public void testPartidaBukatuDa() {
		p2.partidaBatJolastu(); //Partida jolastu bukatu arte (xake mate lortu edo "bai" idatzi berdinketa gertatu arte)
		assertTrue(p2.partidaBukatuDa());
	}

	@Test
	public void testXakeMate() {
		p2.partidaBatJolastu(); //Partida jolastu xake mate lortu arte
		assertTrue(p2.partidaBukatuDa());
		assertFalse(p2.berdinketa());
	}

	@Test
	public void testBerdinketa() {
		p2.partidaBatJolastu(); //Berdinketa adostu ("bai" idatzi berdinketa gertatu arte)
		assertTrue(p2.partidaBukatuDa());
		assertTrue(p2.berdinketa());
	}
}