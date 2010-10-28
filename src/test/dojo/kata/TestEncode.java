package dojo.kata;


import static org.junit.Assert.assertTrue;
import static dojo.kata.Encode.encode;
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
}
