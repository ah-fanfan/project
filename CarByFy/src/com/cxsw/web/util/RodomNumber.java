package com.cxsw.web.util;

import java.util.Random;

public class RodomNumber {
	
	public static String getStaffNum(){
		String val = "S";
		Random random = new Random();
		for (int i = 0; i < 11; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return val;
	}
	
	public static String getEmpNum(){
		String val = "E";
		Random random = new Random();
		for (int i = 0; i < 11; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return val;
	}
	 public static String getCarNum(){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<17;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
	 public static String getStaffPsw(){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<6;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
	 public static String getCustomerNum(){
			String val = "C";
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
				val += String.valueOf(random.nextInt(10));
			}
			return val;
		}
	 public static String getCustomerPsw(){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<6;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
	 public static String getOrderNum(){
			String val = "O";
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
				val += String.valueOf(random.nextInt(10));
			}
			return val;
		}
	 public static String getTestNum(){
			String val = "Test";
			Random random = new Random();
			for (int i = 0; i < 8; i++) {
				val += String.valueOf(random.nextInt(10));
			}
			return val;
		}
}
