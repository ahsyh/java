package com.leetcode.q022;

import java.util.ArrayList;

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

	private static void test(int[] a,int[] b) {
		Solution s = new Solution();

		ListNode list1 = createList(a);
		ListNode list2 = createList(b);
		ArrayList<ListNode> para = new ArrayList<ListNode>();
		para.add(list1);
		para.add(list2);

		ListNode res = s.mergeKLists(para);
		while(res!=null){
			System.out.print("->"+res.val);
			res=res.next;
		}
	}

	private static void test1() {
		int[] a = new int[] { 1, 3, 5, 7 };
		int[] b = new int[] { 2, 4, 6 };
		test(a,b);
	}

	private static void test3() {
		int[] a = new int[] { 1 };
		int[] b = new int[] { 0 };
		test(a,b);
	}

	private static void test2() {
		Solution s = new Solution();

		ArrayList<ListNode> para = new ArrayList<ListNode>();

		ListNode res = s.mergeKLists(para);
		while(res!=null){
			System.out.print("->"+res.val);
			res=res.next;
		}
	}

	public static void main(String[] argss) {
		test1();
		test2();
		test3();
		return;
	}

}
