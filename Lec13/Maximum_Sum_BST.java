package Lec13;

public class Maximum_Sum_BST {
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

	class BstPair {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean isbst = true;
		int size = 0;
		int ans = 0;
		int sum = 0;
	}

	class Solution {
		public int maxSumBST(TreeNode root) {
			return maxSum(root).ans;

		}

		public BstPair maxSum(TreeNode root) {
			if (root == null) {
				return new BstPair();
			}

			BstPair lbp = maxSum(root.left);
			BstPair rbp = maxSum(root.right);

			BstPair sbp = new BstPair();
			sbp.min = Math.min(lbp.min, Math.min(rbp.min, root.val));
			sbp.max = Math.max(lbp.max, Math.max(rbp.max, root.val));
			sbp.sum = lbp.sum + rbp.sum + root.val;
			if (lbp.isbst && rbp.isbst && lbp.max < root.val && rbp.min > root.val) {
				sbp.isbst = true;
				sbp.size = lbp.size + rbp.size + 1;
				sbp.ans=Math.max(rbp.ans,Math.max(sbp.sum,lbp.ans));
				return sbp;

			}
			sbp.ans=Math.max(lbp.ans, rbp.ans);
			sbp.isbst = false;
			sbp.size = Math.max(lbp.size, rbp.size);
			return sbp;

		}
	}

}
