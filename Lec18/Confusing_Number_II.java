package Lec18;

import java.util.HashMap;

public class Confusing_Number_II {

	HashMap<Integer, Integer> map = new HashMap<>();
	int result = 0;

	public int countconfusingNumber(int n) {
		map.put(0, 0);
		map.put(1, 1);
		map.put(6, 9);
		map.put(8, 8);
		map.put(9, 6);
		Calculatenumber(0, n);
		return result;

	}

	private void Calculatenumber(int curr, int n) {
		// TODO Auto-generated method stub
		if (curr > n) {
			return;
		}
		if (getConfusion(curr)) {
			System.out.println(curr);
			result++;

		}

		for (int i : map.keySet()) {
			int temp = curr * 10 + i;
			if (temp != 0) {
				Calculatenumber(temp, n);
			}

		}

	}

	private boolean getConfusion(int curr) {
		// TODO Auto-generated method stub
		int sum = 0;
		int p = curr;
		while (curr > 0) {
			int rem = curr % 10;
			sum = sum * 10 + map.get(rem);
			curr=curr/10;
		}

		return p != sum;
	}

	public static void main(String[] args) {

		Confusing_Number_II cq = new Confusing_Number_II();
		System.out.println(cq.countconfusingNumber(20));
	}

}
