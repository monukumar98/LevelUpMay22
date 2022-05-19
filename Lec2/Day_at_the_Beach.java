package Lec2;

import java.util.Scanner;

public class Day_at_the_Beach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		int[] leftmax = new int[n + 1];
		int right[] = new int[n + 1];

		leftmax[0] = Integer.MIN_VALUE;
		right[n] = Integer.MAX_VALUE;
		for (int i = 1; i < right.length; i++) {
			leftmax[i] = Math.max(leftmax[i - 1], a[i - 1]);

		}
		for (int i = n - 1; i >= 0; i--) {
			right[i] = Math.min(right[i + 1], a[i]);

		}
		int pt=1;
		for (int i = 1; i < n; i++) {
			
			if(leftmax[i]<=right[i]) {
				pt++;
			}
			
		}
		System.out.println(pt);
		

	}

}
