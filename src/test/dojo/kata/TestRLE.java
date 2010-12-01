package dojo.kata;


import static org.junit.Assert.*;

import org.junit.Test;


public class TestRLE{
	@Test public void testtruth(){
		assertTrue(true);
	}
	
	@Test public void test_encode_vide(){
		String chaine="";
		String encoded="";
		assertEquals(encoded, RLE.encode(chaine));		
	}
	
	@Test public void test_encode_une_seule_lettre(){
		String chaine="A";
		String encoded="1A";
		assertEquals(encoded, RLE.encode(chaine));		
	}
	
	@Test public void test_encode_null(){
		String chaine=null;
		String encoded="";
		assertEquals(encoded, RLE.encode(chaine));		
	}
	
	@Test public void test_encode_une_seule_lettre_pas_A(){
		String chaine="B";
		String encoded="1B";
		assertEquals(encoded, RLE.encode(chaine));		
	}
	
	@Test public void test_encode_une_seule_lettre_pas_AB(){
		String chaine="C";
		String encoded="1C";
		assertEquals(encoded, RLE.encode(chaine));		
	}
	
	@Test public void test_encode_deux_A(){
		String chaine="AA";
		String encoded="2A";
		assertEquals(encoded, RLE.encode(chaine));		
	}
	
	@Test public void test_encode_trois_A(){
		String chaine="AAA";
		String encoded="3A";
		assertEquals(encoded, RLE.encode(chaine));		
	}
		
	@Test public void test_encode_A_B(){
		String chaine="AB";
		String encoded="1A1B";
		assertEquals(encoded, RLE.encode(chaine));		
	}
	
	@Test public void test_encode_A_A_B(){
		String chaine="AAB";
		String encoded="2A1B";
		assertEquals(encoded, RLE.encode(chaine));		
	}
	
	@Test public void test_encode_A_A_A_B(){
		String chaine="AAAB";
		String encoded="3A1B";
		assertEquals(encoded, RLE.encode(chaine));		
	}
	@Test public void test_encode_A_A_A_B_B(){
		String chaine="AAABB";
		String encoded="3A2B";
		assertEquals(encoded, RLE.encode(chaine));		
	}
	@Test public void test_encode_A_C(){
		String chaine="AC";
		String encoded="1A1C";
		assertEquals(encoded, RLE.encode(chaine));		
	}
//	
//	@Test public void test_encode_B_C(){
//		String chaine="BC";
//		String encoded="1B1C";
//		assertEquals(encoded, RLE.encode(chaine));		
//	}
//	
//	@Test public void test_encode_B_C_D(){
//		String chaine="BCD";
//		String encoded="1B1C1D";
//		assertEquals(encoded, RLE.encode(chaine));		
//	}
//	
//	@Test public void test_encode_A_B_C(){
//		String chaine="ABC";
//		String encoded="1A1B1C";
//		assertEquals(encoded, RLE.encode(chaine));		
//	}
//	
//	@Test public void test_encode_A_B_B(){
//		String chaine="ABB";
//		String encoded="1A2B";
//		assertEquals(encoded, RLE.encode(chaine));		
//	}
//	@Test public void test_encode_A_B_C_D(){
//		String chaine="ABCD";
//		String encoded="1A1B1C1D";
//		assertEquals(encoded, RLE.encode(chaine));		
//	}
//	@Test public void test_get_prefix_nunll(){
//		String chaine=null;
//		String prefix="";
//		assertEquals(prefix, RLE.get_prefix(chaine));
//	}
	
	@Test public void test_recette(){
		String chaine="AAAABBGGGGGCCCDDDDDE";
		String encoded="4A2B5G3C5D1E";
		assertEquals(encoded, RLE.encode(chaine));
	}
	
}
