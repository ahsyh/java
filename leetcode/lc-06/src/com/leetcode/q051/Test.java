package com.leetcode.q051;

public class Test {
	
	private static void test(int n){
		Solution s = new Solution();
		
		int res = s.totalNQueens(n);
		System.out.println("result of "+n +" is " + res);
	}
	
	public static void main(String[] argss) {
		test(2);
		test(3);
		test(4);
		test(5);
	}
}
