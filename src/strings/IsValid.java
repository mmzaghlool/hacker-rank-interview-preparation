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

public class IsValid {

	public static void main(String[] args) {
		System.out.println(isValid("aabbcd"));

	}

	public static String isValid(String s) {
		int len = s.length();
		Map<Character, Integer> chars = new HashMap<>();

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);

			chars.put(c, chars.getOrDefault(c, 0) + 1);
		}
		int mean = Math.round((float) len / chars.size());

		for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
			Integer v = entry.getValue();

			if (mean - v > 1 && v == 1) {
				mean = Math.round((float) len / (chars.size() - 1));
			}
		}

//		System.out.println(chars.toString());
//		System.out.println("L: " + len);
//		System.out.println("S: " + chars.size());
//		System.out.println("M: " + mean);
		boolean firstWrongOccurred = false;

		for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
			Integer v = entry.getValue();

			if (v != mean) {
//				System.out.println("V: " + v + ", f: " + firstWrongOccurred + Math.abs(v - mean) + " - " + (mean - 1));
				if (!firstWrongOccurred && (Math.abs(v - mean) == (mean - 1) || Math.abs(v - mean) == (mean + 1))) {
					firstWrongOccurred = true;
				} else {
					return "NO";
				}
			}
		}

		return "YES";
	}

}
