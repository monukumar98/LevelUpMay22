package Lec11;

public class Wildcard_Matching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "baabab";
		String p = "b*?ab";
		int[][] dp = new int[s.length()][p.length()];
		System.out.println(WildcardMatching(s, p, 0, 0,dp));

	}

// i --> s.length() j --> p.length()
	public static boolean WildcardMatching(String s, String p, int i, int j, int[][] dp) {

		if (i == s.length()) {
			for (int j2 = j; j2 < p.length(); j2++) {
				if (p.charAt(j2) != '*') {
					return false;
				}

			}
			return true;
		}
		if (j == p.length()) {
			return false;
		}
		if (dp[i][j] != 0) {
			return dp[i][j] == 1 ? true : false;
		}

		boolean ans;

		if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
			ans = WildcardMatching(s, p, i + 1, j + 1, dp);
		} else if (p.charAt(j) == '*') {
			boolean match = WildcardMatching(s, p, i + 1, j, dp);
			boolean dontmatch = WildcardMatching(s, p, i, j + 1, dp);
			ans = match || dontmatch;
		} else {
			ans = false;
		}
		if (ans) {
			dp[i][j] = 1;
		} else {
			dp[i][j] = 2;
		}
		return ans;

	}

}
