package Lec15;

import java.util.*;

public class Word_Break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String[] Dict = { "coding", "blocks", "is", "the", "best", "Institute",
		// "coddingblocks" };
		List<String> wordDict = new ArrayList<>();
		wordDict.add("coding");
		wordDict.add("blocks");
		wordDict.add("is");
		wordDict.add("the");
		wordDict.add("best");
		wordDict.add("Institute");
		wordDict.add("codingblocks");

		String s = "codingblocksisthebestInstitute";
		System.out.println(wordBreak(s, wordDict));

	}

	public static boolean wordBreak(String s, List<String> wordDict) {

		int[] dp = new int[s.length()];
		HashSet<String> set = new HashSet<>(wordDict);
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {

				String s1 = s.substring(j, i + 1);
				if (set.contains(s1)) {
					if (j > 0)
						dp[i] = dp[i] + dp[j - 1];
					else {
						dp[i]++;
					}
				}

			}

		}
		return dp[s.length()-1] > 0;

	}

}
