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
	
	@Test public void encodeSingleChar(){
		assertTrue(encode("A").equals("1A"));
	}
}
