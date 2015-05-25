package com.leetcode.q004;



public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        
        ListNode head=null;
        
        if(l1==null&&l2==null)
        	return null;
        
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode tail=null;
        while(true){
        	ListNode p=new ListNode(0);
        	if(tail!=null)
        		tail.next = p;
        	tail = p;
        	if(head==null)
        		head = p;
        	int a=0;
        	int b=0;
        	if(p1!=null){
        		a=p1.val;
        		p1=p1.next;
        	}
        	if(p2!=null){
        		b=p2.val;
        		p2=p2.next;
        	}
        	p.val = carry + a + b;
        	carry = p.val / 10;
        	p.val %= 10;
        	if(p1==null&&p2==null&&carry==0)
        		break;
        }
        
        return head;
    }
}
