package com.leetcode.q040;

public class Test {
	private static void test(int[] can){
		Solution s1 = new Solution();
		
		System.out.println( s1.firstMissingPositive(can));	
	}

	public static void main(String[] argss) {
		test(new int[]{1,2,0});
		test(new int[]{3,4,-1,1});
	}
}

