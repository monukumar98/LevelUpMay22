package Lec15;

import java.util.HashMap;

public class Longest_Consecutive_Sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 5, 16, 1, 8, 9, 7, 2, 3, 10, 12, 13, -1, 1, 2, 1, -3 };
		System.out.println(longestConsecutive(arr));
	}

	public static int longestConsecutive(int[] nums) {
		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i] - 1)) {
				map.put(nums[i], false);
			} else {
				map.put(nums[i], true);
			}
			if (map.containsKey(nums[i] + 1)) {
				map.put(nums[i] + 1, false);
			}
		}

		int ans = 0;

		for (int key : map.keySet()) {
			if (map.get(key)) {
				int count = 0;
				while (map.containsKey(key)) {
					count++;
					key++;
				}
				ans = Math.max(ans, count);

			}
		}
		return ans;

	}

}
