package com.leetcode.q025;

public class Test {
	private static void test(int[] a){
		Solution s=new Solution();
		
		int d = s.removeDuplicates(a);
		for(int i=0;i<d;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	private static void test1(){
		int[] a = new int[]{1,1,2};
		test(a);
	}
	
	public static void main(String[] argss) {
		test1();
	}

}
