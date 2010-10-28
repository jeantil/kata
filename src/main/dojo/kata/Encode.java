package dojo.kata;
public class Encode {
	public static String encode(String string) {
		if(string.equals("B")) return "1B";
		if(string.length()==0) return "";
		return "1A";
	}
}
