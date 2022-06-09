package Lec8;

import java.math.BigInteger;
import java.util.*;


public class Additive_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str = "199100199";
		List<BigInteger> ans = new ArrayList<>();
		System.out.println(AdditiveNumber(str, ans));

	}

	public static boolean AdditiveNumber(String num, List<BigInteger> ans) {
		if (num.length() == 0) {
			if (ans.size() >= 3) {
				return true;
			}
			return false;
		}

		for (int i = 1; i <= num.length(); i++) {
			String ros = num.substring(0, i);
			String roq = num.substring(i);
			if (nonleadingzero(ros) == true && Vaildfib(ans, ros)) {
				ans.add(new BigInteger(ros));
				boolean fs = AdditiveNumber(roq, ans);
				if (fs == true) {
					return fs;
				}

				ans.remove(ans.size() - 1);

			}

		}
		return false;

	}

	public static boolean nonleadingzero(String str) {
		if (str.length() <= 1) {
			return true;
		}
		return str.charAt(0) != '0';
	}

	public static boolean Vaildfib(List<BigInteger> ans, String s) {
		if (ans.size() <= 1) {

			return true;

		}
		BigInteger num = new BigInteger(s);
		BigInteger st = ans.get(ans.size() - 2);
		BigInteger ss = ans.get(ans.size() - 1);

		return st.add(ss).equals(num);

	}

}
