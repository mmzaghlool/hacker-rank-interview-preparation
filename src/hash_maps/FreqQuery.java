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

public class FreqQuery {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> ans = freqQuery(queries);

		System.out.println(ans.toString());

//		bufferedWriter.write(ans.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
//		bufferedWriter.close();
	}

//	public static void main(String[] args) {
//		List<List<Integer>> queries = Arrays.asList(Arrays.asList(null), Arrays.asList(null), Arrays.asList(null));
//		System.out.println(freqQuery(queries).toString());
//
//	}

	static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> d = new HashMap<>();
		Map<Integer, Integer> f = new HashMap<>();
//		int xx = 0;

		for (List<Integer> q : queries) {
			// 1: insert, 2: delete, 3: add to res
			int op = q.get(0);
			int data = q.get(1);

			if (op == 3) {
				res.add(f.getOrDefault(data, 0) > 0 ? 1 : 0);
//				xx++;
			} else {
				int prev = d.getOrDefault(data, 0);
				int current;
				if (op == 1) {
					current = prev + 1;
				} else {
					current = prev > 0 ? prev - 1 : 0;					
				}
				d.put(data, current);
				f.put(prev, f.getOrDefault(prev, 0) - 1);
				f.put(current, f.getOrDefault(current, 0) + 1);

			}
//			System.out.printf("op: %d, data: %d \n", op, data);
//			System.out.println("insert: " + d.toString());
//			System.out.println("res: " + res.toString());
//			System.out.println();
		}
//		System.out.println(xx);

		return res;
	}
}
