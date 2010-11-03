package dojo.kata;
public class Encode {
	public static String rle(String string) {
		if(string.length()==0) return "";
		if(string.length()==1) return encode(string);
		if(string.length()==2) return encode(string.substring(0,1))+encode(string.substring(1,2));
		if(string.length()==3) return encode(string.substring(0,2))+encode(string.substring(2,3));
		return "";
	}
	public static String encode(String string) {
		if(string.length()==0) return "";
		return ""+string.length()+string.charAt(0);
	}
	public static String getFirstRun(String string) {
		if(string.length()==0) return "";
		if(string.length()==1) return string;	
		int pos=0;		
		do 
			pos=pos+1;
		while (pos < string.length() && string.charAt(pos-1)==string.charAt(pos));		
		return string.substring(0,pos);
	}
}
