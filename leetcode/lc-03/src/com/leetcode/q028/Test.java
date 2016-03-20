package com.leetcode.q028;

public class Test {
	private static void test(int a, int b){
		Solution s = new Solution();
		
		System.out.println(s.divide(a, b));
	}
	
	public static void main(String[] args){
		test(12345,43);
		test(12345,-43);
		test(2147483647,1);
		test(-1010369383, -2147483648);

	}

}
