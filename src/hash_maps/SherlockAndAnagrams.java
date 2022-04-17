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

public class SherlockAndAnagrams {

	public static void main(String[] args) {

		System.out.println(sherlockAndAnagrams("abcd"));
	}

	public static int sherlockAndAnagrams(String s) {
		int len = s.length();
		int res = 0;
		Map<String, Integer> anagrams = new HashMap<>();
		String[] list = subString(s, s.length());
		int size = list.length;

		for (int i = 0; i < size; i++) {
			String subStr = list[i];
			boolean cont = false;

			for (Map.Entry<String, Integer> entry : anagrams.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
				boolean isSubAnagram = compare(subStr, key);

				if (isSubAnagram) {
					anagrams.put(key, value + 1);
					cont = true;
					break;
				}
			}

			if (!cont) {
				anagrams.put(subStr, 1);
			}
		}
//		System.out.println(anagrams.toString());

		int[] fac = new int[len];
		fac[0] = 0;

		for (int i = 1; i < fac.length; i++) {
			fac[i] = fac[i - 1] + i;
		}

		for (Map.Entry<String, Integer> entry : anagrams.entrySet()) {
			Integer v = entry.getValue();
			res += fac[v - 1];
		}

		return res;
	}

	static String[] subString(String str, int n) {
		List<String> res = new ArrayList<String>();

		for (int len = 1; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				int j = i + len - 1;

				res.add(str.substring(i, j + 1));
			}
		}

		return res.toArray(new String[0]);
	}

	static boolean compare(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();

		if (len1 != len2) {
			return false;
		}

		Map<Character, Integer> chars = new HashMap<>();

		for (int i = 0; i < len1; i++) {
			char ch = str1.charAt(i);
			chars.put(ch, chars.getOrDefault(ch, 0) + 1);
		}

		for (int i = 0; i < len2; i++) {
			char ch = str2.charAt(i);
			int old = chars.getOrDefault(ch, 0);
			if (old < 1) {
				return false;
			}
			chars.put(ch, old - 1);
		}

		for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
			Integer val = entry.getValue();
			if (val != 0) {
				return false;
			}
		}

		return true;
	}

}
