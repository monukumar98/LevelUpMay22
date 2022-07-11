package Lec16;


import java.util.*;

public class Alien_Dictionary {

	HashMap<Character, HashMap<Character, Integer>> map = new HashMap<>();
	int[] indgree = new int[26];

	public String alienOrder(String[] words) {

		for (int i = 0; i < words.length; i++) {

			for (char ch : words[i].toCharArray()) {
				if (!map.containsKey(ch)) {
					map.put(ch, new HashMap<>());
				}
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			if (word1.startsWith(word2) && word1.length() > word2.length()) {
				return "";

			}

			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					HashMap<Character, Integer> nbrs = map.get(word1.charAt(j));
					if (!nbrs.containsKey(word2.charAt(j))) {
						nbrs.put(word2.charAt(j), 0);
						indgree[word2.charAt(j) - 'a']++;
					}
					break;
				}

			}

		}
		Queue<Character> qq = new LinkedList<>();

		for (char key : map.keySet()) {
			if (indgree[key - 'a'] == 0) {
				qq.add(key);
			}

		}
		StringBuilder sb = new StringBuilder();

		while (!qq.isEmpty()) {

			char ch = qq.poll();
			sb.append(ch);

			for (char nbrs : map.get(ch).keySet()) {
				indgree[nbrs - 'a']--;
				if (indgree[nbrs - 'a'] == 0) {
					qq.add(nbrs);
				}
			}

		}

		return sb.toString().length() < map.size() ? "" : sb.toString();

	}

	public static void main(String[] args) {
		Alien_Dictionary ad = new Alien_Dictionary();
		String words[] = { "ac", "ab", "zc", "zb" };
		System.out.println(ad.alienOrder(words));

	}

}
