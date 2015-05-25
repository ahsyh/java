package com.leetcode.q048;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for(String s:strs){
        	if(s.length()==0)continue;

        	char[] chArray = s.toCharArray();
            Arrays.sort(chArray);
            String key = new String(chArray);

            if(map.containsKey(key)){
            	map.get(key).add(s);
            }
            else{
            	ArrayList<String> one = new ArrayList<String>();
            	one.add(s);
            	map.put(key, one);
            }
        }
        
        for(ArrayList<String> one:map.values()){
        	if(one.size()>1)
        		res.addAll(one);
        }

        return res;
    }
}
