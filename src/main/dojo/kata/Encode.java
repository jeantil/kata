package dojo.kata;
public class Encode {
	public static String rle(String string) {
		if(string.length()==0) return "";
		String accumulator="";
		accumulator=encode(getFirstRun(string));		
		if(string.length()> 1){
			string=string.replace(getFirstRun(string), "");			
			accumulator+=encode(getFirstRun(string));
			if(string.length()> 1){
				string=string.replace(getFirstRun(string), "");			
				accumulator+=encode(getFirstRun(string));	
			}
		}					
		return accumulator;
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
