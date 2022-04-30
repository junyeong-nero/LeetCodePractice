package DataStructure;

import java.util.HashMap;
import java.util.LinkedList;

class WordDictionary {

	HashMap<Integer, LinkedList<String>> map;

	public WordDictionary() {
		map = new HashMap<>();
	}

	public void addWord(String word) {
		int n = word.length();
		LinkedList<String> list = map.containsKey(n) ? map.get(n) : new LinkedList<>();
		list.add(word);
		map.put(n, list);
	}

	public boolean search(String word) {
		int n = word.length();
		if (map.containsKey(n)) {
			for (String s : map.get(n))
				if (match(word, s))
					return true;
			return false;
		} else
			return false;
	}

	public boolean match(String pattern, String target) {
		assert (pattern.length() == target.length());
		int n = target.length();
		for (int i = 0; i < n; i++) {
			if (!(pattern.charAt(i) == target.charAt(i) || pattern.charAt(i) == '.'))
				return false;
		}
		return true;
	}
}