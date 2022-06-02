package Lec6;

import java.util.Stack;

public class Maximum_Score_of_a_Good_Subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 4, 3, 7, 4, 5 };
		int k = 3;
		System.out.println(Area(arr, k));

	}

	public static int Area(int[] arr, int k) {
		Stack<Integer> st = new Stack<>();
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
				// area
				int r = i;// r interval part nhi hai , r-1 tk interval
				int h = arr[st.pop()];
				if (r - 1 >= k) {
					if (!st.isEmpty()) {
						int l = st.peek();// l interval part nhi hai , l+1 se hoga interval
						if (l + 1 <= k) {
							ans = Math.max(ans, h * (r - l - 1));
						}
					}

					else {
						ans = Math.max(ans, h * r);
					}
				}
			}
			st.push(i);

		}

		int r = arr.length;

		while (!st.isEmpty() && r - 1 >= k) {
			// area

			int h = arr[st.pop()];

			if (!st.isEmpty()) {
				int l = st.peek();// l interval part nhi hai , l+1 se hoga interval
				if (l + 1 <= k) {
					ans = Math.max(ans, h * (r - l - 1));
				}
			}

			else {
				ans = Math.max(ans, h * r);
			}

		}
		return ans;
	}

}
