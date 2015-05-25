package com.leetcode.q006;

public class Test {
	static void test1(String ss, int n){
		Solution s = new Solution();
		System.out.println(s.convert(ss,n));
	}

	public static void main(String[] args){
		test1("PAYPALISHIRING",3);
		test1("A",1);
		return;
	}
}

