package dojo.kata;
public class Encode {
	public static String encode(String string) {
		if(string.length()==0) return "";
		return ""+string.length()+string.charAt(0);
	}
	public static String getFirstRun(String string) {
		if(string.length()==0) return "";
		if(string.length()>=3 && string.charAt(0)==string.charAt(1) && string.charAt(0)==string.charAt(2))return string.substring(0,3);
		if(string.length()>=2 && string.charAt(0)==string.charAt(1))return string.substring(0,2);
		return string.substring(0,1);
	}
}
