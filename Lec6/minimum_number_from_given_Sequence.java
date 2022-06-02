package Lec6;

import java.util.*;

public class minimum_number_from_given_Sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "DDIIDIDD";
		minimum_number_from(str);

	}

	public static void minimum_number_from(String str) {
		int[] ans = new int[str.length() + 1];
		Stack<Integer> s = new Stack<>();
		int c = 1;
		for (int i = 0; i <= str.length(); i++) {
			if (i == str.length() || str.charAt(i) == 'I') {
				ans[i] = c;
				c++;
				while (!s.isEmpty()) {
					ans[s.pop()] = c;
					c++;
				}
			} 
			else {
				s.push(i);
			}

		}

		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

}
