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

public class CheckMagazine {
	public static void main(String[] args) {
		List<String> magazine = Arrays.asList("give", "me", "one", "grand", "today", "night", "one");
		List<String> note = Arrays.asList("give", "one", "grand", "one");
		CheckMagazine.checkMagazine(magazine, note);
	}

		public static void checkMagazine(List<String> magazine, List<String> note) {
			Map<String, Integer> magazineWords = new HashMap<>();
	
			for (int i = 0; i < magazine.size(); i++) {
				String s = magazine.get(i);
				magazineWords.put(s, magazineWords.getOrDefault(s, 0) + 1);
	
			}
	
			for (int i = 0; i < note.size(); i++) {
				String n = note.get(i);
	
				if (!magazineWords.containsKey(n)) {
					System.out.println("No");
					return;
				}
				int usesLeft = magazineWords.get(n);
	
				if (usesLeft < 1) {
					System.out.println("No");
					return;
				}
				magazineWords.replace(n, usesLeft - 1);
			}
	
			System.out.println("Yes");
		}
}
