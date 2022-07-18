package Lec18;

public class Catalan_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		System.out.println(Catalannumber(n));

	}

	public static int Catalannumber(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = ans + (Catalannumber(i - 1) * Catalannumber(n - i));

		}
		return ans;
	}

}
