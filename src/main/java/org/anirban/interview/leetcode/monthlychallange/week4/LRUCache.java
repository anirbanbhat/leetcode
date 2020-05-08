package org.anirban.interview.leetcode.monthlychallange.week4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 
 * @author Anirban
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following 
 * operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise 
 * return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its 
 * capacity, it should invalidate the least recently used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LRUCache cache = new LRUCache(2); // capacity
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 */

public class LRUCache {

	private LinkedHashMap<Integer, Integer> lru;
	private int size;
	public LRUCache(int capacity) {
		this.size = capacity;
        this.lru = new LinkedHashMap<Integer, Integer>(size + 1, .75F, false) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > size;
             }
          };
	}
	
	public int get(int key) {
        if(lru.containsKey(key)) {
			int value= lru.get(key);
			lru.remove(key);
			lru.put(key, value);
			return value;
		}
        return -1;
    }
    
    public void put(int key, int value) {
        if(lru.containsKey(key)) {
			lru.remove(key);
        }
        lru.put(key, value);
    }
	
	class Node {
		Integer key;
		Integer value;
		public Node(Integer key, Integer value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    					// evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    					// evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
		/*
		
		cache = new LRUCache( 2);

		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);						// (1, 1) (2, 3)
		cache.put(4, 1);						// (2, 3) (4, 1)
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(2));       // returns 3 
		*/
	}
}
