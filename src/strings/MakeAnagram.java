package strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MakeAnagram {

	public static void main(String[] args) {

		System.out.println(makeAnagram("cdeb", "abc"));

	}

	public static int makeAnagram(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();
		int count = 0;

		Map<Character, Integer> chars = new HashMap<>();

		for (int i = 0; i < lenA; i++) {
			char ch = a.charAt(i);
			chars.put(ch, chars.getOrDefault(ch, 0) + 1);
		}

		for (int i = 0; i < lenB; i++) {
			char ch = b.charAt(i);
			chars.put(ch, chars.getOrDefault(ch, 0) - 1);
		}

		for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
			Integer v = entry.getValue();

			count += Math.abs(v);
		}

		return count;
	}

}
