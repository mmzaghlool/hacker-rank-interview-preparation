package hash_maps;

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

public class TwoStrings {

	public static void main(String[] args) {
		System.out.println(TwoStrings.twoStrings("hi", "world"));

	}

	public static String twoStrings(String s1, String s2) {
		HashMap<Character, Boolean> map = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			map.put(c, true);
		}

		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			boolean isSub = map.getOrDefault(c, false);

			if (isSub == true) {
				return "YES";
			}
		}

		return "NO";
	}
}
