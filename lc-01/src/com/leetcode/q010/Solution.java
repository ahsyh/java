package com.leetcode.q010;

import java.util.ArrayList;

public class Solution {
	class PatternNode{
		public PatternNode(char ch, boolean hasstar){
			this.ch = ch;
			this.has_star = hasstar;
		}

		public char ch;
		public boolean has_star;
	}
	private boolean charMatch(char ch1, char ch2){
		if(ch2=='.')
			return true;
		else if(ch1==ch2)
			return true;
		else
			return false;
	}

	private boolean checkMatch(String s, int a, ArrayList<PatternNode> p, int b){

		if(a==s.length()&&b==p.size())
			return true;
		else if(b==p.size())
			return false;
		else if(a==s.length()){
			for(int i=b;i<p.size();i++){
				if(!p.get(i).has_star)
					return false;
			}
			return true;
		}
		
		char ch1, ch2;
		ch1 = s.charAt(a);
		ch2 = p.get(b).ch;

		if(p.get(b).has_star){
			if(charMatch(ch1,ch2)){
				return checkMatch(s,a+1,p,b+1)||checkMatch(s,a+1,p,b)||checkMatch(s,a,p,b+1); 
			}
			else{
				return checkMatch(s,a,p,b+1);
			}
		}
		else{
			if(charMatch(ch1,ch2)){
				return checkMatch(s,a+1,p,b+1);
			}
			else
				return false;
		}
		
//		return true;
	}
	
	ArrayList<PatternNode> createPattern(String p){
    	ArrayList<PatternNode> mp= new ArrayList<PatternNode>();
    	int i=0;
    	int j=0;
    	while(true){
    		char ch1 = p.charAt(i);
    		char ch2;

    		if((i+1)<p.length())
    		    ch2 = p.charAt(i+1);
    		else
    			ch2 = '$';

    		
    		if(ch2=='*'){
    			if(j>0&&mp.get(j-1).has_star&&mp.get(j-1).ch==ch1){
    				
    			}
    			else{
        			mp.add(new PatternNode(ch1,true));
        			j++;
    			}
    			i+=2;
    		}
    		else{
    			mp.add(new PatternNode(ch1,false));
    			i+=1;
    			j++;
    		}
    		
    		if(i>=p.length())
    			break;
    	}
    	return mp;
	}

	public boolean isMatch(String s, String p) {
    	if(s.length()==0&&p.length()==0)
    		return true;

    	if(p.length()==0)
    		return false;
    	
    	ArrayList<PatternNode> mp= createPattern(p);

    	if(s.length()==0){
			for(int i=0;i<mp.size();i++){
				if(!mp.get(i).has_star)
					return false;
			}
			return true;
    	}
    	
    	
        boolean res = true;
        
        res = checkMatch(s,0,mp,0);
        
        return res;
    }
}
