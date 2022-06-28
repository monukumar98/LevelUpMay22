package Lec13;

public class Binary_Tree_Maximum_Path_Sum {
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
		int ans = Integer.MIN_VALUE;

		public int maxPathSum(TreeNode root) {
             pathSum(root);
             return ans;
		}

		public int pathSum(TreeNode root) {
			if(root==null) {
				return 0;
			}

			int left = pathSum(root.left);
			int right = pathSum(root.right);

			int sp = Math.max(left + root.val, Math.max(right + root.val, root.val));
			int rp = Math.max(sp, left + right + root.val);
			ans = Math.max(ans,rp);
			return sp;

		}

	}
}
