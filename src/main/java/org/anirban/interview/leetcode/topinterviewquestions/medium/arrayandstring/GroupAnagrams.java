package org.anirban.interview.leetcode.topinterviewquestions.medium.arrayandstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;

/**
 * 
 * @author Anirban
 * 
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 */

public class GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
		System.out.println(groupAnagrams(new String[] {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"}));
		System.out.println(groupAnagrams(new String[] {"duh", "ill"}));
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> ans = new HashMap<String, List<String>>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            System.out.println(s + "\t:\t" + key);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<String>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
	}
	
	public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<Anagram, List<String>> map = new HashMap<>();
        for(String str: strs) {
        	Anagram anagram = new Anagram(str);
        	if(map.containsKey(anagram)) {
        		map.get(anagram).add(str);
        	} else {
        		List<String> list = new ArrayList<String>();
        		list.add(str);
        		map.put(anagram, list);
        	}
        }
        return new ArrayList<>(map.values());
    }
    
    public static class Anagram {
    	String str;
    	public Anagram(String str) {
    		this.str = str;
    	}
    	@Override
		public int hashCode() {
			final int prime = 31;
			int result = 0;
			for (Character ch : str.toCharArray()) {
				result += (int) ch;
			}
			result = prime * result;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Anagram other = (Anagram) obj;
			if (str == null) {
				if (other.str != null)
					return false;
			} else if (isAnagram(this.str, other.str))
				return true;
			return false;
		}
		public boolean isAnagram(String s1, String s2) {
        	Map<Character, Integer> frequencyMap = new HashMap<>();
        	for (Character ch : s1.toCharArray()) {
        		frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
    		}
        	for (Character ch : s2.toCharArray()) {
        		if(frequencyMap.containsKey(ch)) {
        			frequencyMap.put(ch, frequencyMap.get(ch) - 1);
        			if(frequencyMap.get(ch) == 0) {
        				frequencyMap.remove(ch);
        			}
        		} else {
        			return false;
        		}
        	}
        	return frequencyMap.size() == 0;
        }
    }

}
