package greedy;

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

public class MinimumAbsoluteDifference {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int result = minimumAbsoluteDifference(arr.toArray(new Integer[n]));

		System.out.println(result);
		bufferedReader.close();

	}

	public static int minimumAbsoluteDifference(Integer[] arr) {
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length - 1; i++) {
			int current = arr[i];
			int next = arr[i + 1];

			min = Math.min(min, Math.abs(current - next));
		}

		return min;
	}
}
