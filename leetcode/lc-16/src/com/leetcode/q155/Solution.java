package com.leetcode.q155;

import java.util.LinkedList;

class MinStack {
	
	private class node{
		public int val = 0;
		public int min = 0;
		
		public node(int v, int m){
			val = v;
			min = m;
		}
	}

	private LinkedList<node> list = new LinkedList<node>();
	
    public void push(int x) {
    	int min = x;
    	try{
    		node n = list.getLast();
    		if(n.min < min)
    			min = n.min;
    	}
    	catch(Exception e){
    		
    	}

       	list.add(new node(x, min));
    }

    public void pop() {
        try{
        	list.removeLast();
        }
        catch(Exception e){
        	
        }
    }

    public int top() {
        int res = -1;
        
        try{
        	node n = list.getLast();
        	res = n.val;
        }
        catch(Exception e){
        	
        }
        
        return res;
    }

    public int getMin() {
        int min = -1;
        
        try{
        	node n = list.getLast();
        	min = n.min;
        }
        catch(Exception e){
        	
        }
        
        return min;
    }
}
