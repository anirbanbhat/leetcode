package org.anirban.interview.leetcode.monthlychallange.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Anirban
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *  
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 */

public class MinStack {
	/** initialize your data structure here. */
    List<Integer> list;
    List<Integer> minList;
    int minIndex;
    public MinStack() {
        list = new ArrayList<Integer>();
        minList = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        if(minList.size() == 0){
            minList.add(x);
            minIndex = 0;
        } else if(minList.get(minIndex) >= x) {
        	minList.add(x);
        	minIndex++;
        }
        list.add(x);
    }
    
    public void pop() {
        if(list.size()>0){
            int removed = list.remove(list.size() - 1);
            if(removed == minList.get(minIndex)) {
            	minList.remove(minIndex--);
            }
        }
    }
    
    public int top() {
        if(list.size()>0){
            return list.get(list.size() - 1);   
        }
        return Integer.MIN_VALUE;
    }
    
    public int getMin() {
    	if(minList.size()>0){
            return minList.get(minIndex);   
        }
        return Integer.MIN_VALUE;
    }
}
