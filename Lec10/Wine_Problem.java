package Lec10;



public class Wine_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = { 2, 3, 5, 1, 4 };
		int[][] dp = new int[price.length][price.length];
		System.out.println(wineProblem(price, 0, price.length - 1, 1, dp));
		System.out.println(wineProblemBU(price));

	}

	public static int wineProblem(int[] price, int si, int ei, int year, int[][] dp) {

		if (si > ei) {
			return 0;
		}
		if (dp[si][ei] != 0) {
			return dp[si][ei];
		}
		int first = price[si] * year + wineProblem(price, si + 1, ei, year + 1, dp);
		int last = price[ei] * year + wineProblem(price, si, ei - 1, year + 1, dp);
		return dp[si][ei] = Math.max(last, first);
	}

	public static int wineProblemBU(int[] price) {
		int[][] dp = new int[price.length][price.length];
		int year = price.length;
		for (int slide = 0; slide < dp.length; slide++) {

			for (int j = slide; j < dp.length; j++) {
				int i = j - slide;
				if (i == j) {

					dp[i][j] = price[i] * year;
				} else {
					int f = price[i] * year + dp[i + 1][j];
					int s = price[j] * year + dp[i][j - 1];
					dp[i][j] = Math.max(f, s);
				}

			}
			year--;

		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		return dp[0][dp.length - 1];

	}

}
