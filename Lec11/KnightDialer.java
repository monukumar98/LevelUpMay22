package Lec11;

public class KnightDialer {
	public static void main(String[] args) {

		int n = 3;
		int ans = 0;
		int[][][] dp = new int[n + 1][4][3];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				for (int k = 0; k < dp[0][0].length; k++) {
					dp[i][j][k] = -1;
				}
			}

		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				ans = ans + CountDialer(n - 1, i, j, dp);
			}
		}
		System.out.println(ans);

	}

	private static int CountDialer(int n, int cr, int cc, int[][][] dp) {
		// TODO Auto-generated method stub

		if (cc < 0 || cr < 0 || cc >= 3 || cr >= 4 || (cr == 3 && cc == 0) || (cr == 3 && cc == 2)) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if(dp[n][cr][cc]!=-1)
		{
			return dp[n][cr][cc];
		}
		int[] r = { -2, -2, -1, 1, -1, 1, 2, 2 };
		int[] c = { 1, -1, -2, -2, 2, 2, -1, 1 };

		int count = 0;
		for (int i = 0; i < c.length; i++) {
			count += CountDialer(n - 1, cr + r[i], cc + c[i], dp);
		}
		return dp[n][cr][cc] = count;

//		int c1 = CountDialer(n - 1, cr - 2, cc + 1);
//		int c2 = CountDialer(n - 1, cr - 2, cc - 1);
//		int c3 = CountDialer(n - 1, cr - 1, cc - 2);
//		int c4 = CountDialer(n - 1, cr + 1, cc - 2);
//		int c5 = CountDialer(n - 1, cr - 1, cc + 2);
//		int c6 = CountDialer(n - 1, cr + 1, cc + 2);
//		int c7 = CountDialer(n - 1, cr + 2, cc - 1);
//		int c8 = CountDialer(n - 1, cr + 2, cc + 1);

		// return c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8;
	}

}
