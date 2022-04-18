package hash_maps;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

	public static void main(String[] args) throws IOException {
		List<Long> arr = Arrays.asList(2l, 2l, 2l, 2l);
//		List<Long> arr = Arrays.asList(1l, 3l, 9l, 9l, 27l, 81l);
//		List<Long> arr = Arrays.asList(1l, 5l, 5l, 25l, 125l);
//		List<Long> arr = Arrays.asList(1l, 2l, 1l, 2l, 4l);
		System.out.println(countTriplets(arr, 1));

	}

	static long countTriplets(List<Long> arr, long r) {
		long count = 0;
		Map<Long, Long> potitial = new HashMap<>();
		Map<Long, Long> doubles = new HashMap<>();

		for (Long item : arr) {
			Long prev = item / r;
			boolean isRatioApply = item % r == 0;

			if (doubles.containsKey(prev) && isRatioApply) {
				count += doubles.get(prev);
			}

			if (potitial.containsKey(prev) && isRatioApply) {
				doubles.put(item, doubles.getOrDefault(item, 0L) + potitial.get(prev));
			}

			// Every number could be a start of triplets
			potitial.put(item, potitial.getOrDefault(item, 0L) + 1);
		}

		return count;
	}

}
