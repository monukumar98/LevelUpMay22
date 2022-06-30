package Lec14;

import java.util.ArrayList;

public class Recover_Binary_Search_Tree {
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
		public void recoverTree(TreeNode root) {
			ArrayList<TreeNode> list = new ArrayList<>();
			Inorder(root, list);
			TreeNode First = null;
			TreeNode second = null;
			for (int i = 0; i < list.size()-1; i++) {
				if (list.get(i).val > list.get(i+1).val) {
					
						First = list.get(i);
						break;
					
				}
			}
			for (int i = list.size()-1; i>0; i--) {
				if (list.get(i).val < list.get(i-1).val) {
					
						second = list.get(i);
						break;
					
				}
			}
			
			
			
			int t = First.val;
			First.val=second.val;
			second.val=t;

		}

		public void Inorder(TreeNode root, ArrayList<TreeNode> list) {
			if (root == null) {
				return;
			}

			Inorder(root.left, list);
			list.add(root);
			Inorder(root.right, list);

		}
	}

}
