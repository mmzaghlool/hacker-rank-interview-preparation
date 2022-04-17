package strings;

import java.util.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommonChild {

	public static void main(String[] args) {
		System.out.println(commonChild("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS",
				"FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC"));
//		System.out.println(commonChild("ABCDEF", "FBDAMN"));
	}

	public static int commonChild(String s1, String s2) {
		int[][] s = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					s[i + 1][j + 1] = s[i][j] + 1;
				} else {
					s[i + 1][j + 1] = Math.max(s[i + 1][j], s[i][j + 1]);
				}
			}
		}

//		for (int i = 0; i < s.length; i++) {
//			System.out.println(Arrays.toString(s[i]));
//
//		}

		return s[s1.length()][s2.length()];
	}

}
