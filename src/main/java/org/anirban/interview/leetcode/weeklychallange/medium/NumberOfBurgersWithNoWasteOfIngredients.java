package org.anirban.interview.leetcode.weeklychallange.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Anirban
 * 
 * Given two integers tomatoSlices and cheeseSlices. The ingredients of different burgers are as follows:
 * 
 * Jumbo Burger: 4 tomato slices and 1 cheese slice.
 * Small Burger: 2 Tomato slices and 1 cheese slice.
 * Return [total_jumbo, total_small] so that the number of remaining tomatoSlices equal to 0 and the number 
 * of remaining cheeseSlices equal to 0. If it is not possible to make the remaining tomatoSlices and 
 * cheeseSlices equal to 0 return [].
 * 
 * Example 1:
 * 
 * Input: tomatoSlices = 16, cheeseSlices = 7
 * Output: [1,6]
 * Explantion: To make one jumbo burger and 6 small burgers we need 4*1 + 2*6 = 16 tomato and 1 + 6 = 7 cheese. 
 * There will be no remaining ingredients.
 * 
 * Example 2:
 * 
 * Input: tomatoSlices = 17, cheeseSlices = 4
 * Output: []
 * Explantion: There will be no way to use all ingredients to make small and jumbo burgers.
 * 
 * Example 3:
 * 
 * Input: tomatoSlices = 4, cheeseSlices = 17
 * Output: []
 * Explantion: Making 1 jumbo burger there will be 16 cheese remaining and making 2 small burgers there will 
 * be 15 cheese remaining.
 * 
 * Example 4:
 * 
 * Input: tomatoSlices = 0, cheeseSlices = 0
 * Output: [0,0]
 * 
 * Example 5:
 * 
 * Input: tomatoSlices = 2, cheeseSlices = 1
 * Output: [0,1]
 * 
 * Constraints:
 * 
 * 0 <= tomatoSlices <= 10^7
 * 0 <= cheeseSlices <= 10^7
 *
 */

public class NumberOfBurgersWithNoWasteOfIngredients {

	public static void main(String[] args) {
		System.out.println(numOfBurgersTopDown(16, 7));
		System.out.println(numOfBurgersTopDown(17, 4));
		System.out.println(numOfBurgersTopDown(4, 17));
		System.out.println(numOfBurgersTopDown(0, 0));
		System.out.println(numOfBurgersTopDown(2, 1));
		System.out.println(numOfBurgersTopDown(3962, 1205));
		System.out.println(numOfBurgersTopDown(11658, 5228));
		
		System.out.println(numOfBurgers(16, 7));
		System.out.println(numOfBurgers(17, 4));
		System.out.println(numOfBurgers(4, 17));
		System.out.println(numOfBurgers(0, 0));
		System.out.println(numOfBurgers(2, 1));
		System.out.println(numOfBurgers(3962, 1205));
		System.out.println(numOfBurgers(11658, 5228));
	}
	
	public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list = new ArrayList<>();
        if (tomatoSlices % 2 == 0) {
            int j = tomatoSlices/2 - cheeseSlices;
            int s = cheeseSlices - j;
            if (j >= 0 && s >= 0) {
                list.add(j);
                list.add(s);
            }
        }
        
        return list;
    }

	public static List<Integer> numOfBurgersTopDown(int tomatoSlices, int cheeseSlices) {
		List<Integer>[][] td = new List[tomatoSlices+1][cheeseSlices+1];
		return  numOfBurgersTopDown(tomatoSlices, cheeseSlices, td);
    }
	
	public static List<Integer> numOfBurgersTopDown(int tomatoSlices, int cheeseSlices, List<Integer>[][] td) {
		if(tomatoSlices == 0 && cheeseSlices == 0) {
			return Arrays.asList(new Integer[]{0, 0});
		}
        if((tomatoSlices<4 && cheeseSlices<1) || (tomatoSlices<2 && cheeseSlices<1)) {
        	return null;
        }
        if(td[tomatoSlices][cheeseSlices] == null) {
        	List<Integer> count = null;
            if(tomatoSlices>=6 && cheeseSlices>=2) {
            	count = numOfBurgersTopDown(tomatoSlices-6, cheeseSlices-2, td);
            	if(count != null && count.size()>0) {
            		count.set(0, count.get(0) + 1);
            		count.set(1, count.get(1) + 1);
            	} 
            }
            if((count==null || count.size()==0) && tomatoSlices>=4 && cheeseSlices>=1) {
            	count = numOfBurgersTopDown(tomatoSlices-4, cheeseSlices-1, td);
        		if(count != null && count.size()>0) {
        			count.set(0, count.get(0) + 1);
        		} 
        	}
            if((count==null || count.size()==0) && tomatoSlices>=2 && cheeseSlices>=1) {
    			count = numOfBurgersTopDown(tomatoSlices-2, cheeseSlices-1, td);
        		if(count != null && count.size()>0) {
        			count.set(1, count.get(1) + 1);
        		}
    		}
            td[tomatoSlices][cheeseSlices] = (count==null || count.size()==0)?
            		new ArrayList<Integer>():count;
        }
		return td[tomatoSlices][cheeseSlices];
    }
	
	public static List<Integer> numOfBurgersBottomUp(int tomatoSlices, int cheeseSlices) {
		Integer[][][] td = new Integer[tomatoSlices+1][cheeseSlices+1][2];
		td[0][0][0] = 0;
		td[0][0][1] = 0;
		for (int i = 1; i <= tomatoSlices; i++) {
			for (int j = 1; j < cheeseSlices; j++) {
				if((i>=6 && j>=2) && (td[i-6][j-2][0] != null && td[i-6][j-2][1] != null)) {
					td[i][j][0] = td[i-6][j-2][0] + 1;
					td[i][j][1] = td[i-6][j-2][1] + 1;
				} else if((i>=4 && j>=1) && (td[i-4][j-1][0] != null && td[i-4][j-1][1] != null)) {
					td[i][j][0] = td[i-4][j-1][0] + 1;
					td[i][j][1] = td[i-4][j-1][1] + 1;
				} else if((i>=2 && j>=1) && (td[i-2][j-1][0] != null && td[i-2][j-1][1] != null)){
					td[i][j][0] = td[i-2][j-1][0] + 1;
					td[i][j][1] = td[i-2][j-1][1] + 1;
				}
			}
		}
		if(td[tomatoSlices][cheeseSlices][0] != null) {
			return Arrays.asList(td[tomatoSlices][cheeseSlices]);
		}
		return new ArrayList<Integer>();
    }
}
