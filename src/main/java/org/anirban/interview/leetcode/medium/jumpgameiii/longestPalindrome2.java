package org.anirban.interview.leetcode.medium.jumpgameiii;

import java.util.stream.BaseStream;;;

public class longestPalindrome2 {

	public static void main(String[] args) {
		String str = "forgeeksskeegfor"; 
        System.out.println("Length is: " +  
        		longestPalindrome(str));
	}
	
    public static String longestPalindrome(String s) {
    	if((s.length() == 1 || s.length() == 0))
            return s;
        char[] arr = s.toCharArray();
        int length=0;
        String result = null;
        for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				char[] subarray = new char[j-i+1];
				System.arraycopy(arr, i, subarray, 0, subarray.length);
				if(isPalindrome(subarray) && length<(subarray.length)) {
					result = new String(subarray);
					length = subarray.length;
				}
			} 
		}
        return (length==0)?s.substring(0,1):result;
    }
    
    public static boolean isPalindrome(char[] arr) {
    	System.out.println(new String(arr));
    	int i=0;
    	int j=arr.length-1;
    	while(i<j) {
    		if(arr[i]!=arr[j]) {
    			System.out.println(false);
    			return false;
    	    }
    		i++;
    		j--;
    	}
    	System.out.println(true);
    	return true;
    }
}
