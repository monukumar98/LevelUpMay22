package Lec6;

import java.util.*;

public class Sliding_Window_Size_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] ans = maxWindow(arr, 3);
		System.out.println(Arrays.toString(ans));

	}

	public static int[] maxWindow(int[] arr, int k) {
		int n = arr.length;
		int[] max = new int[n - k + 1];
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < k; i++) {

			while (!dq.isEmpty() && arr[dq.getLast()] <= arr[i]) {
				dq.removeLast();
			}
			dq.add(i);// last me add krega

		}
		max[0] = arr[dq.getFirst()];// 1st window ka maximum
		int j = 1;
		for (int i = k; i < n; i++) {

			// window i-k tk remove;
			while (!dq.isEmpty() && dq.getFirst() <= i - k) {
				dq.remove();// remove first krega
			}
			while (!dq.isEmpty() && arr[dq.getLast()] <= arr[i]) {
				dq.removeLast();// remove first krega
			}
			dq.add(i);// last me add krega

			max[j++] = arr[dq.getFirst()];

		}

		return max;

	}

}
