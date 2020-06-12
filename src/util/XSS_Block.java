package util;

public class XSS_Block {
	public static String htmlEscape(String strVal){
		StringBuffer strResult=new StringBuffer();
		for(int i=0;i<strVal.length();i++){
			switch(strVal.charAt(i)){
			case '&' :
				 if (i + 1 <= strVal.length() && strVal.charAt(i + 1) == '#') {
	                    strResult.append('&');
	                } else {
	                    strResult.append("&amp;");
	                }
				break;
			case '<' :
				strResult.append("&lt;");
				break;
			case '>' :
				strResult.append("&gt;");
				break;
			default :
				strResult.append(strVal.charAt(i));
				break;
			}
		}
		return strResult.toString();
	}
}
