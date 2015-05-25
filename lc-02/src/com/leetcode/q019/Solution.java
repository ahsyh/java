package com.leetcode.q019;

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p1, p2, p3;
		p1=p2=p3=null;
		try {
			p1 = head;
			for (int i = 0; i < n; i++) {
				p1 = p1.next;
			}
			p2 = head;
			p1 = p1.next;
			p2 = p2.next;
			p3 = head;
		} catch (Exception e) {
			if(p2==null)
				return null;
			else
				return p2.next;
		}
		
		while(p1!=null){
			p1=p1.next;
			p3=p3.next;
		}

	    p3.next=p3.next.next;

		return head;
	}
}