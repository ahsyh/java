package com.leetcode.q037;

public class Test {
	private static void test(int n){
		Solution s1 = new Solution();
			System.out.println(s1.countAndSay(n));
					
	}

	public static void main(String[] argss) {
		for(int i=0;i<10;i++)
			test(i);
	}
}

