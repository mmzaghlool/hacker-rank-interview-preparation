package arrays;

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

public class LeftRotation {

	public static void main(String[] args) {

		List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(LeftRotation.rotLeft(arr, 4));
	}

	public static List<Integer> rotLeft(List<Integer> a, int d) {
		int size = a.size();
		List<Integer> result = new ArrayList<Integer>(size);
		for (int i = 0; i < size; i++) {
			result.add(null);
		}

		for (int i = 0; i < size; i++) {
			int newIndex = (i - d);
			if (newIndex < 0) {
				newIndex = size + newIndex;
			}
			result.set(newIndex, a.get(i));
		}

		return result;
	}
}
