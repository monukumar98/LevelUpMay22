package Lec3;

public class Hashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ram";
		System.out.println(s.hashCode());
		System.out.println(HasCode(s));

	}

	public static long HasCode(String s) {
		long mod = 1000000007;
		int p = 31;
		long pow = 1;
		long hv = 0;
		for (int i = 0; i < s.length(); i++) {
			hv = (hv + ((s.charAt(i) - 'a' + 1) * pow) % mod) % mod;

			pow = (pow * p) % mod;

		}
		return hv;

	}

}
