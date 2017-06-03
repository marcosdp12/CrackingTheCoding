package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class questions {
	/* Given an array containing all the numbers from
	 * 1 to n except two, find two missing numbers 
	 */
	public static int[] missingTwo(int [] arr){
		long totalSum = 0;
		for(int i = 1; i <= arr.length + 2; i++)
			totalSum = totalSum+i;
		for(int i:arr){
			totalSum = totalSum-i;
		}
		long aux = totalSum/2;
		//System.out.println("Aqui: " + aux);
		int xorV1 = 0;
		int xorV2 = 0;
		for(int i: arr){
			if(i <= aux)
				xorV1 = xorV1^i; 
			else xorV2 = xorV2^i;
		}
		int xorT1 = 0;
		int xorT2 = 0;
		for(int i = 1;i <= arr.length + 2; i++){
			if(i <= aux)
				xorT1 = xorT1^i; 
			else xorT2 = xorT2^i;
		}
		int ans [] = new int [2];
		ans[0]=xorT1^xorV1;
		ans[1]=xorT2^xorV2;
		return ans;
	}
	
	/* 
	 * 
	 */
	public static int [] duplicatesMyWay(int[] v){
		HashSet<Integer> seen = new HashSet<Integer>();
		HashSet<Integer> duplicated = new HashSet<Integer>();
		for(int i = 0; i < v.length; i++){
			if(seen.contains(v[i])) duplicated.add(v[i]);
			else seen.add(v[i]);
		}
		
		int ans [] = new int [duplicated.size()];
		int i = 0;
		for(int number: duplicated){
			ans[i]=number;
			i++;
		}
		return ans;
	}
	
	public static List<Integer> findAllDuplicates(int [] arr){
		if(arr == null) return null;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < arr.length; i++){
			if(arr[Math.abs(arr[i])-1]<0){
				if(!list.contains(Math.abs(arr[i])))
						list.add(Math.abs(arr[i]));
			}
			else arr[Math.abs(arr[i])-1]= arr[Math.abs(arr[i])-1]*(-1);			
		}
		return list;
	}
	
	
	/*Given an unsorted array, find the length of the longest sequence of consecutive numbers in 
	 * the array 
	 * eg. consecutive([4,2,1,6,5]) = 3 [4,5,6]
	 */
	public int consecutive(int[] a){
		HashSet<Integer> values = new HashSet<Integer>();
		for(int i:a){
			values.add(i);
		}
		
		int max=0;
		for(int i: values){
			if(values.contains(i-1)) continue;
			int length = 0;
			while(values.contains(i++)) length++;
			max = Math.max(max, length);
		}
		return max;
	}
	
	/*Given an n*m array where all rows and columns are in sorted order, write a function to
	 * determine whether the array contains an element x.
	 */
	public boolean contains(int[][]arr, int x){
		if(arr.length == 0 || arr[0].length == 0) return false;
		
		int row = 0;
		int col = arr.length-1;
		
		while(row < arr[0].length && col >= 0){
			if(arr[row][col]==x) return true;
			if(arr[row][col]<x) row++;
			else col--;
		}
		return false;
	}
	
	/*Given an array, write a function to find any subarray that sums zero, if one exists.*/
	public static void merge(int[]A, int[]B){
		int pa = 0;
		int pb = B.length-1;
		
		for(int i = A.length - 1; i>=0; i--){
			if(A[i] != 0){
				pa = i;
				break;
			}
		}
		
		int index = A.length-1;
		while(index > -1){
			if(pb < 0) break;
			else if(pa < 0) {
				A[index] = B[pb];
				pb--;
				index--;
			}
			else if(A[pa]>=B[pb]){
				A[index] = A[pa];
				index--;
				pa--;
			}
			else{
				A[index] = B[pb];
				pb--;
				index--;
			}
		}
	}
	
	/*Given two integers, determine wheter or not they differ by a single bit.*/	
	public boolean gray(int a, int b){
		int x = a^b;
		if((x & (x-1)) == 0)
			return true;
		else return false;
	}
	
	public static void swapIntegers(int a, int b){
		for(int i = 0; i<32; i++){
			int bita = a&1;
			int bitb = b&1;
			a=a>>1;
			b=b>>1;
			if(bita==1) b = b|0b10000000000000000000000000000000;
			if(bitb==1) a = a|0b10000000000000000000000000000000;
		}
		System.out.println("a = "+ a);
		System.out.println("b = "+ b);
		/*a = a ^ b;
		b = a ^ b;
		a = a ^ b;*/
		
	}
	
	public static String romanToNumeral(int num){
		String codes [] = {"I","IV","V","IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
		int vector [] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
		
		String roman = "";
		int i = 12;
		while(num>0){
			while(vector[i] > num)
				i--;
			roman = roman + codes[i];
			num = num - vector[i];
		}
		return roman;
	}
	
	public static void main(String[] args) {
		
		//System.out.println(questions.romanToNumeral(3));
		int A [][] = {{1, 2, 3}, {4 ,5,6}, {7,8,9}};
		//System.out.println(A[0][1]);
		//System.out.println(A[1][1]);
		//System.out.println(A[2][1]);
		
		for(int i = 0; i < 3; i++ )
			for(int j = 0; j < 3; j++){
				System.out.print(A[i][j] + " ");
				if(j==2) System.out.println();
			}
				
		/*int [] B = {1, 1, 1};
		
		questions.merge(A, B);
		
		for(int i=0; i<A.length;i++){
			System.out.print(A[i] + " ");
		}
		//int a=32;
		//int b=45;
		//int B [] = questions.duplicatesMyWay(A);
		//for(int i=0; i<B.length;i++){
			//System.out.print(B[i] + " ");
		//}
		
		List<Integer> B1 = questions.findAllDuplicates(A);
		for(int i: B1){
			System.out.print(i + " ");
		}
		
		//System.out.println("a = "+ a);
		//System.out.println("b = "+ b);
		//questions.swapIntegers(a, b);*/
		
		/*
		//missingTwo()
		int A [] = {4, 2, 3, 5, 6};
		int B [] = questions.missingTwo(A);
		System.out.print(B[0] + " ");
		System.out.print(B[1]);*/
		
	}
}
