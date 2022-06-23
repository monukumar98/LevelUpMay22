package Lec12;

import java.util.*;

public class Print_All_Node_k_Distance {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Pair {
		int v, d;

		public Pair(int v, int d) {
			this.v = v;
			this.d = d;
		}
	}

	class Solution {
		public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

			HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
			CreateGraph(root, map);
			return BFS(map, target.val, k);

		}

		public void CreateGraph(TreeNode root, HashMap<Integer, HashMap<Integer, Integer>> map) {
			if (root == null) {
				return;
			}

			if (!map.containsKey(root.val)) {
				map.put(root.val, new HashMap<>());
			}
			if (root.left != null) {
				map.get(root.val).put(root.left.val, 1);
				map.put(root.left.val, new HashMap<>());
				map.get(root.left.val).put(root.val, 1);
			}
			if (root.right != null) {
				map.get(root.val).put(root.right.val, 1);
				map.put(root.right.val, new HashMap<>());
				map.get(root.right.val).put(root.val, 1);
			}
			CreateGraph(root.left, map);
			CreateGraph(root.right, map);

		}

		public List<Integer> BFS(HashMap<Integer, HashMap<Integer, Integer>> map, int val, int k) {

			Queue<Pair> qq = new LinkedList<>();
			HashSet<Integer> visited = new HashSet<>();
			List<Integer> ans = new ArrayList<>();
			qq.add(new Pair(val, 0));
			while (!qq.isEmpty()) {
				Pair rp = qq.poll();
				if (rp.d > k) {
					return ans;
				}
				visited.add(rp.v);

				if (rp.d == k) {
					ans.add(rp.v);
				}

				for (int nbrs : map.get(rp.v).keySet()) {
					if (!visited.contains(nbrs)) {
						Pair np = new Pair(nbrs, rp.d + 1);
						qq.add(np);
					}
				}

			}
			return ans;

		}
	}
}
