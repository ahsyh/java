package com.leetcode.q042;

public class Test {
	private static void test(String s1, String s2){
		Solution s = new Solution();
		
		System.out.println( s.multiply(s1, s2) );	
	}

	public static void main(String[] argss) {
		test("123","45");
		test("123456789","345678900");
		test("123456789","0");
	}
}
