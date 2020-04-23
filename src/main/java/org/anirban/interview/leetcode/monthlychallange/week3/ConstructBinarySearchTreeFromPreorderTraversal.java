package org.anirban.interview.leetcode.monthlychallange.week3;

import java.util.LinkedList;

/**
 * 
 * @author Anirban
 * 
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * 
 * (Recall that a binary search tree is a binary tree where for every node, any descendant 
 * of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  
 * Also recall that a preorder traversal displays the value of the node first, then traverses 
 * node.left, then traverses node.right.)
 * 
 * Example 1:
 * 
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * 
 * Note: 
 * 
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 *
 */

public class ConstructBinarySearchTreeFromPreorderTraversal {

	public static void main(String[] args) {
		TreeNode root = bstFromPreorder(new int[] {8,5,1,7,10,12});
		inOrderTraversal(root);
	}

	static int index = 0;
	public static TreeNode bstFromPreorder(int[] preorder) {
		return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	public static TreeNode bstFromPreorder(int[] preorder, int min, int max) {
        if(index>=preorder.length) {
        	return null;
        }
        TreeNode root = null;
        int value = preorder[index];
        if(min<value && value<max) {
        	index++;
        	root = new TreeNode(value);
        	root.left = bstFromPreorder(preorder, min, value);
        	root.right = bstFromPreorder(preorder, value, max);
        }
        return root;
    }
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void inOrderTraversal(TreeNode root) {
		LinkedList<TreeNode> q = new LinkedList<>();
		if(root != null) {
			q.addLast(root);
		}
		String pref = "";
		while(!q.isEmpty()) {
			TreeNode current = q.removeFirst();
			System.out.print(pref + current.val);
			pref = " -> ";
			if(current.left != null) {
				q.add(current.left);
			}
			if(current.right != null) {
				q.add(current.right);
			}
		}
		System.out.println();
	}

}
