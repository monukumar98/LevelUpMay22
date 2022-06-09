package Lec8;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] maze = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				if (maze[i][j] == word.charAt(0)) {
					boolean ans = Search(maze, i, j, word, 0);
					if (ans) {
						System.out.println(ans);
						return;
					}

				}
			}

		}
		System.out.println(false);

	}

	private static boolean Search(char[][] maze, int cr, int cc, String word, int len) {

		if (len == word.length()) {
			return true;
		}

		if (cc < 0 || cr < 0 || cc >= maze[0].length || cr >= maze.length || maze[cr][cc] != word.charAt(len)) {
			return false;
		}
		maze[cr][cc] = '*';
		int[] r = { 1, -1, 0, 0 };
		int[] c = { 0, 0, -1, 1 };
		for (int i = 0; i < c.length; i++) {
			boolean ans = Search(maze, cr + r[i], cc + c[i], word, len + 1);
			if (ans) {
				return ans;
			}

		}

		maze[cr][cc] = word.charAt(len);
		return false;

//		boolean down = Search(maze, cr + 1, cc, word, len + 1);
//		if (down) {
//			return true;
//		}
//		boolean top = Search(maze, cr - 1, cc, word, len + 1);
//		if (down) {
//			return true;
//		}
//		boolean left = Search(maze, cr, cc - 1, word, len + 1);
//		if (left) {
//			return true;
//		}
//
//		boolean right = Search(maze, cr, cc + 1, word, len + 1);
//		if (right) {
//			return true;
//		}

	}

}
