package Test;

import java.util.HashSet;

public class TestJava {

	public static void main(String[] args) {
		/*
		 * Cracking the coding interview solution to problem 1.1: is unique
		 * 

		System.out.println(isUnique(s1));
		System.out.println(isUnique(s2));
		*/
		String s1 = "character";
		String s2 = "sarmen";
		long millis1 = System.nanoTime();
		System.out.println(isUnique(s1));
		System.out.println(isUnique(s2));
		long millis2 = System.nanoTime() - millis1;
		System.out.println(millis2);
		
		long millis3 = System.nanoTime();
		System.out.println(isUniqueChars(s1));
		System.out.println(isUniqueChars(s2));
		long millis4 = System.nanoTime() - millis3;
		System.out.println(millis4);

	}
	
	public static boolean isUnique(String s) {
		HashSet<Character> characters = new HashSet<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			
			if(!characters.contains(s.charAt(i)))
					characters.add(s.charAt(i));
			else
				return false;
				
		}
		return true;
		
	}
	
	public static boolean isUniqueChars(String str) {
		 if (str.length() > 128) return false;
		
		 boolean[] char_set = new boolean[128];
		 for (int i = 0; i < str.length(); i++) {
			 int val = str.charAt(i);
			 if (char_set[val]) {// Already found this char in string
				 return false;
				 }
				 	char_set[val] = true;
				 }
			 return true;
		 }
	

}
