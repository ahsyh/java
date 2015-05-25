package com.leetcode.q022;

import java.util.ArrayList;
import java.util.*;

public class Solution {
	class ItemComparator implements Comparator<ListNode> {
		public int compare(ListNode a, ListNode b) {
			if (a.val > b.val)
				return 1;
			else if (a.val < b.val)
				return -1;
			else
				return 0;
		}
	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if(lists==null)
			return null;
		
		ListNode head = null;
		ListNode tail = null;
		ListNode curr = null;
		
		if(lists.size()<=0)
			return null;

		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new ItemComparator());

		for (int i = 0; i < lists.size(); i++) {
			if(lists.get(i)!=null)
				heap.add(lists.get(i));
		}
		
		while(!heap.isEmpty()){
			curr = heap.remove();
			if(head==null){
				head=curr;
				tail=curr;
			}
			else{
				tail.next=curr;
				tail=curr;
			}
			if(curr.next!=null){
				heap.add(curr.next);
				curr.next=null;
			}
		}

		return head;
	}
}