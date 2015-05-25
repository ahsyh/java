package com.leetcode.q049;

public class Test {
	
		private static void test(double x, int n){
			Solution s = new Solution();
			
			System.out.println(s.pow(x, n));
		}
		
		public static void main(String[] argss) {
			test(34.00515, -3);
			test(2,3);
			test(2,6);
		}
}
