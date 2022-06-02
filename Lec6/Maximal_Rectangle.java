package Lec6;

import java.util.*;

public class Maximal_Rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };
		int[][] arr = new int[matrix.length][matrix[0].length];
		int ans = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < arr[0].length; j++) {
				if (i == arr.length - 1) {
					arr[i][j] = matrix[i][j];
				} else {
					arr[i][j] = matrix[i][j] == 1 ? arr[i + 1][j] + 1 : 0;
				}

			}
			ans = Math.max(ans, Area(arr[i]));

		}
		System.out.println(ans);

	}

	public static int Area(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
				// area
				int r = i;
				int h = arr[st.pop()];
				if (!st.isEmpty()) {
					int l = st.peek();
					ans = Math.max(ans, h * (r - l - 1));
				} else {
					ans = Math.max(ans, h * r);
				}

			}

			st.push(i);
		}

		int r = arr.length;

		while (!st.isEmpty()) {
			// area

			int h = arr[st.pop()];
			if (!st.isEmpty()) {
				int l = st.peek();
				ans = Math.max(ans, h * (r - l - 1));
			} else {
				ans = Math.max(ans, h * r);
			}

		}
		return ans;
	}

}
