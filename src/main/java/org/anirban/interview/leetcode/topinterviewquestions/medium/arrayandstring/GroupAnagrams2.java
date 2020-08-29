package org.anirban.interview.leetcode.topinterviewquestions.medium.arrayandstring;

import java.util.*;

public class GroupAnagrams2 {

	public static void main(String[] args) {
		String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> list = groupAnagrams(strs);
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<>();
		
        for(String s : strs){
        	int[] count = new int[26];
            StringBuffer sb = new StringBuffer();
            for(char ch : s.toCharArray()){
            	count[ch - 'a']++;
            }
            for(int i : count){
            	sb.append('#');
            	sb.append(i);
            }
            if(!map.containsKey(sb.toString())) {
            	List<String> l = new ArrayList<String>();
            	l.add(s);
            	map.put(sb.toString(), l);
            } else {
            	map.get(sb.toString()).add(s);
            }
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
        	System.out.print(entry.getKey());
        	System.out.println(" == " + entry.getValue());
        	list.add(entry.getValue());
        }
        System.out.println(list);
        return list;
    }
}
