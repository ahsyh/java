package com.leetcode.q050;

import java.util.ArrayList;

public class Test {
	
	private static void test(int n){
		Solution s = new Solution();
		
		ArrayList<String[]> res = s.solveNQueens(n);
		System.out.println("result of "+n);
		for(String[] one: res){
			System.out.println("{");
			for(String s1:one){
				System.out.println(s1);
			}
			System.out.println("}");
		}
	}
	
	public static void main(String[] argss) {
		test(2);
		test(3);
		test(4);
		test(5);
	}
}