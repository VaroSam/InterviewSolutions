/**
 * Cracking the coding interview solution to problem 1.5: One Edit Away	
 * 
 **/

package Test;

public class TestJava {

	public static void main(String[] args) {

		String strOrg= "pale";
		String str2= "pales";
		String str3= "ple";
		String str4= "bale";
		String str5= "bae";
		String str6= "lape";
		
		long millis1 = System.nanoTime();
		System.out.println(oneEditAway1(strOrg,str2));
		System.out.println(oneEditAway1(strOrg,str3));
		System.out.println(oneEditAway1(strOrg,str4));
		System.out.println(oneEditAway1(strOrg,str5));
		System.out.println(oneEditAway1(strOrg,str6));
		long millis2 = System.nanoTime() - millis1;
		System.out.println(millis2);
		
		long millis3 = System.nanoTime();
		System.out.println(oneEditAway2(strOrg,str2));
		System.out.println(oneEditAway2(strOrg,str3));
		System.out.println(oneEditAway2(strOrg,str4));
		System.out.println(oneEditAway2(strOrg,str5));
		System.out.println(oneEditAway2(strOrg,str6));
		long millis4 = System.nanoTime() - millis3;
		System.out.println(millis4);
	}
	
	/*
	 * Our Solution
	 */
	public static boolean oneEditAway1(String Org, String str2) {
		
		int count=0;
		if(Org.equals(str2)) {
			return true;
		}else{
			for (int i = 0; i < Org.length(); i++) {
				if(str2.contains(""+Org.charAt(i)+""))
					count++;
			}
			
			if(count==Org.length()-1 || count==Org.length()) return true;
		}
		return false;
	}
	
	/*
	 * Gayle's Solution: this is the solution where she has a separate method
	 * for replace and a separate method called oneEditInsert for both
	 * insertion and removal checks.
	 */
	public static boolean oneEditAway(String first, String second) {
		if (first.length() == second.length()) {
			return oneEditReplace(first, second);
		} else if (first.length() + 1 == second.length()) {
			return oneEditInsert(first, second);
		} else if (first.length() - 1 == second.length()) {
			return oneEditInsert(second, first);
		}
		return false;
	}

	public static boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference = false;
		for ( int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundDifference) {
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}

	/* Check if you can insert a character into s1 to make s2. */
	public static boolean oneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	
	
	/*
	 * Gayle's Solution: this is the solution where she combines all three
	 * checking operations of replace, removal and missing, are done together.
	 */
	public static boolean oneEditAway2(String first, String second) {
		/* Length checks. */
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		/* Get shorter and longer string.*/ 
		// She is actually making sure shorter string is first and the longer string is second.
		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;
		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;	
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				/*Ensure that this is the first difference found. */
				if (foundDifference) 
					return false;
				foundDifference = true;
				if (s1.length() == s2.length()) { //On replace, move shorter pointer
					index1++;
				}
			} else {
				index1++; // If matching, move shorter pointer
			}
				index2++; // Always move pointer for longer string
		}
		return true;
	}
}
