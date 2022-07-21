package Lec19;

public class Avengers_End_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prime = { 2, 3, 5 };
		System.out.println(Total_No_Div(prime, 1000));

	}

	public static int Total_No_Div(int[] prime, int n) {
		int l = prime.length;
		int res = 0;
		for (int i = 1; i < (1 << l); i++) {
			int m = GetMultiplication(i, prime);
			if ((FastCountSetBit(i) & 1) != 0) {
				res = res + n / m;
			} else {
				res = res - n / m;
			}

		}
		return res;

	}

	public static int GetMultiplication(int i, int[] prime) {

		int pos = 0;
		int ans = 1;
		while (i != 0) {
			if ((i & 1) != 0) {
				ans *= prime[pos];
			}
			pos++;
			i >>= 1;

		}
		return ans;

	}

	public static int FastCountSetBit(int i) {
		int count = 0;
		while (i != 0) {
			i = i & (i - 1);
			count++;
		}
		return count;
	}

}
