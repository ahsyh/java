package com.leetcode.q009;

public class Test {
	static void test1(int ss){
		Solution s = new Solution();
		if(s.isPalindrome(ss))
			System.out.println("yes");
		else
			System.out.println("no");
	}

	public static void main(String[] args){
		test1(0);
		test1(1234);
		test1(121);
		test1(1221);
		test1(123331);
		return;
	}
}