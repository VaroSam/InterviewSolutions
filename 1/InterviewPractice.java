package interview;

import java.util.HashSet;

public class InterviewPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int array1[] = {1,2,3,9};
		int array2[] = {1,2,4,4};
		int array3[] = {9,1,3,2};
		int array4[] = {4,2,4,1};
		final int SUM = 8;
		
		/*
		//solution 1: brute force, O(n)=n^2
		System.out.println(hasPairWithSum1(array1, SUM));
		System.out.println(hasPairWithSum1(array2, SUM));
		*/
		

		/*
		//solution 2: largest possible sum , O(n)=n
		// {1,2,3,9}
		// ^		^
		System.out.println(hasPairWithSum2(array1, SUM));
		System.out.println(hasPairWithSum2(array2, SUM));
		*/
		
		/*
		 * solution 3: Unsorted Array ,O(n)=n
		System.out.println(hasPairWithSum3(array3, SUM));
		System.out.println(hasPairWithSum3(array4, SUM));
		*/
	}
	public static boolean hasPairWithSum1(int a[], int sum) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i]+a[j]==8)
					return true;
			}
		}
		return false;
	}
	
	public static boolean hasPairWithSum2(int a[], int sum) {
		int max = a.length-1;
		int min = 0;
		
		while(min < max || min !=max) {
			if(a[max]+a[min]>sum) 
				max--;
			else if(a[max]+a[min]<sum)
				min++;
			else
				return true;
		}
		
		return false;
	}

	public static boolean hasPairWithSum3(int a[], int sum) {
	
		HashSet<Integer> comp= new HashSet<Integer>();
		
		
		for (int i = 0; i < a.length; i++) {
			if(!comp.contains(a[i]))
				comp.add(sum-a[i]);
			else
				return true;
				
		}
		return false;
		
	}

}
