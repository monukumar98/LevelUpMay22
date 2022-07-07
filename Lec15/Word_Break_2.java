package Lec15;

import java.util.*;

public class Word_Break_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> wordDict = new ArrayList<>();
		wordDict.add("coding");
		wordDict.add("blocks");
		wordDict.add("is");
		wordDict.add("the");
		wordDict.add("isthe");
		wordDict.add("best");
		wordDict.add("istheInstitute");
		wordDict.add("Institute");
		wordDict.add("codingblocks");
		List<String> list = new ArrayList<>();
		String s = "codingblocksisthebestInstitute";
		Set<String> set = new HashSet<>(wordDict);
		WordBreak(s, set, "",list);
		System.out.println(list);
	}

//	public List<String> wordBreak(String s, List<String> wordDict) {
//
//		List<String> list = new ArrayList<>();
//		WordBreak(s, wordDict, "");
//
//	}

	private static void WordBreak(String s, Set<String> wordDict, String ans,List<String> list ) {
		// TODO Auto-generated method stub
		if (s.length() == 0) {
			//System.out.println(ans);
			list.add(ans);
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			String s1 = s.substring(0, i + 1);
			if (wordDict.contains(s1)) {
				WordBreak(s.substring(i + 1), wordDict, ans + s1 + " ",list);
			}

		}

	}

}
