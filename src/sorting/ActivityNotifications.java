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

public class ActivityNotifications {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int d = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int result = activityNotifications(expenditure.toArray(new Integer[n]), d);
		System.out.println(result);

		bufferedReader.close();
	}

	public static int activityNotifications(Integer[] expenditure, int d) {
		int notif = 0;
		boolean isEven = d % 2 == 0;

		int[] counts = new int[201];
		for (int i = 0; i < d; i++) {
			counts[expenditure[i]]++;
		}

		if (isEven) {
			for (int i = d; i < expenditure.length; i++) {
				int e = expenditure[i];
				int med = medianEven(counts, d);
				if (e >= med) {
					notif++;
				}

				counts[expenditure[i]]++;
				counts[expenditure[i - d]]--;
			}

		} else {

			for (int i = d; i < expenditure.length; i++) {
				int e = expenditure[i];
				int med = medianOdd(counts, d);
				if (e >= 2 * med) {
					notif++;
				}

				counts[expenditure[i]]++;
				counts[expenditure[i - d]]--;

			}
		}

		return notif;
	}

	public static int medianEven(int[] counts, int d) {
		int medIndex2 = d / 2, medIndex1 = medIndex2 + 1;
		int medNum1 = -1, medNum2 = -1;
		int c = 0;

		for (int i = 0; i < counts.length; i++) {
			c += counts[i];

			if (medIndex1 == c) {
				medNum1 = i;
			} else if (medIndex2 == c) {
				medNum2 = i;

			}
			if (medNum1 != -1 && medNum2 != -1) {
				return medNum1 + medNum2;
			}
		}

		return 0;
	}

	public static int medianOdd(int[] counts, int d) {
		int oddMedIndex = Math.floorDiv(d, 2);
		int c = 0;

		for (int i = 0; i < counts.length; i++) {
			c += counts[i];

			if (c > oddMedIndex) {
				return i;
			}
		}

		return 0;
	}
}
