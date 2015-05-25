
package com.leetcode.q052;

public class Test {
	
	private static void test(int[] n){
		Solution s = new Solution();
		
		int res = s.maxSubArray(n);
		System.out.println("result of is " + res);
	}
	
	public static void main(String[] argss) {
		test(new int[]{-2,1});
	}
}
