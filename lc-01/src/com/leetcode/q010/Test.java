package com.leetcode.q010;

public class Test {
	static void test1(String ss, String p){
		Solution s = new Solution();
		if(s.isMatch(ss,p))
			System.out.println("yes");
		else
			System.out.println("no");
	}

	public static void main(String[] args){
		test1("",".*c*");
		test1("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c");
		test1("aab","c*a*b");
		test1("ab",".*c");
		test1("aa","a");
		test1("aa","a*");
		test1("aa","c*a*b");
		test1("aa","c*a*b*");
		test1("aa",".a*b.c*");
		test1("abc","abcd*e*f*");
		return;
	}
}
