package com.leetcode.q032;

public class Test {
	private static void test(int[] a, int t){
		Solution s1 = new Solution();
		System.out.println(s1.search(a, t));
		
	}

	private static void test1(){
		int[] a = new int[]{4, 5, 6, 7, 0, 1, 2};
		int t = 3;
		test(a,t);
	}

	private static void test2(){
		int[] a = new int[]{4, 5, 6, 7, 0, 1, 2};
		int t = 5;
		test(a,t);
	}

	private static void test3(){
		int[] a = new int[]{4, 5, 6, 7, 0, 1, 2};
		int t = 0;
		test(a,t);
	}

	private static void test4(){
		int[] a = new int[]{4, 5, 6, 7, 0, 1, 2};
		int t = 1;
		test(a,t);
	}

	private static void test5(){
		int[] a = new int[]{4, 5, 6, 7, 0, 1, 2};
		int t = 2;
		test(a,t);
	}

	private static void test6(){
		int[] a = new int[]{150,151,152,156,158,159,160,161,162,167,169,170,171,177,180,183,184,186,189,191,197,200,203,205,210,215,216,219,221,222,233,236,237,238,239,246,247,250,254,257,260,261,262,269,275,279,283,284,286,287,288,289,290,294,295,298,1,5,6,9,10,13,15,16,20,25,27,28,34,37,41,42,43,46,48,51,53,54,59,61,65,67,72,76,78,79,81,83,85,91,92,94,95,102,103,105,106,111,113,118,120,122,123,126,141,148};
		int t = 47;
		test(a,t);
	}

	public static void main(String[] argss) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}
}
