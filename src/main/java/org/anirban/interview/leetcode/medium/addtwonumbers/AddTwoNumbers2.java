package org.anirban.interview.leetcode.medium.addtwonumbers;

public class AddTwoNumbers2 {
	
	public static void main(String[] args) {
		ListNode n11 = new ListNode(2);
		ListNode n12 = new ListNode(4);
		ListNode n13 = new ListNode(3);
		
		ListNode n21 = new ListNode(5);
		ListNode n22 = new ListNode(6);
		ListNode n23 = new ListNode(4);
		
		ListNode head1 = addTwoNumbers(n11, n21);
		print(head1);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode((l1.val + l2.val)%10);
        ListNode result = l;
        int carry = (l1.val + l2.val)/10;
        while(l1.next != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
            l.next = new ListNode((l1.val + l2.val + carry)%10);
            carry = (l1.val + l2.val + carry)/10;
            l = l.next;
        }
        return result;
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
