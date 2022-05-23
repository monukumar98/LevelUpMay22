package Lec3;

import java.util.ArrayList;
import java.util.Scanner;

public class NAJPF_Spoj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String s = sc.next();
			String p = sc.next();

			Rabinkarp(s, p);
		}

	}

	private static void Rabinkarp(String s, String p) {
		// TODO Auto-generated method stub
		long mod = 1000000007;
		long[] dp = new long[s.length()];
		long[] pa = new long[s.length()];
		int pr = 31;
		long hv = 0;
		long pow = 1;
		for (int i = 0; i < p.length(); i++) {
			hv = (hv + ((p.charAt(i) - 'a' + 1) * pow) % mod) % mod;
			pow = (pow * pr) % mod;

		}

		dp[0] = s.charAt(0) - 'a' + 1;
		pa[0] = 1;
		pow = pr;
		for (int i = 1; i < s.length(); i++) {
			dp[i] = (dp[i - 1] + ((s.charAt(i) - 'a' + 1) * pow) % mod) % mod;
			pa[i] = pow;
			pow = (pow * pr) % mod;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int ei = p.length() - 1, si = 0; ei < s.length(); ei++, si++) {
			long currhash = dp[ei];
			if (si > 0) {
				currhash = (currhash - dp[si - 1] + mod) % mod;
			}
			if (currhash == (hv * pa[si]) % mod) {
				list.add(si);
			}

		}

		if (list.size() == 0) {
			System.out.println("Not Found");
		} else {
			System.out.println(list.size());
			for (int v : list) {
				System.out.print(v + 1 + " ");
			}
			System.out.println();
		}

	}

}
