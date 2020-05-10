package org.anirban.algo.sorting.quick;

public class QuickSort {

	public void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	private void quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int pivotIndex = partition(arr, low, high);
			quickSort(arr, low, pivotIndex);
			quickSort(arr, pivotIndex+1, high);
		}
	}
	
	private int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		int left = low++;
		while(low<=high) {
			while(low<arr.length && arr[low]<pivot) {
				low++;
			}
			while(high>=0 && arr[high]>pivot) {
				high--;
			}
			if(low<high) {
				swap(arr, low, high);
			}
		}
		swap(arr, high, left);
		return high;
	}
	
	private void swap(int[] nums, int index1, int index2) {
		if(index1==index2) {
			return;
		}
		nums[index1] = nums[index1] + nums[index2];
		nums[index2] = nums[index1] - nums[index2];
		nums[index1] = nums[index1] - nums[index2];
	}
}
