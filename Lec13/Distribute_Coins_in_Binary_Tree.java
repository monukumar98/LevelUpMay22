package Lec13;

public class Distribute_Coins_in_Binary_Tree {
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
		int ans;

		public int distributeCoins(TreeNode root) {
			ans = 0;
			Moves(root);
			return ans;

		}

		public int Moves(TreeNode root) {
			if (root == null) {
				return 0;
			}

			int left = Moves(root.left);
			int right = Moves(root.right);
			ans = ans + Math.abs(left) + Math.abs(right);

			return left + right + root.val - 1;

		}
	}
}
