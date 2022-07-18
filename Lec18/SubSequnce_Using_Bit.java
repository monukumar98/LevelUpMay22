package Lec18;

public class SubSequnce_Using_Bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABC";
		PrintSubsequne(str);

	}

	public static void PrintSubsequne(String str) {

		int len = str.length();
		for (int i = 0; i < (1 << len); i++) {
			printPattern(str, i);

		}

	}

	private static void printPattern(String str, int i) {

		// TODO Auto-generated method stub
		int pos = 0;
		while (i != 0) {
			if ((i & 1) != 0) {
				System.out.print(str.charAt(pos));

			}

			pos++;
			i >>= 1;
		}
		System.out.println();

	}

}
