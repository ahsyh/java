package com.leetcode.q044;


public class Test {
	private static void test(int[] A){
		Solution s = new Solution();
		
		System.out.println(s.jump(A));
		
	}
	
	public static void main(String[] argss) {
		test(new int[]{2,3,1,1,4});
		test(new int[]{2,1});
	}
}

