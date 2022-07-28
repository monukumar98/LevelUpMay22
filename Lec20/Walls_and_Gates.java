package Lec20;

import java.util.LinkedList;
import java.util.Queue;

public class Walls_and_Gates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] rooms = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
				{ 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };

	}

	// Int MAx - empty room
	// 0 -- Gate
	// -1 A wall or an obstacle.
	public void wallsAndGates(int[][] rooms) {

		// DFS(rooms);

		BFS(rooms);

	}

	private void BFS(int[][] rooms) {
		// TODO Auto-generated method stub
		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					q.add(new Pair(i, j));
				}
			}

		}
		int r[] = { 1, -1, 0, 0 };
		int c[] = { 0, 0, 1, -1 };
		while (!q.isEmpty()) {
			Pair rp = q.remove();
			for (int i = 0; i < c.length; i++) {
				int x = rp.i + r[i];
				int y = rp.j + c[i];
				if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length
						|| rooms[x][y] <= rooms[rp.i][rp.j] + 1) {
					continue;
				}
				rooms[x][y] = rooms[rp.i][rp.j] + 1;
				q.add(new Pair(x, y));

			}

		}

	}

	public void DFS(int[][] rooms) {
		// TODO Auto-generated method stub
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					help(rooms, i, j, 0);
				}
			}

		}

	}

	private void help(int[][] rooms, int i, int j, int k) {
		// TODO Auto-generated method stub
		if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] < k) {

			return;
		}

		rooms[i][j] = k;

		help(rooms, i + 1, j, k + 1);
		help(rooms, i - 1, j, k + 1);
		help(rooms, i, j + 1, k + 1);
		help(rooms, i, j - 1, k + 1);

	}

	public class Pair {
		int i;
		int j;

		public Pair(int x, int y) {
			this.i = x;
			this.j = y;

		}

	}

}
