package dojo.kata;


import static org.junit.Assert.*;

import org.junit.Test;


public class TestPuissance4{
	@Test public void testtruth(){
		assertTrue(true);
	}
	@Test public void testPuissance4Exists(){
		Puissance4 p4 = new Puissance4();
		assertNotNull(p4);
	}
	
	@Test public void testPlayB1()
	{
		Puissance4 p4 = new Puissance4();
		assertEquals(false, p4.play('b', 1));
	}
	
	@Test public void testPlayWin() {
		Puissance4 p4 = new Puissance4();
		p4.play('b', 1);
		p4.play('b', 2);
		p4.play('b', 3);
		assertEquals(true, p4.play('b', 4));
	}
	
	@Test public void testPlayLost() {
		Puissance4 p4 = new Puissance4();
		p4.play('b', 1);
		p4.play('b', 2);
		p4.play('b', 3);
		assertEquals(false, p4.play('n', 4));
	}
	

	@Test public void testTop( ){
		Puissance4 p4=new Puissance4();
		int col = 1;
		p4.play('b', col);
		p4.play('b', col);
		assertEquals(2, p4.getTop(col));
	}

	@Test public void testTopPourUneAutreCol( ){
		Puissance4 p4=new Puissance4();
		int col = 1;
		p4.play('b', col);
		p4.play('n', col);
		col = 2;
		p4.play('b', col);
		assertEquals(1, p4.getTop(col));
		assertEquals(2, p4.getTop(1));
		assertEquals(0, p4.getTop(3));
//		assertEquals('n', p4.getContent(1, 2));
	}

//	@Test public void testRecettePuissance4(){
//		Puissance4 p4=new Puissance4();
//		assertFalse(p4.play('b', 1)); // return false
//		p4.play('n', 7); 
//		assertEquals('n',p4.getContent(7,p4.getTop(7)));
//		p4.play('b', 2);
//		assertEquals('b', p4.getContent(2,p4.getTop(2)));
//		p4.play('n', 7);
//		assertEquals('n',p4.getContent(7,p4.getTop(7)));
//		p4.play('b', 3);
//		assertEquals('b',p4.getContent(3,p4.getTop(3)));
//		p4.play('n', 7);
//		assertEquals('n',p4.getContent(7,p4.getTop(7)));
//		assertTrue(p4.play('b', 4));
//	}
//
//	@Test public void testRecetteDiag(){
//		Puissance4 p4=new Puissance4();
//		assertFalse(p4.play('b', 1));
//		assertFalse(p4.play('n', 2));
//		assertFalse(p4.play('b', 3));
//		assertFalse(p4.play('n', 5));
//		assertFalse(p4.play('b', 2));
//		assertFalse(p4.play('n', 3));
//		assertFalse(p4.play('b', 3));
//		assertFalse(p4.play('n', 4));
//		assertFalse(p4.play('b', 4));
//		assertFalse(p4.play('n', 4));
//		assertTrue(p4.play('b', 4));
//	}
//	@Test public void testRecetteColGagne(){
//		Puissance4 p4=new Puissance4();
//		assertFalse(p4.play('b', 1));
//		assertFalse(p4.play('n', 2));
//		assertFalse(p4.play('b', 1));
//		assertFalse(p4.play('n', 2));
//		assertFalse(p4.play('b', 1));
//		assertFalse(p4.play('n', 2));
//		assertTrue(p4.play('b', 1));
//	}

}
