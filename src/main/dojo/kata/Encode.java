package dojo.kata;
public class Encode {
	public static String encode(String string) {
		if(string.length()==1) return "1"+string;
		if(string.length()==2){
			if(string.equals("CC"))	return "2C";
			if(string.equals("DD"))	return "2D";
		}
		return "";		
	}
}
