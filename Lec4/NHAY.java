package Lec4;

import java.util.Scanner;

public class NHAY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {

			int n = sc.nextInt();
			String pt = sc.next();
			String text = sc.next();
			lps(pt, text);

		}

	}

	public static void lps(String pt, String text) {
		String s = pt + "#" + text;
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
		for (int j = pt.length() + 1; j < dp.length; j++) {
			if (dp[j] == pt.length()) {
				System.out.println(j - 2 * pt.length());// start

			}
		}

	}

}
