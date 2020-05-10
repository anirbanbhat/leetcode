package org.anirban.algo.sorting.bubble;

public class BubbleSortTest {

	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();
		int[] arr = new int[] {7, 1, 4, 9, 2, 5, 6};
		sort.bubbleSort(arr);
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
