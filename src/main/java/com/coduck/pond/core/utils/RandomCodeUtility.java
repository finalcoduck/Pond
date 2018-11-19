package com.coduck.pond.core.utils;

import java.util.Random;

public class RandomCodeUtility {
	//65~90
	//97~122
	
	public static String makeRandomCode() {
		Random rnd = new Random();
		String randomCode = "";
		for (int i = 0; i < 20; i++) {
			if(rnd.nextBoolean()) {
				randomCode += String.valueOf(rnd.nextInt(10));
			}else {
				if(rnd.nextBoolean()) {
					char lower = (char)(((int)rnd.nextInt(26))+97);
					randomCode += lower;
				}else {
					char upper = (char)(((int)rnd.nextInt(26))+65);
					randomCode += upper;
				}
			}
		}
		return randomCode;
	}
	
	public static String makeRandomCode(int length) {
		Random rnd = new Random();
		String randomCode = "";
		for (int i = 0; i < length; i++) {
			if(rnd.nextBoolean()) {
				randomCode += String.valueOf(rnd.nextInt(10));
			}else {
				if(rnd.nextBoolean()) {
					char lower = (char)(((int)rnd.nextInt(26))+97);
					randomCode += lower;
				}else {
					char upper = (char)(((int)rnd.nextInt(26))+65);
					randomCode += upper;
				}
			}
		}
		return randomCode;
	}
	
}
