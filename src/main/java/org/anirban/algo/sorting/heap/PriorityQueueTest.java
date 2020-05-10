package org.anirban.algo.sorting.heap;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.add(65);
		pq.add(78);
		pq.add(25);
		pq.add(10);
		System.out.println(pq.getMax());
		System.out.println(pq.poll());
		pq.add(89);
		pq.add(48);
		pq.add(91);
		pq.printHeap();
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	}

}
