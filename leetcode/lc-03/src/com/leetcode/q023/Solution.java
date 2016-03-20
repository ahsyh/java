package com.leetcode.q023;

public class Solution {
	public ListNode swapPairs(ListNode head) {
		ListNode last, next, p1, p2;

		last = new ListNode(0);
		last.next = head;

		if(head==null)
		    return head;
		if(head.next!=null)
			head = head.next;

		while (true) {
			try {
				p1 = last.next;
				p2 = p1.next;
				next = p2.next;
			} catch (Exception e) {
				return head;
			}
			last.next = p2;
			p2.next = p1;
			p1.next = next;
			last = p1;
		}
	}
}