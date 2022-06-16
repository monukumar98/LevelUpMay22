package Lec10;

import java.util.HashMap;

public class House_Robber_3 {
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
		public int rob(TreeNode root) {
			HashMap<TreeNode, Integer> map = new HashMap<>();
			return Robber(root, map);

		}

		public int Robber(TreeNode root, HashMap<TreeNode, Integer> map) {
			if (root == null) {
				return 0;
			}
			if(map.containsKey(root)) {
				return map.get(root);
			}

			// 1st rob kra
			int ans = root.val;
			if (root.left != null) {
				ans = ans + Robber(root.left.left, map) + Robber(root.left.right, map);

			}
			if (root.right != null) {
				ans = ans + Robber(root.right.left, map) + Robber(root.right.right, map);
			}
			// dont rob
			int ans2 = Robber(root.left, map) + Robber(root.right, map);
			map.put(root, Math.max(ans, ans2));

			return Math.max(ans, ans2);

		}
	}

}
