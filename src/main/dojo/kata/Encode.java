package dojo.kata;
public class Encode {
	public static String encode(String string) {
		if(string.length()==1) return "1"+string;
		if(string.length()==2) return "2"+string.charAt(0);
		return "";		
	}
}
