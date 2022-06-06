package Lec7;

import java.util.*;

public class Combination_Sum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
		Arrays.sort(arr);
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		PrintCombination(arr, 0, list, 8, ans);
		System.out.println(ans);

	}

	public static void PrintCombination(int[] arr, int idx, List<Integer> list, int amount, List<List<Integer>> ans) {
		if (amount == 0) {
			System.out.println(list);
			ans.add(new ArrayList<>(list));
			return;
		}
		if (idx == arr.length) {
			return;
		}

		for (int i = idx; i < arr.length; i++) {

			if (i != idx && arr[i] == arr[i - 1]) {// every level pe 1st call jaane de
				continue;
			}
			if (amount >= arr[i]) {
				list.add(arr[i]);
				PrintCombination(arr, i + 1, list, amount - arr[i], ans);
				list.remove(list.size() - 1);

			}

		}

	}

}
