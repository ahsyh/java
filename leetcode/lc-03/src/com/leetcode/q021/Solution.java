package com.leetcode.q021;

import java.util.ArrayList;

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        StringBuffer oneResult = new StringBuffer();

        int lNum=0;
        int rNum=0;
        
        for(int i=0;i<2*n;i++){
        	oneResult.append(' ');
        }
        recurr(n,lNum,rNum,oneResult, result);
        
        return result;
    }

    void recurr(int n, int lNum, int rNum,StringBuffer oneResult, ArrayList<String> result){
    	int pos = lNum + rNum;
    	
    	if(pos==2*n){
    		result.add(oneResult.toString());
    		return;
    	}
    	if(lNum<=rNum){
    		if(lNum<n){
        		oneResult.setCharAt(pos, '(');
        		recurr(n,lNum+1,rNum,oneResult,result);
    		}
    	}
    	else{
    		
    		if(lNum<n){
        		oneResult.setCharAt(pos, '(');
        		recurr(n,lNum+1,rNum,oneResult,result);
    		}
    		oneResult.setCharAt(pos, ')');
    		recurr(n,lNum,rNum+1,oneResult,result);
    	}
    }

}

