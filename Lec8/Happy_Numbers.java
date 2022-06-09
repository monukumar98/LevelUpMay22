package Lec8;

import java.util.Scanner;

public class Happy_Numbers {
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new  Scanner(System.in);
		int n = sc.nextInt();
		if (HappyHappy(n)) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}

	}

	public static boolean HappyHappy(int n) {
		if (n == 1) {
			return true;
		}
		if (n != 7 && n < 10) {
			return false;
		}

		count++;
		return HappyHappy(newnumber(n));

	}

	public static int newnumber(int n) {

		int ans = 0;

		while (n > 0) {
			int rem = n % 10;
			ans = ans + rem * rem;
			n = n / 10;
		}
		return ans;

	}

}
