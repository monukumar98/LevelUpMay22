package Lec7;

import java.util.*;

public class Different_Way_to_Add_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "2*3-4*5";
		System.out.println(diffWaysToCompute(str));

	}

	public static boolean isoperator(char ch) {
		if (ch == '+' || ch == '-' || ch == '*') {
			return true;
		}
		return false;
	}

	public static int Calculate(int a, int b, char oper) {

		if (oper == '+') {
			return a + b;
		} else if (oper == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}

	public static List<Integer> diffWaysToCompute(String s) {
		if (s.indexOf('+') == -1 && s.indexOf('-') == -1 && s.indexOf('*') == -1) {
			List<Integer> ll = new ArrayList<Integer>();
			ll.add(Integer.parseInt(s));
			return ll;

		}
		List<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (isoperator(ch)) {

				List<Integer> left = diffWaysToCompute(s.substring(0, i));
				List<Integer> right = diffWaysToCompute(s.substring(i + 1));

				for (int a : left) {
					for (int b : right) {
						int val = Calculate(a, b, ch);
						ans.add(val);
					}
				}
			}

		}
		return ans;

	}

}
