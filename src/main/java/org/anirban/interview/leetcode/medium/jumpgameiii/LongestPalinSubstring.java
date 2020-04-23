package org.anirban.interview.leetcode.medium.jumpgameiii;

public class LongestPalinSubstring {

	public static void main(String[] args) {
		String str = "forgeeksskeegfor"; 
        System.out.println("Length is: " +  
        		longestPalindrome(str)); 
        
        /*str = "cbbd"; 
        System.out.println("Length is: " +  
        		longestPalindrome(str));*/

	}
	
	public static String longestPalindrome(String s) {
        int maxLength = 0;
        String subString = "";
        for(int i=0; i<s.length()-1; i++){
            for(int j=s.length()-1; j>i; j--){
                if(chechPalin(s.substring(i, j+1)) && (j-i)>maxLength){
                    maxLength=j-i;
                    subString = s.substring(i, j+1);
                }
            }
        }
        return subString;
    }
    
    public static boolean chechPalin(String s){
    	System.out.println("Sub String: " + s);
        boolean isPalindrom = true;
        System.out.println("s.length()/2-1 : " + (s.length()/2-1));
        for(int i=0; i<=(s.length()/2-1); i++){
        	System.out.print("s.charAt(i) " + s.charAt(i) + " == " 
        + s.charAt(s.length()-i-1) + " s.charAt(s.length()-i-1)");
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                isPalindrom = false;
                break;
            }
        }
        System.out.println("isPalindrom: " + isPalindrom);
        return isPalindrom;
    }

}
