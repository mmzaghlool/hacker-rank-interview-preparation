package hash_maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SherlockAndAnagrams {

	public static void main(String[] args) {

		System.out.println(sherlockAndAnagrams("abba"));
	}

	public static int sherlockAndAnagrams(String s) {
		int len = s.length();
		int res = 0;

		Map<String, Integer> anagrams = new HashMap<>();
		// Get all sub strings
		String[] list = subString(s);
		System.out.println(Arrays.toString(list));

		for (int i = 0; i < list.length; i++) {
			String subStr = list[i];
			anagrams.put(subStr, anagrams.getOrDefault(subStr, 0) + 1);
		}
		
//		System.out.println(anagrams.toString());

		int[] fac = new int[len];
		fac[0] = 0;

		for (int i = 1; i < fac.length; i++) {
			fac[i] = fac[i - 1] + i;
		}

		for (Integer v : anagrams.values()) {
			res += fac[v - 1];
		}

		return res;
	}

	/**
	 * Get all substrings Complexity n2
	 * 
	 * @param str
	 * @return
	 */
	static String[] subString(String str) {
		List<String> res = new ArrayList<String>();

		for (int i = 1; i <= str.length(); i++) {
			for (int j = 0; j <= str.length() - i; j++) {
				res.add(sort(str.substring(j, i + j)));
			}
		}

		return res.toArray(new String[0]);
	}

	static String sort(String s) {
		char[] r = s.toCharArray();
		Arrays.sort(r);
		return new String(r);
	}

}
