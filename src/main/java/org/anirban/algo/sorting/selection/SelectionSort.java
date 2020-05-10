package org.anirban.algo.sorting.selection;

public class SelectionSort {

	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i; j < arr.length; j++) {
				if(arr[minIndex]>arr[j]) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				swap(arr, i, minIndex);
			}
		}
	}
	
	private void swap(int[] nums, int index1, int index2) {
		nums[index1] = nums[index1] + nums[index2];
		nums[index2] = nums[index1] - nums[index2];
		nums[index1] = nums[index1] - nums[index2];
	}
}
