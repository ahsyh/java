package com.leetcode.q041;

public class Test {
	private static void test(int[] can){
		Solution s1 = new Solution();
		
		System.out.println( s1.trap(can));	
	}

	public static void main(String[] argss) {
		test(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
	}
}
