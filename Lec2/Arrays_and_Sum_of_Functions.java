package Lec2;

import java.util.*;

public class Arrays_and_Sum_of_Functions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] a = new long[n];
		Integer[] b = new Integer[n];
		int mod = 998244353;
		for (int i = 0; i < b.length; i++) {
			a[i] = sc.nextLong();
			a[i] = a[i] * (i + 1) * (n - i);

		}

	
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
		Arrays.sort(a);// inc

		Arrays.sort(b, Collections.reverseOrder());// dec
		long ans = 0;
		for (int i = 0; i < b.length; i++) {
			ans = ans + (a[i] % mod * b[i]);
			ans %= mod;

		}
		System.out.println(ans);

	}

}
