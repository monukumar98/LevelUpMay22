package Lec14;

import java.util.*;

public class Find_Duplicate_Subtrees {

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
		HashMap<String, TreeNode> map;
		HashSet< TreeNode> set;
		public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
			map = new HashMap<>();
			set = new HashSet<>();
			Deuplicates(root);
			return new ArrayList<>(set);
			
			
		}

		public String Deuplicates(TreeNode node) {
			if(node==null) {
				return "X";
			}

			String left = Deuplicates(node.left);
			String right = Deuplicates(node.right);

			String s =  node.val + " "+left + " "+right;

			if (map.containsKey(s)) {
                set.add(map.get(s));
			} else {
				map.put(s, node);
			}
			return s;

		}
	}

}
