package com.leetcode.q024;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head==null)
    		return null;

    	ListNode last,next;
    	ListNode[] p = new ListNode[k];
    	last = new ListNode(0);
    	last.next = head;
    	
    	try{
    		for(int i=1;i<k;i++){
    			head = head.next;
    		}
    	}
    	catch(Exception e){
    		return last.next;
    	}
    	
    	while(true){
    		try{
    			next = last.next;
    			for(int i=0;i<k;i++){
    				p[i]=next;
    				next=next.next;
    			}
    		}
        	catch(Exception e){
        		return head;
        	}
    		last.next=p[k-1];
    		p[0].next=next;
    		for(int i=1;i<k;i++){
    			p[i].next=p[i-1];
    		}
    		last=p[0];
    	}
    }
}
