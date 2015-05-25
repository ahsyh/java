package com.leetcode.q030;

public class Test {
	private static void test(int[] num){
		Solution s = new Solution();
		s.nextPermutation(num);
		for(int i=0;i<num.length;i++){
			System.out.print(num[i]+" ");
		}
		System.out.println();
		
	}

	private static void test1(){
		int[] num = new int[]{1,2,3,4,5};
		test(num);
	}

	private static void test2(){
		int[] num = new int[]{5,4,3,2,1};
		test(num);
	}

	private static void test3(){
		int[] num = new int[]{4,5,1,2,3};
		test(num);
	}

	private static void test4(){
		int[] num = new int[]{4,5,3,2,1};
		test(num);
	}

	private static void test5(){
		int[] num = new int[]{1,5,4,3,2};
		test(num);
	}


	public static void main(String[] argss) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}
}
