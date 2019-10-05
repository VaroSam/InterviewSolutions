package Test;

import java.util.HashSet;

public class TestJava {

	public static void main(String[] args) {
		/*
		 * Cracking the coding interview solution to problem 1.2: permutation
		 * 
		 */
		String s1 = "mensar";
		String s2 = "sarmen";
		String s3 = "varoojan";
		String s4 = "varoojik";
		
		long millis3 = System.nanoTime();
		System.out.println(perm(s1,s2));
		System.out.println(perm(s3,s4));
		long millis4 = System.nanoTime() - millis3;
		System.out.println(millis4);

		long millis1 = System.nanoTime();
		System.out.println(permutation(s1, s2));
		System.out.println(permutation(s3, s4));
		long millis2 = System.nanoTime() - millis1;
		System.out.println(millis2);
	}
	
	// our solution based on Gayle's solution of 1.1
	public static boolean perm(String str1,String str2) {
		
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str1.length(); i++) {
			int val = str1.charAt(i);
			char_set[val] = true;
		}
		for (int i = 0; i < str2.length(); i++) {
			int val = str2.charAt(i);
			if(!char_set[val])
				return false;
		}
		return true;
	}
	// Gayle's solution
	public static boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t)) ;
	}
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}


}
