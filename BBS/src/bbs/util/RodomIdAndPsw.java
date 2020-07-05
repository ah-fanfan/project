package bbs.util;

import java.util.Random;

public class RodomIdAndPsw {
	
	public static String getId(){
		String val = "";
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return val;
	}
	 public static String getPsw(){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<6;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
}
