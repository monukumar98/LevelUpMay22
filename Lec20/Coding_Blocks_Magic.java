package Lec20;

public class Coding_Blocks_Magic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 45;
		System.out.println(BlocksNumber(n));

	}

	public static long BlocksNumber(int n) {

		long mul = 4;
		long ans = 0;
		while (n != 0) {
			if ((n & 1) != 0) {
				ans = ans + mul;
			}
			n >>= 1;
			mul *= 4;
		}
		return ans;

	}
}
