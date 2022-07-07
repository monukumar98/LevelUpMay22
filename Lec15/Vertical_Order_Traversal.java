package Lec15;

import java.util.*;

public class Vertical_Order_Traversal {

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

	public class VerticalPair {
		TreeNode node;
		int vtl;
		int ht;

		public VerticalPair(TreeNode node, int vt, int ht) {
			// TODO Auto-generated constructor stub
			this.node = node;
			this.vtl = vt;
			this.ht = ht;
		}

	}

	class Solution {
		public List<List<Integer>> verticalTraversal(TreeNode root) {

			LinkedList<VerticalPair> qq = new LinkedList<>();
			TreeMap<Integer, List<VerticalPair>> map = new TreeMap<>();
			VerticalPair vp = new VerticalPair(root, 0, 0);
			qq.add(vp);
			while (!qq.isEmpty()) {
				VerticalPair rp = qq.remove();
				if (!map.containsKey(rp.vtl)) {
					map.put(rp.vtl, new ArrayList<>());
				}
				map.get(rp.vtl).add(rp);
				if (rp.node.left != null) {
					VerticalPair np = new VerticalPair(rp.node.left, rp.vtl - 1, rp.ht + 1);
					qq.add(np);
				}
				if (rp.node.right != null) {
					VerticalPair np = new VerticalPair(rp.node.right, rp.vtl + 1, rp.ht + 1);
					qq.add(np);
				}

			}

			List<List<Integer>> ans = new ArrayList<>();
			for (int key : map.keySet()) {
				List<VerticalPair> ll = map.get(key);
				Collections.sort(ll, new Comparator<VerticalPair>() {

					@Override
					public int compare(VerticalPair o1, VerticalPair o2) {
						// TODO Auto-generated method stub
						if (o1.ht == o2.ht) {
							return o1.node.val - o2.node.val;
						}
						return 0;

					}
				});

				List<Integer> list = new ArrayList<>();
				for (VerticalPair p : ll) {
					list.add(p.node.val);
				}
				ans.add(list);

			}
			return ans;

		}
	}
}
