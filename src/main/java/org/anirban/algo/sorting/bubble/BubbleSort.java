package org.anirban.algo.sorting.bubble;

public class BubbleSort {

	public void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	private void swap(int[] nums, int index1, int index2) {
		nums[index1] = nums[index1] + nums[index2];
		nums[index2] = nums[index1] - nums[index2];
		nums[index1] = nums[index1] - nums[index2];
	}
}
