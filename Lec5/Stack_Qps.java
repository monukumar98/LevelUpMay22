package Lec5;

import java.util.*;

public class Stack_Qps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -9, 1, 4, 12 };
		System.out.println(pattern132(arr));

	}

	public static boolean pattern132(int[] arr) {
		int[] min = new int[arr.length];
		min[0] = arr[0];
		for (int i = 1; i < min.length; i++) {
			min[i] = Math.min(min[i - 1], arr[i]);

		}
		Stack<Integer> st = new Stack<>();
		for (int j = arr.length - 1; j >= 0; j--) {

			int ith = min[j];
			if (ith < arr[j]) {
				while (!st.isEmpty() && arr[st.peek()] <= ith) {
					st.pop();
				}

				if (!st.isEmpty() && arr[st.peek()] < arr[j]) {
					return true;
				}

			}

			st.push(j);

		}
		return false;

	}

}
