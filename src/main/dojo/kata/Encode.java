package dojo.kata;
public class Encode {
	public static String encode(String string) {
		if(string.length()==0) return "";
		return ""+string.length()+string.charAt(0);
	}
	public static String getFirstRun(String string) {
		return "";
	}
}
