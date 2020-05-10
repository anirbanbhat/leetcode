package org.anirban.algo.sorting.heap;

public class MinHeapTest {

	public static void main(String[] args) {
		int[] arr = new int[] {7, 1, 4, 9, 2, 5, 6};
		MinHeap minHeap = new MinHeap();
		minHeap.heapSort(arr);
		printArray(arr);
	}

	public static void printArray(int[] arr) {
		String prefix = "[";
		for (int i : arr) {
			System.out.print(prefix + i);
			prefix = ", ";
		}
		System.out.println("]");
	}
}
