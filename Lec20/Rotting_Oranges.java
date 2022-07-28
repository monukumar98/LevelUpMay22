package Lec20;

import java.util.LinkedList;
import java.util.Queue;


public class Rotting_Oranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		Rotting_Oranges rj = new Rotting_Oranges();
		System.out.println(rj.orangesRotting(grid));

	}

	public int orangesRotting(int[][] grid) {

		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					q.add(new Pair(i, j, 0));
				}

			}
		}

		if (q.isEmpty()) {
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (grid[i][j] == 1) {
						return -1;
					}
				}
			}
			return 0;
		}
		int r[] = { 1, -1, 0, 0 };
		int c[] = { 0, 0, 1, -1 };
		int ans = 0;
		while (!q.isEmpty()) {
			Pair rp = q.remove();
			ans = rp.time;
			for (int i = 0; i < c.length; i++) {
				if (rp.i + r[i] < 0 || rp.i + r[i] >= grid.length || rp.j + c[i] < 0 || rp.j + c[i] >= grid[0].length) {
					continue;
				}
				int x = rp.i + r[i];
				int y = rp.j + c[i];
				if (grid[x][y] == 1) {
					grid[x][y]=2;// add na ho next time
					q.add(new Pair(x, y, rp.time + 1));
				}

			}

		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}
		return ans;

	}

	public class Pair {
		int i;
		int j;
		int time;

		public Pair(int i, int j, int time) {
			// TODO Auto-generated constructor stub
			this.i = i;
			this.j = j;
			this.time = time;
		}
	}

}
