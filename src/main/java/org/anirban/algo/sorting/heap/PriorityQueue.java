package org.anirban.algo.sorting.heap;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
	
	private List<Integer> list;
	
	public PriorityQueue() {
		list = new ArrayList<>();
	}

	private void heapify(int index, int heapSize) {
		int leftChild = getLeftChild(index);
		int rightChild = getRightChild(index);
		int max = index;
		if(leftChild<heapSize && list.get(max)<list.get(leftChild)) {
			max = leftChild;
		}
		if(rightChild<heapSize && list.get(max)<list.get(rightChild)) {
			max = rightChild;
		}
		if(max != index) {
			swap(index, max);
			heapify(max, heapSize);
		}
	}
	
	public Integer getMax() {
		return list.get(0);
	}
	
	public Integer poll() {
		if(list.isEmpty()) {
			return null;
		}
		int max = list.get(0);
		swap(0, list.size()-1);
		list.remove(list.size()-1);
		heapify(0, list.size());
		return max;
	}
	
	public void add(int value) {
		list.add(value);
		increaseKey(list.size()-1);
	}
	
	private void increaseKey(int index) {
		while(index>0 && list.get(getParent(index)) < list.get(index)) {
			swap(index, getParent(index));
			index = getParent(index);
		}
	}
	
	private void swap(int index1, int index2) {
		list.set(index1, list.get(index1) + list.get(index2));
		list.set(index2, list.get(index1) - list.get(index2));
		list.set(index1, list.get(index1) - list.get(index2));
	}

	private int getParent(int index) {
		return (index-1)/2;
	}
	
	private int getLeftChild(int index) {
		return index*2 + 1;
	}
	
	private int getRightChild(int index) {
		return index*2 + 2;
	}
	
	public void printHeap() {
		System.out.println(list);
	}
}
