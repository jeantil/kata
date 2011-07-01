package dojo.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Encode {

	public static Result compress(List<Byte> list) {
		Map<Byte,Integer> map = new HashMap<Byte, Integer>();
		for (Byte cbyte : list) {
			Integer integer = map.get(cbyte);
			map.put(cbyte, integer == null ? 1 : integer + 1);
		}
		Result result = new Result();
		Byte [] td = new Byte[list.size() + 1];
		for (Entry<Byte, Integer> entry : map.entrySet()) {
			td[entry.getValue()] = entry.getKey();
		}
		List<Byte> dictionnary = new ArrayList<Byte>();
		for (int i = 0; i < td.length; i++) {
			Byte cbyte = td[i];
			if (cbyte != null)
				dictionnary.add(cbyte);
		}
		Collections.reverse(dictionnary);
		result.setDictionnary(dictionnary);
		ArrayList<Byte> output = new ArrayList<Byte>();
		for (int i = 0; i < list.size(); i++) {
			output.add((byte)0);
		}
		result.setOutput(output);
		return result;
	}

}
