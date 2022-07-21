package Lec19;

public class Coding_Blocks_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "3323";
		System.out.println(index(str));

	}

	public static int index(String s) {

		int n = s.length();
		int count = (1 << n) - 2;
		int pos = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '3') {
				count = count + (1 << pos);
			}
			pos++;
		}
		return count + 1;

	}

}
