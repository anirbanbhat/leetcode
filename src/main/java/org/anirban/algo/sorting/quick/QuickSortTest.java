package org.anirban.algo.sorting.quick;

public class QuickSortTest {

	public static void main(String[] args) {
		int[] arr = new int[] {7, 1, 4, 9, 2, 5, 6};
		printArray(arr);
		QuickSort sort = new QuickSort();
		sort.quickSort(arr);
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
