package Lec17;

import java.util.*;

public class Clone_Graph {

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	class Solution {
		public Node cloneGraph(Node node) {
			if (node == null) {
				return node;
			}
			HashMap<Node, Node> visited = new HashMap<>();
			Queue<Node> qq = new LinkedList<>();
			qq.add(node);
			visited.put(node, new Node(node.val));
			while (!qq.isEmpty()) {
				Node p = qq.poll();

				for (Node nbrs : p.neighbors) {
					if (!visited.containsKey(nbrs)) {
						visited.put(nbrs, new Node(nbrs.val));
						qq.add(nbrs);

					}
					visited.get(p).neighbors.add(visited.get(nbrs));//(visited.get(nbrs)-- > nbrs ka colon milega
					//visited.get(p).neighbors.add(nbrs);/// nbrs original hai Colon add nhi hoga 
				}

			}

			return visited.get(node);

		}
	}
}
