package Lec3;

public class Lps_Kmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabaacaabbabaaa";
		System.out.println(lps(str));

	}

	public static String lps(String s) {
		int dp[] = new int[s.length()];
		int i = 1;
		int len = 0;
		while (i < s.length()) {
			if (s.charAt(i) == s.charAt(len)) {
				len++;
				dp[i] = len;
				i++;
			}

			else {
				if (len > 0)
					len = dp[len - 1];// 2
				else {
					dp[i] = 0;
					i++;
				}
			}

		}

		return s.substring(0, dp[s.length() - 1]);

	}

}
