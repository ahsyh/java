package com.leetcode.q024;

public class Test {

	static ListNode createList(int[] a) {
		ListNode head = null;
		ListNode tail = null;

		for (int i = 0; i < a.length; i++) {
			if (head == null) {
				head = new ListNode(a[i]);
				tail = head;
			} else {
				tail.next = new ListNode(a[i]);
				tail = tail.next;
			}
		}
		return head;
	}

	private static void test(int[] a,int k) {
		Solution s = new Solution();

		ListNode list1 = createList(a);

		ListNode res = s.reverseKGroup(list1, k);
		while(res!=null){
			System.out.print("->"+res.val);
			res=res.next;
		}
		System.out.println();
	}

	private static void test1() {
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		test(a,2);
	}

	private static void test2() {
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		test(a,3);
	}


	private static void test3() {
		int[] a = new int[] { 1 };
		test(a,2);
	}


	public static void main(String[] argss) {
		test1();
		test2();
		test3();
		return;
	}

}