package com.leetcode.q002;

import com.leetcode.q002.Solution;

public class Test {
	static void test1(){
		int[] A=new int[]{1};
		int[] B=new int[]{2,3,4};
		Solution s = new Solution();
		double d = s.findMedianSortedArrays(A, B);
		System.out.println(d);
	}

	static void test2(){
		
	}

	public static void main(String[] args){
		test1();
		test2();
		return;
	}
}