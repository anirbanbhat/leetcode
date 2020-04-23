package org.anirban.interview.leetcode.medium.addtwonumbers;

public class Solution {

	public static void main(String[] args) {
		ListNode head1 = add(new int[] {2, 4, 3});
		print(head1);
		ListNode head2 = add(new int[] {5, 6, 4});
		print(head2);
		AaaTwoNumbers atn = new AaaTwoNumbers();
		ListNode result = atn.addTwoNumbers(head1, head2);
		print(result);
	}
	
	public static ListNode add(int[] intList) {
		ListNode head = new ListNode(intList[0]);
        ListNode lnx = head;
        lnx.next = null;
        for(int i = 1; i <= intList.length - 1; i++){
            ListNode ln = new ListNode(intList[i]);
            ln.next = null;
            lnx.next = ln;
            lnx = ln;
        }
        return head;
	}
	
	public static void print(ListNode n) {
		System.out.print(n.val);
		while(n.next != null){
			System.out.print(" -> ");
            n = n.next;
            System.out.print(n.val);
        }
		System.out.println();
	}

}
