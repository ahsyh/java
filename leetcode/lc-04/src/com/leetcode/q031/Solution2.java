package com.leetcode.q031;

//比较慢的动态规划
public class Solution2 {
  static boolean[][] d = new boolean[12500][12500];
  
  public int longestValidParentheses(String s) {
  	int length = s.length();
  	if(length==0)
  		return 0;

  	int longest=0;

  //	boolean[][] d = new boolean[length+1][length+1];
  	
  	for(int i=0;i<=length;i++){
  		for(int j=0;j<=length-i;j++){
  			if(i==0){
  				d[j][i]=true;
  				
  				if(i>longest){
  					longest=i;
  				}
  				continue;
  			}
  			
  			if(i%2==1){
  				d[j][i]=false;
  				continue;
  			}
  			
  			if(s.charAt(j)==')'||s.charAt(j+i-1)=='('){
  				d[j][i]=false;
  				continue;
  			}
  			
  			if(d[j+1][i-2]){
  				d[j][i]=true;
  				if(i>longest){
  					longest=i;
  				}
  				continue;
  			}
  			
  			boolean find=false;
  			for(int k=2;k<=i-2;k+=2){
  				if(d[j][k]&&d[j+k][i-k]){
      				d[j][i]=true;
      				if(i>longest){
      					longest=i;
      				}
      				find=true;
      				break;
  				}
  			}
  			if(find)
  				continue;

  			d[j][i]=false;
  		}
  	}
  	
   	return longest;
  }
}