package com.leetcode.q023;

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

	private static void test(int[] a) {
		Solution s = new Solution();

		ListNode list1 = createList(a);

		ListNode res = s.swapPairs(list1);
		while(res!=null){
			System.out.print("->"+res.val);
			res=res.next;
		}
	}

	private static void test1() {
		int[] a = new int[] { 1, 2, 3 };
		test(a);
	}


	public static void main(String[] argss) {
		test1();
		return;
	}

}
