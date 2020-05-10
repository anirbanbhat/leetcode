package org.anirban.algo.sorting.selection;

public class SelectionSortTest {

	public static void main(String[] args) {
		int[] arr = new int[] {7, 1, 4, 9, 2, 5, 6};
		printArray(arr);
		SelectionSort sort = new SelectionSort();
		sort.selectionSort(arr);
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
