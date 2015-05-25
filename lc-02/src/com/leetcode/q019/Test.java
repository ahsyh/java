package com.leetcode.q019;

public class Test {
	static void test1(){
		Solution s = new Solution();
		ListNode h = new ListNode(1);
		h.next = new ListNode(2);
		
		System.out.println(s.removeNthFromEnd(h, 1) .toString());
	}

	public static void main(String[] args){
		test1();
		return;
	}
}