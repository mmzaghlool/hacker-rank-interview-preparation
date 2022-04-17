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

public class ArrayManipulation {

	public static void main(String[] args) {
		List<List<Integer>> arr = Arrays.asList(Arrays.asList(2, 8, 1000000000), Arrays.asList(2, 3, 7), Arrays.asList(2, 10, 1000000000),
				Arrays.asList(8, 9, 1000000000));

		System.out.println(ArrayManipulation.arrayManipulation(10, arr));
	}

	public static long arrayManipulation(int n, List<List<Integer>> queries) {
		List<Integer> arr = new ArrayList<>(n);

		// Fill array with zeros
		for (int i = 0; i < n; i++) {
			arr.add(0);
		}

		for (int i = 0; i < queries.size(); i++) {
			List<Integer> query = queries.get(i);
			int a = query.get(0);
			int b = query.get(1);
			int k = query.get(2);

			arr.set(a - 1, arr.get(a - 1) + k);
			if (b < n) {
				arr.set(b, arr.get(b) - k);
			}

//			System.out.println(arr.toString());
		}

		long max = Integer.MIN_VALUE;
		long prev = 0;
		for (int i = 0; i < n; i++) {
			long x = arr.get(i) + prev;
			if (x > max) {
				max = x;
			}
			prev = x;
		}

		return max;
	}
}
