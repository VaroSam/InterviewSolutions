package test;

public class TesterClass {

	public static void main(String[] args) {

		String strOrg= "pale";
		String str2= "pales";
		String str3= "ple";
		String str4= "bale";
		String str5= "bae";
		String str6= "lape";
		
//		System.out.println(str2.contains("s"));
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
	public static boolean oneEditAway1(String Org, String str2) {
		
		int count=0;
		
		if(Org.equals(str2)) {
			return true;
		}else{
			for (int i = 0; i < Org.length(); i++) {
				if(str2.contains(""+Org.charAt(i)+""))
					count++;
			}
			
			if(count==Org.length()-1 || count==Org.length())
				return true;
			
		}
		return false;
	
	}
	
	public static boolean oneEditAway2(String first, String second) {
		/* Length checks. */
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		/* Get shorter and longer string.*/
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
