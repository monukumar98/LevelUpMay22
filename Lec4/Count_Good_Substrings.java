package Lec4;

import java.util.Scanner;

public class Count_Good_Substrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Good_Substrings(str);

	}

	public static void Good_Substrings(String str) {
		int[][] arr = new int[2][2];
		long odd = 0;
		long even = 0;
		for (int i = 1; i <= str.length(); i++) {
			odd++;
			if (i % 2 != 0) {// odd track
				odd += arr[str.charAt(i - 1) - 'a'][0];// odd + prev value addkiya
				arr[str.charAt(i - 1) - 'a'][0]++;
				even += arr[str.charAt(i - 1) - 'a'][1];

			} else {// even track

				odd += arr[str.charAt(i - 1) - 'a'][1];//
				arr[str.charAt(i - 1) - 'a'][1]++;
				even += arr[str.charAt(i - 1) - 'a'][0];

			}

		}
		System.out.println(even + " " + odd);

	}

}
