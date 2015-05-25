package com.leetcode.q036;

public class Test {
	private static void test(char[][] board){
		Solution s1 = new Solution();
		s1.solveSudoku(board);
	}

	private static void test1(){
		char[][] a = new char[9][9];

		a[0] =  "..9748...".toCharArray();
		a[1] =  "7........".toCharArray();
		a[2] =  ".2.1.9...".toCharArray();
		a[3] =  "..7...24.".toCharArray();
		a[4] =  ".64.1.59.".toCharArray();
		a[5] =  ".98...3..".toCharArray();
		a[6] =  "...8.3.2.".toCharArray();
		a[7] =  "........6".toCharArray();
		a[8] =  "...2759..".toCharArray();
		
		test(a);
	}

	public static void main(String[] argss) {
		test1();
	}
}
