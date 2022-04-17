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

public class JumpingOnClouds {

	public static void main(String[] args) {
		List<Integer> x = Arrays.asList(0, 0, 1, 0, 0, 0, 0, 1, 0, 0);
//		List<Integer> x = Arrays.asList(0, 0, 1, 0, 0, 1, 0);
//		List<Integer> x = Arrays.asList(0, 0, 0, 1, 0, 0);
		System.out.println(JumpingOnClouds.jumpingOnClouds(x));

	}

	public static int jumpingOnClouds(List<Integer> c) {

		int j = 0;
		for (int i = 1; i < c.size(); i++) {
			int next = c.get(i);
			if (i + 1 < c.size()) {
				next = c.get(i + 1);
			}

			if (next == 0)
				i++;

			j++;
		}

		return j;

	}

}
