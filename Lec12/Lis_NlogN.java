package Lec12;

public class Lis_NlogN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 8, 4, 2, 12, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		System.out.println(lis(arr));

	}

	public static int lis(int[] arr) {
		int[] lisend = new int[arr.length];
		lisend[0] = arr[0];
		int len = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > lisend[len - 1]) {
				lisend[len] = arr[i];
				len++;
			} else {
				int idx = BinarySearch(0, len - 1, lisend, arr[i]);
				lisend[idx] = arr[i];

			}

		}
		return len;

	}

	private static int BinarySearch(int si, int ei, int[] lisend, int k) {
		// TODO Auto-generated method stub
		int ans = 0;
		while (si <= ei) {
			int mid = (si + ei) / 2;
			if (lisend[mid] >=k) {
				ans = mid;
				ei = mid - 1;
			} else {
				si = mid + 1;
			}
		}

		return ans;
	}

}
