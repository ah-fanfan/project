package bbs.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameUtil {
	public static  boolean validateName(String name) {
		return name.matches("^([\\u4e00-\\u9fa5]{1,4}|[a-zA-Z\\.\\s]{1,20})$");
}
	public static boolean phoneTest (String number){
	        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
	        if(number.length() != 11){
	            return false;
	        }else{
	            Pattern p = Pattern.compile(regex);
	            Matcher m = p.matcher(number);
	            return m.matches();
	        }
	    }
}