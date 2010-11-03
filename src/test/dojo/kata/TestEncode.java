package dojo.kata;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static dojo.kata.Encode.encode;
import static dojo.kata.Encode.getFirstRun;
import static dojo.kata.Encode.rle;
import org.junit.Test;


public class TestEncode{
	@Test public void testtruth(){
		assertTrue(true);
	}
	
	@Test public void encodeEmpty(){
		assertTrue(encode("").equals(""));
	}
	
	@Test public void encodeSingleA(){
		assertTrue(encode("A").equals("1A"));
	}
	
	@Test public void encodeSingleB(){
		assertTrue(encode("B").equals("1B"));
	}
	
	@Test public void encodeTwoC(){
		assertTrue(encode("CC").equals("2C"));
	}
	
	@Test public void encodeTwoD(){
		assertTrue(encode("DD").equals("2D"));
	}
	
	@Test public void getFirstRunEmpty(){
		assertTrue(getFirstRun("").equals(""));
	}
	
	@Test public void getFirstRunSingleA(){
		assertTrue(getFirstRun("A").equals("A"));
	}
	
	@Test public void getFirstRunSingleB(){
		assertTrue(getFirstRun("B").equals("B"));
	}
	
	@Test public void getFirstRunCoupleAB(){
		assertTrue(getFirstRun("AB").equals("A"));
	}

	@Test public void getFirstRunAAB(){
		assertTrue(getFirstRun("AAB").equals("AA"));
	}
	
	@Test public void getFirstRunAAAB(){
		assertTrue(getFirstRun("AAAB").equals("AAA"));
	}
	
	@Test public void rleEmpty(){	
		assertTrue(rle("").equals(""));
	}
	
	@Test public void rleA(){	
		assertTrue(rle("A").equals("1A"));
	}
	
	@Test public void rleB(){	
		assertTrue(rle("B").equals("1B"));
	}

	@Test public void rleAB(){	
		assertTrue(rle("AB").equals("1A1B"));
	}
	
	@Test public void rleAAB(){	
		assertTrue(rle("AAB").equals("2A1B"));
	}
	
	@Test public void rleABB(){	
		assertTrue(rle("ABB").equals("1A2B"));
	}
	
	@Test public void rleABBCC(){	
		assertTrue(rle("ABBCC").equals("1A2B2C"));
	}

	@Test public void rleABBAA(){	
		assertTrue(rle("ABBAA").equals("1A2B2A"));
	}
	// Completion test from wikipedia
	@Test public void rleComplete(){	
		assertEquals("12W1B12W3B24W1B14W",rle("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW"));
	}	

}

