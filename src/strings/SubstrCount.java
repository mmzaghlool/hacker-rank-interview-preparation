package strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SubstrCount {

	public static void main(String[] args) {
		String str = "abcbaba";
		System.out.println(substrCount(str.length(), str));
	}

	static long substrCount(int n, String s) {

		return countSpeacial(s, n);
	}

	public static long countSpeacial(String s, int n) {
		long count = 0;

		for (int i = 0; i < n; i++) {
			char firstChar = s.charAt(i);
			boolean first = false;
			int beforeX = 0;
			int index = 0;

			for (int j = i; j < n; j++) {
				char c = s.charAt(j);
//				System.out.print(c);

				if (c != firstChar && !first) {
					first = true;
					beforeX = index;

				} else if (c != firstChar) {
					break;
				}

				if (!first) {
//					System.out.print("++");
					count++;
				} else if (c == firstChar && index == beforeX * 2) {
					count++;
//					System.out.print("(++)");

					break;

				}
				index++;
			}
//			System.out.println("");
		}

		return count;
	}

}
