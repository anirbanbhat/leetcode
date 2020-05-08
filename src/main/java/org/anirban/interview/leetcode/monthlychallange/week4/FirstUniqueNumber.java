package org.anirban.interview.leetcode.monthlychallange.week4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 
 * @author Anirban
 * 
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 * 
 * Implement the FirstUnique class:
 * 
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no 
 * such integer.
 * void add(int value) insert value to the queue.
 *
 */

public class FirstUniqueNumber {

	Map<Integer, Integer> frequencyMap;
    LinkedList<Integer> queue;
    
    public FirstUniqueNumber(int[] nums) {
        frequencyMap = new HashMap<>();
        queue = new LinkedList<>();
        for(int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            queue.offer(num);
        }
    }
    
    public int showFirstUnique() {
    	if(queue.isEmpty()) {
    		return -1;
    	}
    	int queueLength = queue.size();
        for (int i = 0; i < queueLength; i++) {
			int val = queue.peek();
			if(frequencyMap.get(val)==1) {
				return val;
			} else {
				queue.poll();
			}
		}
        return -1;
    }
    
    public void add(int value) {
    	frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        queue.offer(value);
    }
    
	public static void main(String[] args) {
		FirstUniqueNumber firstUnique = new FirstUniqueNumber(new int[] {2,3,5});
		System.out.println(firstUnique.showFirstUnique()); // return 2
		firstUnique.add(5);            // the queue is now [2,3,5,5]
		System.out.println(firstUnique.showFirstUnique()); // return 2
		firstUnique.add(2);            // the queue is now [2,3,5,5,2]
		System.out.println(firstUnique.showFirstUnique()); // return 3
		firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
		System.out.println(firstUnique.showFirstUnique()); // return -1
		
		
		firstUnique = new FirstUniqueNumber(new int[] {7,7,7,7,7,7});
		System.out.println(firstUnique.showFirstUnique()); // return -1
		firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
		firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
		firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
		firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
		firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
		System.out.println(firstUnique.showFirstUnique()); // return 17
		
		
		firstUnique = new FirstUniqueNumber(new int[] {809});
		System.out.println(firstUnique.showFirstUnique()); // return 809
		firstUnique.add(809);          // the queue is now [809,809]
		System.out.println(firstUnique.showFirstUnique()); // return -1
	}

}
