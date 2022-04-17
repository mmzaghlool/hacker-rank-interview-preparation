package strings;

import java.util.Iterator;

public class AlternatingCharacters {

	public static void main(String[] args) {

		System.out.println(alternatingCharacters("AAABBB"));
	}

	public static int alternatingCharacters(String s) {
		int len = s.length();
		int count = 0;

		char prev = 'Z';
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);

			if (prev == c) {
				count++;
			}

			prev = c;
		}

		return count;
	}
}
