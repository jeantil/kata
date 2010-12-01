package dojo.kata;

public class RLE {

	public static String encode(String chaine) {

		if (chaine == null || chaine.isEmpty())
			return "";
		if(chaine.length()==1)return encodeUnit(chaine);
		
		String prefix="";
		int i=0;
		do {
			prefix+=chaine.charAt(i); 
			i++;
		} while (i<chaine.length()&& chaine.charAt(i-1)==chaine.charAt(i));
		if(i<chaine.length()&&chaine.charAt(i-1)!=chaine.charAt(i)){
			return encodeUnit(prefix)+encode(chaine.substring(prefix.length()));
		}
		
		return encodeUnit(chaine);
	}

	private static String encodeUnit(String chaine) {
		return "" + chaine.length() + chaine.charAt(0);
	}

}
