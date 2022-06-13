package Lec9;

public class Burst_Balloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 4, 5, 1, 7 };
		int[] a = new int[arr.length + 2];
		for (int i = 1; i <=arr.length; i++) {
			a[i] = arr[i - 1];

		}
		a[0] = a[a.length-1] = 1;
		System.out.println(maxCoinsTD(a, 0, a.length - 1));

	}

	public static int maxCoinsTD(int[] arr, int i, int j) {
		if(i+1==j) {
			return 0;
		}

		int ans = Integer.MIN_VALUE;
		for (int k = i+1; k < j; k++) {

			int left = maxCoinsTD(arr, i, k);
			int right = maxCoinsTD(arr, k, j);
			int self = arr[i] * arr[k] * arr[j];
			ans = Math.max(ans, left + right + self);

		}
		return ans;

	}

}
