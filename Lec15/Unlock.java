package Lec15;

import java.util.HashMap;
import java.util.Scanner;

public class Unlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Maxnumber(arr, k);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public static void Maxnumber(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		int n = arr.length;
		for (int i = n; i > 0 && k > 0; i--) {
			int bp = n - i;
			int it = map.get(i);

			if (bp != it) {
				int temp = arr[bp];
				arr[bp] = arr[it];
				arr[it] = temp;
				map.put(i, bp);
				map.put(temp, it);
				k--;

			}

		}

	}

}
