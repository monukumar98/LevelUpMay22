package Lec17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class KosaRaju_Algo {

	// strongly connected components

	HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

	public KosaRaju_Algo(int v) {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < v; i++) {
			map.put(i, new HashMap<>());

		}
	}

	public void addedge(int v1, int v2) {
		map.get(v1).put(v2, 5);

	}

	public int kosarajualgo() {

		Stack<Integer> st = new Stack<>();
		HashSet<Integer> visited = new HashSet<>();
		dfs(visited, st, 0);
		HashMap<Integer, HashMap<Integer, Integer>> map1 = new HashMap<>();
		TranposeGraph(map1);
		visited = new HashSet<>();
		int count = 0;
		while (!st.isEmpty()) {
			int pop = st.pop();
			if (!visited.contains(pop)) {
				dfs(map1, visited, pop);
				count++;

			}
		}
		return count;

	}

	private void dfs(HashMap<Integer, HashMap<Integer, Integer>> map1, HashSet<Integer> visited, int pop) {
		// TODO Auto-generated method stub
		visited.add(pop);
		for (int nbrs : map1.get(pop).keySet()) {
			if (!visited.contains(nbrs)) {
				dfs(map1, visited, nbrs);
			}

		}

	}

	private void TranposeGraph(HashMap<Integer, HashMap<Integer, Integer>> map1) {
		// TODO Auto-generated method stub
		for (int key : map.keySet()) {

			for (int nbrs : map.get(key).keySet()) {
				if (!map1.containsKey(nbrs)) {
					map1.put(nbrs, new HashMap<>());
				}
				map1.get(nbrs).put(key, 2);

			}
		}

		for (int key : map.keySet()) {
			if (!map1.containsKey(key)) {
				map1.put(key, new HashMap<>());
			}
		}

	}

	private void dfs(HashSet<Integer> visited, Stack<Integer> st, int i) {
		// TODO Auto-generated method stub
		visited.add(i);

		for (int nbrs : map.get(i).keySet()) {
			if (!visited.contains(nbrs)) {
				dfs(visited, st, nbrs);
			}

		}
		st.push(i);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		KosaRaju_Algo ks = new KosaRaju_Algo(n);
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int e1 = sc.nextInt();
			int e2 = sc.nextInt();
			ks.addedge(e1, e2);

		}
		System.out.println(ks.kosarajualgo());

	}

}
