package Lec16;

import java.util.*;

public class Course_Schedule_2 {

	class Solution {
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

		public int[] findOrder(int numCourses, int[][] prerequisites) {
			for (int i = 0; i < numCourses; i++) {
				map.put(i, new HashMap<>());

			}
			for (int i = 0; i < prerequisites.length; i++) {
				int v2 = prerequisites[i][0];
				int v1 = prerequisites[i][1];// v1-->v2
				map.get(v1).put(v2, 0);// v1-->v2
			}
			return isFinsh();
		}

		public int[] isFinsh() {
			Queue<Integer> qq = new LinkedList<>();
			int[] ans = new int[map.size()];
			int count = 0;
			int[] ind = indgree();
			for (int i = 0; i < ind.length; i++) {
				if (ind[i] == 0) {
					qq.add(i);
				}

			}
			int idx = 0;

			while (!qq.isEmpty()) {
				int front = qq.poll();
				ans[idx++] = front;
				count++;
				for (int nbrs : map.get(front).keySet()) {
					ind[nbrs]--;
					if (ind[nbrs] == 0) {
						qq.add(nbrs);
					}
				}

			}
			if (count != map.size()) {
				return new int[0];
			}

			return ans;

		}

		public int[] indgree() {
			int[] arr = new int[map.size()];
			for (int key : map.keySet()) {

				for (int nbrs : map.get(key).keySet()) {
					arr[nbrs]++;
				}
			}
			return arr;

		}
	}
}
