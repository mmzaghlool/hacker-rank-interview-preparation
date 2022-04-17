package strings;

import java.util.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommonChild {

	public static void main(String[] args) {
		System.out.println(commonChild("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS",
				"FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC"));
	}

	public static int commonChild(String s1, String s2) {
		if (equals(s1, s2)) {
			return s1.length();
		}
		Map<Character, Boolean> charsS1 = getChars(s1);
		Map<Character, Boolean> charsS2 = getChars(s2);

		s1 = removeExtraChars(s1, charsS2);
		s2 = removeExtraChars(s2, charsS1);
		System.out.println(s1);
		System.out.println(s2);

		String[] sub1 = getSubstrings(s1);
		sort(sub1);
		String[] sub2 = getSubstrings(s2);
		sort(sub2);
		return getCommonCount(sub1, sub2);
	}

//	public static int getCommonCount(String[] sub1, String[] sub2) {
//		String[] sub;
//		String str;
//
//		if (sub1.length < sub2.length) {
//			sub = sub1;
//			str = String.join(",", sub2);
//		} else {
//			sub = sub2;
//			str = String.join(",", sub1);
//		}
//
//		sort(sub);
//
//		for (int i = 0; i < sub.length; i++) {
//			String s1 = sub[i];
//			System.out.println(i + " " + s1 + " " + s1.length());
//
//			if (str.contains(s1)) {
//				return s1.length();
//			}
//		}
//
//		return 0;
//	}

	public static int getCommonCount(String[] sub1, String[] sub2) {

		for (int i = sub1.length - 1; i >= 0; i--) {
			String s1 = sub1[i];
			int len1 = s1.length();
			for (int j = sub2.length - 1; j >= 0; j--) {
				String s2 = sub2[j];
				int len2 = s2.length();

				if (len2 < len1) {
					break;
				}

				if (len2 > len1) {
					continue;
				}
				if (len1 == 15) {

					System.out.println(s1 + " - " + s2);
				}

//				System.out.println(i + " " + s1 + " " + s1.length());

				if (equals(s1, s2)) {
					return len1;
				}
			}
		}

		return 0;
	}

	public static boolean equals(final String s1, final String s2) {
		int len1 = s1.length();
		for (int i = 0; i < len1; i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			if (c1 != c2) {
				return false;
			}

		}
		return true;
	}
//	
//	public static boolean equals(final String s1, final String s2) {
//		return s1.hashCode() == s2.hashCode() && s1.equals(s2);
//	}

	public static void sort(String[] sub) {

		Arrays.sort(sub, (a, b) -> Integer.compare(a.length(), b.length()));
	}

	public static String[] getSubstrings(String str) {
		int len = str.length();
		List<String> l = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				l.add(str.substring(i, j));
			}
		}

		System.out.println(l.toString());

		return l.toArray(new String[l.size()]);
	}

	public static String removeExtraChars(String str, Map<Character, Boolean> chars) {
		int len = str.length();
		String res = new String();

		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if (chars.containsKey(c))
				res += c;
		}

		return res;
	}

	public static Map<Character, Boolean> getChars(String str) {
		int len = str.length();
		Map<Character, Boolean> chars = new HashMap<>();

		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			chars.put(c, true);
		}

		return chars;
	}

}
