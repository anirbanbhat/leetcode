package org.anirban.algo.sorting.insertion;

public class InsertionSort {

	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while(j>0 && arr[j]<arr[j-1]) {
				swap(arr, j, j-1);
				j--;
			}
		}
	}
	
	private void swap(int[] nums, int index1, int index2) {
		nums[index1] = nums[index1] + nums[index2];
		nums[index2] = nums[index1] - nums[index2];
		nums[index1] = nums[index1] - nums[index2];
	}
}
