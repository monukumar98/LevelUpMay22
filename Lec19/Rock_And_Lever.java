package Lec19;

import java.util.Scanner;

public class Rock_And_Lever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(CountPair(arr));

		}

	}

	public static long CountPair(int[] arr) {
	long ans = 0;
		boolean[] visited = new boolean[arr.length];
		for (int i = 31; i >= 0; i--) {
			long c = 0;
			for (int j = 0; j < arr.length; j++) {
				if ((arr[j] & (1 << i)) != 0 && visited[j] == false) {
					c++;
					visited[j] = true;
				}

			}

			ans = ans + (c * (c - 1)) / 2;

		}
		return ans;

	}

}
