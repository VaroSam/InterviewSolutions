package interview;

import java.util.HashSet;
import java.util.Iterator;

public class InterviewPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "eva, can i see bees in a cave?";
		char str[]=s.toLowerCase().toCharArray();
	
		
		
		System.out.println(palindromePermutation(str));
		
	}
	public static boolean palindromePermutation(char[] str1) {
		
		//we create an int array for each Ascii charachter[128]
		int letters[]=new int[128];
		int oddCount=0;
		
		//keep the count of each charachter in the array
		for (char i : str1) {
			letters[i]++;
		}
		//checking to make sure not more than 
		//one charachter count is odd
		//if YES: cannot be a palindrome permutation
		for (int  i : str1) {
			if(i<123 && i>96)
			 if(letters[i]%2 !=0)
				 if(oddCount>1)
					 return false;
				 else 
					 oddCount++;
		}
		return true;
		
	}

}
