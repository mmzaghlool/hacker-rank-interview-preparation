package arrays;

import java.io.*;
import java.lang.reflect.Array;
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

public class HourglassSum {

	public static void main(String[] args) {

		List<List<Integer>> arr = Arrays.asList(Arrays.asList(1, 1, 1, 0, 0, 0), Arrays.asList(0, 1, 0, 0, 0, 0),
				Arrays.asList(1, 1, 1, 0, 0, 0), Arrays.asList(0, 0, 2, 4, 4, 0), Arrays.asList(0, 0, 0, 2, 0, 0),
				Arrays.asList(0, 0, 1, 2, 4, 0));

		System.out.println(HourglassSum.hourglassSum(arr));
	}

	public static int hourglassSum(List<List<Integer>> arr) {
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println("i: " + i + " , j: " + j);
				int[][] itemsIndexes = new int[][] { { i, i + 1, i + 2 }, { i + 1 }, { i, i + 1, i + 2 } };
				int sum = 0;
				for (int k = 0; k < itemsIndexes.length; k++) {
					for (int k2 = 0; k2 < itemsIndexes[k].length; k2++) {
						int x = arr.get(j + k).get(itemsIndexes[k][k2]);
						sum += x;
					}
				}

				if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}

		return maxSum;
	}

}
