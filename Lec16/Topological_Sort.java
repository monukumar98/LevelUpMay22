package Lec16;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Topological_Sort {

	HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

	public Topological_Sort(int v) {
		// TODO Auto-generated constructor stub
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addedge(int v1, int v2) {
		map.get(v1).put(v2, 0);// v1-->v2
	}

	public void TopologicalSort() {
		Queue<Integer> qq = new LinkedList<>();
		int[] ind = indgree();
		for (int i = 1; i < ind.length; i++) {
			if (ind[i] == 0) {
				qq.add(i);
			}

		}

		while (!qq.isEmpty()) {
			int front = qq.poll();
			System.out.print(front + " ");
			for (int nbrs : map.get(front).keySet()) {
				ind[nbrs]--;
				if (ind[nbrs] == 0) {
					qq.add(nbrs);
				}
			}

		}

	}

	public int[] indgree() {
		int[] arr = new int[map.size() + 1];
		for (int key : map.keySet()) {

			for (int nbrs : map.get(key).keySet()) {
				arr[nbrs]++;
			}
		}
		return arr;

	}

	public boolean iscycle() {
		Queue<Integer> qq = new LinkedList<>();
		int[] ind = indgree();
		for (int i = 1; i < ind.length; i++) {
			if (ind[i] == 0) {
				qq.add(i);
			}

		}
		int count = 0;

		while (!qq.isEmpty()) {
			int front = qq.poll();
			// System.out.print(front + " ");
			count++;
			for (int nbrs : map.get(front).keySet()) {
				ind[nbrs]--;
				if (ind[nbrs] == 0) {
					qq.add(nbrs);
				}
			}

		}
		return count != map.size();

	}

	public static void main(String[] args) {
		Topological_Sort ts = new Topological_Sort(7);
		ts.addedge(1, 2);
		ts.addedge(1, 4);
		ts.addedge(4, 3);
		ts.addedge(3, 2);
		ts.addedge(4, 5);
		ts.addedge(5, 7);
		ts.addedge(6, 3);
		ts.addedge(6, 7);
		//ts.addedge(3, 1);
		ts.TopologicalSort();
		System.out.println();
		System.out.println(ts.iscycle());
	}

}
