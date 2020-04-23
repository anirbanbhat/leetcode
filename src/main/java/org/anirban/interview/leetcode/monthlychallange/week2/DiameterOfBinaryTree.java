package org.anirban.interview.leetcode.monthlychallange.week2;

/**
 * 
 * @author Anirban
 * 
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a 
 * binary tree is the length of the longest path between any two nodes in a tree. This path may or may 
 * not pass through the root.
 * 
 * Example:
 * Given a binary tree 
 *           1
 *          / \
 *         2   3
 *        / \     
 *       4   5    
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * 
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 */

public class DiameterOfBinaryTree {

	static int max;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(diameterOfBinaryTree(root));
	}
	
	public static int diameterOfBinaryTree(TreeNode root) {
		if(root != null){
            helper(root);
        }
        return max;
    }
    
    public static int helper(TreeNode root) {
        int leftDepth = 0;
        int rightDepth = 0;
        if(root.left != null){
            leftDepth = helper(root.left);
        }
        if(root.right != null){
        	rightDepth = helper(root.right);
        }
        max = Math.max(max, (leftDepth + rightDepth));
        int localMaxDepth = Math.max(leftDepth, rightDepth);
        return localMaxDepth + 1;
    }

	/**
	 * Definition for a binary tree node.
	 */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}

