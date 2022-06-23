package Lec12;

public class Binary_Tree_Cameras {
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

	class Count {
		int ans = 0;
	}

	class Solution {

		public int minCameraCover(TreeNode root) {
			Count count = new Count();
			int ii=CountCamera(root, count);
			if (ii == -1) {
				count.ans = count.ans + 1;
			}
			return count.ans;

		}

		private int CountCamera(TreeNode root, Count count) {
			// TODO Auto-generated method stub
			if (root == null) {
				return 1;// covered
			}
			int left = CountCamera(root.left, count);
			int right = CountCamera(root.right, count);
			if (left == -1 || right == -1) {
				count.ans = count.ans + 1;
				return 2;

			} else if (left == 1 && right == 1) {
				return -1;
			} else {
				return 1;
			}

		}
	}

}
