package arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwaps {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };

		System.out.println(MinimumSwaps.minimumSwaps(arr));
	}

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int len = arr.length;
		int swapCount = 0;
		HashMap<Integer, Integer> originalIndex = getOriginalFirstIndex(arr, len);

		while (!originalIndex.isEmpty()) {
			Map.Entry<Integer, Integer> entry = originalIndex.entrySet().iterator().next();
			Integer k = entry.getKey();
			Integer v = entry.getValue();

			swap(arr, k, v);

			originalIndex = getOriginalFirstIndex(arr, len);
			swapCount++;
		}

		return swapCount;
	}

	static HashMap<Integer, Integer> getOriginalFirstIndex(int[] arr, int len) {
		HashMap<Integer, Integer> originalIndex = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			int e = arr[i];
			if (e != i + 1) {
				originalIndex.put(i, e - 1);
				return originalIndex;
			}
		}

		return originalIndex;
	}

	static void swap(int[] arr, int index1, int index2) {
		int element1 = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = element1;
	}

}
