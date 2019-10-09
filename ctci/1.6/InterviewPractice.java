package interview;

import java.util.HashSet;
import java.util.Iterator;

public class InterviewPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strOrg= "aabbcc";
	
		

		
		
		System.out.println(stringCompression(strOrg));
	
		System.out.println(String.valueOf(56).length());
	}
	public static String stringCompression(String org){
		
		org=org.toLowerCase();
		StringBuilder compressed=new StringBuilder();
		int count=0;
		
		for (int i = 0; i < org.length(); i++) {
			count++;
//			if(i+1 !=org.length()) {
				if(i+1 >=org.length()||org.charAt(i)!=org.charAt(i+1)) {
					compressed.append(org.charAt(i));
					compressed.append(String.valueOf(count));
					count=0;
				}
			//}
//			else {
//				compressed.append(org.charAt(i));
//				compressed.append(String.valueOf(count));
//				count=0;
//			}
					
		}
		if(compressed.length()>org.length())
			return org;
		
		return compressed.toString();
	
	}

}
