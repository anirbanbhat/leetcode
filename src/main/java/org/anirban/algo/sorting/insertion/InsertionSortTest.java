package org.anirban.algo.sorting.insertion;

public class InsertionSortTest {

	public static void main(String[] args) {
		InsertionSort sort = new InsertionSort();
		int[] arr = new int[] {7, 1, 4, 9, 2, 5, 6};
		sort.insertionSort(arr);
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
