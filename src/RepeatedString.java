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

public class RepeatedString {

	public static void main(String[] args) {

		System.out.println(RepeatedString.repeatedString("aba", 10));
	}

	public static long repeatedString(String s, long n) {
		long count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'a') {
				count++;
			}
		}

		long freq = Math.floorDiv(n, s.length());
		long result = freq * count;

		for (int i = 0; i < n - freq * s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'a') {
				result++;
			}
		}

		return result;

	}

//	public static long repeatedString(String s, long n) {
//		String repeated = ""; 
//		
//		while (repeated.length() < n) {
//			repeated = repeated.concat(s);
//		}
//		
//		
//		long result = 0;
//		for (int i = 0; i < n; i++) {
//			char c = repeated.charAt(i);
//			if (c == 'a') {
//				result++;
//			}
//		}
//		
//		return result;
//
//    }

}
