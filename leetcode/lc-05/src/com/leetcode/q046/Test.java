package com.leetcode.q046;

import java.util.ArrayList;

public class Test {
	private static void test(int[] A){
		Solution s = new Solution();
		
		ArrayList<ArrayList<Integer>> res = s.permuteUnique(A);
		
		for(ArrayList<Integer> x : res){
			System.out.print("{");
			for(Integer y: x){
				System.out.print(y.toString()+",");
			}
			System.out.println("}");
		}
		
		
	}
	
	public static void main(String[] argss) {
		test(new int[]{1,2,3});
		test(new int[]{1,2,1});
	}
}

