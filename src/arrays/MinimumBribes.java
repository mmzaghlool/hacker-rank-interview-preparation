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

public class MinimumBribes {

	public static void main(String[] args) {
//		List<Integer> arr = Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4);
//		List<Integer> arr = Arrays.asList(5, 1, 2, 3, 7, 8, 6, 4);
		List<Integer> arr = Arrays.asList(2, 1, 5, 3, 4);

		MinimumBribes.minimumBribes(arr);
	}

	public static void minimumBribes(List<Integer> q) {
		int size = q.size();

		HashMap<Integer, Integer> initInd = new HashMap<>();
		HashMap<Integer, Integer> initPos = new HashMap<>();
		int bribes = 0;

		// Default values
		for (int i = 0; i < size; i++) {
			initPos.put(i + 1, i);
			initInd.put(i, i + 1);
		}

		for (int i = 0; i < size; i++) {
			int position = q.get(i);
			int current = initPos.get(position);

//			System.out.println(position + ", " + current);

			if (i > current) {
				continue;
			}

			if (current - i > 2) {
				System.out.println("Too chaotic");
				return;
			}

			for (int j = current; j > i; j--) {
//				System.out.println(position + " --- " + j + ", " + (j - 1));
				swap(initInd, initPos, j, j - 1);
				bribes++;
			}

		}

		System.out.println(bribes);
	}

	static int getIndex(int[] arr, int e) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == e) {
				return i;
			}
		}

		return -1;
	}

	static void swap(HashMap<Integer, Integer> initInd, HashMap<Integer, Integer> initPos, int index1, int index2) {
		int element1 = initInd.get(index1);
		int element2 = initInd.get(index2);

		initInd.replace(index1, element2);
		initInd.replace(index2, element1);

		initPos.replace(element2, index1);
		initPos.replace(element1, index2);
	}

}
