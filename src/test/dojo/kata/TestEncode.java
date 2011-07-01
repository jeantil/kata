package dojo.kata;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;


public class TestEncode{
	@Test public void testtruth(){
		assertTrue(true);
	}
	
	@Test
	public void testUnElement() {
		List<Byte> list = new ArrayList<Byte>();
		list.add(new Byte((byte) 255));
		Result result = Encode.compress(list);
		Result expected = new Result();
		expected.setDictionnary(Arrays.asList(new Byte[]{(byte) 255}));
		expected.setOutput(Arrays.asList(new Byte[]{(byte)0}));
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testUnAutreElement() {
		List<Byte> list = new ArrayList<Byte>();
		list.add(new Byte((byte) 64));
		Result result = Encode.compress(list);
		Result expected = new Result();
		expected.setDictionnary(Arrays.asList(new Byte[]{(byte) 64}));
		expected.setOutput(Arrays.asList(new Byte[]{(byte)0}));
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testDeuxElements() {
		List<Byte> list = new ArrayList<Byte>();
		list.add(new Byte((byte) 64));
		list.add(new Byte((byte) 64));
		Result result = Encode.compress(list);
		Result expected = new Result();
		expected.setDictionnary(Arrays.asList(new Byte[]{(byte) 64}));
		expected.setOutput(Arrays.asList(new Byte[]{(byte)0,(byte)0}));
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testDeuxElementsDifferents() {
		List<Byte> list = new ArrayList<Byte>();
		list.add(new Byte((byte) 64));
		list.add(new Byte((byte) 5));
		Result result = Encode.compress(list);
		Result expected = new Result();
		expected.setDictionnary(Arrays.asList(new Byte[]{(byte) 64,(byte)5}));
		expected.setOutput(Arrays.asList(new Byte[]{(byte)0,(byte)1}));
		Assert.assertEquals(expected, result);
	}
}
