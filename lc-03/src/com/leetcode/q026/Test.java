package com.leetcode.q026;

public class Test {
	private static void test(int[] a,int k){
		Solution s=new Solution();
		
		int d = s.removeElement(a, k);
		for(int i=0;i<d;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	private static void test1(){
		int[] a = new int[]{1,1,2};
		test(a,1);
	}
	
	private static void test2(){
		int[] a = new int[]{1,2,3,2,4};
		test(a,2);
	}
	
	public static void main(String[] argss) {
		test1();
		test2();
	}

}
