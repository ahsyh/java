package com.leetcode.q036;

import java.util.ArrayList;

public class Solution {
	class Node{
		int x,y;
		public ArrayList<Integer> candidate;
		
		public Node(int in_x,int in_y){
			x=in_x;y=in_y;
			candidate = new ArrayList<Integer>();
		}
		
		public void add(int i){
			candidate.add(i);
		}
		
		public int size(){
			return candidate.size();
		}
	}
	
	private int getBase(int i){
		return (i/3)*3;
	}

	private boolean getCandidateList(char[][] board,Node node){
        boolean[] used = new boolean[10];

        for(int k=0;k<10;k++){
			used[k]=false;
		}
		
        // row
        for(int k=0;k<9;k++){
        	if(board[node.x][k]!='.'){
        		int val = board[node.x][k]-'0';
        		used[val]=true;
        	}
        	if(board[k][node.y]!='.'){
        		int val = board[k][node.y]-'0';
        		used[val]=true;
        	}
        }
        
        int x = getBase(node.x);
        int y = getBase(node.y);
        
        for(int i=0;i<3;i++){
        	for(int j=0;j<3;j++){
        		if(node.x==(x+i)||node.y==(y+j))
        			continue;
            	if(board[x+i][y+j]!='.'){
            		int val = board[x+i][y+j]-'0';
            		used[val]=true;
            	}
        	}
        }
        
        for(int k=1;k<10;k++){
			if(used[k]==false){
				node.add(k);
			}
		}

        if(node.size()==0)
        	return false;

        return true;
	}

	private boolean isValid(char[][] board, int x, int y){
		char val = board[x][y];
		int  count = 0;
		
        // row
        for(int k=0;k<9;k++){
        	if(board[x][k]==val){
        		count ++;
        	}
        	if(board[k][y]==val){
        		count ++;
        	}
        }
        
        int xBase = getBase(x);
        int yBase = getBase(y);
        
        for(int i=0;i<3;i++){
        	for(int j=0;j<3;j++){
            	if(board[xBase+i][yBase+j]==val){
            		count ++;
            	}
        	}
        }
        
        if(count==3)
        	return true;
        else
        	return false;
	}

	public void solveSudoku(char[][] board) {
        int row = board.length;
        if(row == 0 )
        	return;
        
        int col = board[0].length;
        if(col==0)
        	return;
        
        ArrayList<Node> nodeList = new ArrayList<Node>();
        
        for(int i=0;i<row;i++){
        	for(int j=0;j<col;j++){
        		if(board[i][j] != '.'){
        			continue;
        		}
        		
        		Node n=new Node(i,j);
        		if(getCandidateList(board,n)==false)
        			return;
        		nodeList.add(n);
        	}
        }
        
        int num = nodeList.size();
        int[] select = new int[num+1];
        int curr = 0;
        select[0]=0;
        while(curr>=0){
        	if(curr>=num){
        		//find one result
        		return;
        	}
        	
        	if(curr<0){
        		//there is no result
        		return;
        	}
        	
        	if(select[curr]>=nodeList.get(curr).size()){
        		select[curr]=0;
        		board[nodeList.get(curr).x][nodeList.get(curr).y] = '.';
        		curr --;
        		if(curr>=0)
        			select[curr]++;
        		continue;
        	}
        	
        	int val = nodeList.get(curr).candidate.get(select[curr]);
        	board[nodeList.get(curr).x][nodeList.get(curr).y] = Integer.toString(val).charAt(0);
        	if(isValid(board,nodeList.get(curr).x, nodeList.get(curr).y))
        	{
        		curr++;
        		select[curr]=0;
        		continue;
        	}
        	else
        	{
        		select[curr]++;
        	}
        }
        
    }
}
