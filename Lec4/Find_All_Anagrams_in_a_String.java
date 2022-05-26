package Lec4;

import java.util.*;

public class Find_All_Anagrams_in_a_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abacshgsjabc";
		String p = "abc";
		System.out.println(findAnagrams(s, p));
	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> ll = new ArrayList<>();

		int[] frp = new int[26];
		int[] frs = new int[26];
		for (int i = 0; i < p.length(); i++) {
			frp[p.charAt(i) - 'a']++;

		}
		// 1st window
		for (int i = 0; i < p.length() && i < s.length(); i++) {
			frs[s.charAt(i) - 'a']++;

		}

		if (compare(frs, frp)) {
			ll.add(0);
		}
       // 2next window 
		for (int i = p.length(); i < s.length(); i++) {
			frs[s.charAt(i) - 'a']++;//add 

			char ch = s.charAt(i - p.length());
			frs[ch - 'a']--;//remove 

			if (compare(frs, frp)) {
				ll.add(i - p.length() + 1);
			}

		}
		return ll;

	}

	private static boolean compare(int[] frs, int[] frp) {
		// TODO Auto-generated method stub

		for (int i = 0; i < frp.length; i++) {
			if (frp[i] != frs[i]) {
				return false;
			}
		}
		return true;

	}

}
