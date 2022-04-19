package sorting;

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

public class MaximumToys {

	public static int maximumToys(Integer[] prices, int k) {
		int bought = 0;
		int spent = 0;

		Arrays.sort(prices);

		for (int i = 0; i < prices.length; i++) {
			int price = prices[i];

			if (spent + price > k) {
				break;
			}

			spent += price;
			bought++;
		}

		return bought;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int result = maximumToys(prices.toArray(new Integer[n]), k);

		System.out.println(result);
		bufferedReader.close();

	}

}
