package Lec14;


public class Recover_Binary_Search_Tree_Space_Wise {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class Solution {
		TreeNode prev = null;
		TreeNode first = null;
		TreeNode second = null;

		public void recoverTree(TreeNode root) {
			Inorder(root);
			int t = first.val;
			first.val=second.val;
			second.val=t;
		}

		public void Inorder(TreeNode root) {

			if (root == null) {
				return;
			}
			Inorder(root.left);

			// Judge
			if (prev != null && prev.val > root.val) {

				if (first == null) {
					first = prev;
				} 
				
					second = root;

			}

			prev = root;
			Inorder(root.right);

		}
	}
}
