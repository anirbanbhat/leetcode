package org.anirban.algo.sorting.heap;

public class MinHeap {

	public MinHeap() {}
	
	private void heapify(int[] arr, int index, int heapSize) {
		int leftChild = getLeftChild(index);
		int rightChild = getRightChild(index);
		int min = index;
		if(leftChild<heapSize && arr[min]>arr[leftChild]) {
			min = leftChild;
		}
		if(rightChild<heapSize && arr[min]>arr[rightChild]) {
			min = rightChild;
		}
		if(min != index) {
			swap(arr, index, min);
			heapify(arr, min, heapSize);
		}
	}
	
	public void buildMinHeap(int[] arr, int size) {
		for (int i = size/2; i >= 0; i--) {
			heapify(arr, i, size);
		}
	}
	
	public void heapSort(int[] arr) {
		buildMinHeap(arr, arr.length);
		for (int i = arr.length-1; i > 0 ; i--) {
			swap(arr, i, 0);
			heapify(arr, 0, i-1);
		}
	}
	
	private void swap(int[] nums, int index1, int index2) {
		nums[index1] = nums[index1] + nums[index2];
		nums[index2] = nums[index1] - nums[index2];
		nums[index1] = nums[index1] - nums[index2];
	}
	
	private int getLeftChild(int index) {
		return index*2 + 1;
	}
	
	private int getRightChild(int index) {
		return index*2 + 2;
	}
}
