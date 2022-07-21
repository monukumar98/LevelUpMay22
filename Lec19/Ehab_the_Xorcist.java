package Lec19;

import java.util.Scanner;

public class Ehab_the_Xorcist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long u = sc.nextLong();
		long v = sc.nextLong();
		if (u % 2 != v % 2 || u > v) {
			System.out.println(-1);
		} else if (u == v) {
			if (u == 0) {
				System.out.println(0);
			} else {
				System.out.println(1);
				System.out.println(v);
			}

		} else {
			long x = (v - u) / 2;
			if ((u & x) == 0) {
				System.out.println(2);
				System.out.println(u + x + " " + x);
			} else {
				System.out.println(3);
				System.out.println(u + " " + x + " " + x);

			}

		}

	}
}
