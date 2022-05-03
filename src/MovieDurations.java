import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

public class MovieDurations {

	public static void main(String[] args) {
		Integer arr1[] = { 90, 85, 75, 60, 120, 150, 125 };
//		Integer arr1[] =  {90, 85, 75, 60, 155, 150, 125};
//		Integer arr1[] = { 90, 85, 75, 60, 120, 110, 110, 150, 125 };

		List<Integer> arr = Arrays.asList(arr1);
		System.out.println(Arrays.toString(movieDurations(arr, 250)));

	}

	static class Movie {
		int index;
		int duration;

		Movie(int index, int duration) {
			this.index = index;
			this.duration = duration;
		}
	}

	static int[] movieDurations(List<Integer> movieDurations, int d) {
		int target = d - 30;
		int longest = 0;
		int[] res = new int[2];
		List<Movie> movieD = new ArrayList<>();

		for (int i = 0; i < movieDurations.size(); i++) {
			movieD.add(new Movie(i, movieDurations.get(i)));
		}

		movieD.sort((a, b) -> {
			if (a.duration < b.duration) {
				return 1;
			}
			if (a.duration > b.duration) {
				return -1;
			}
			return 0;
		});

		for (Movie movie1 : movieD) {
			for (Movie movie2 : movieD) {
				if (movie1.index == movie2.index) {
					continue;
				}

				int dur = movie1.duration + movie2.duration;
				if (dur <= target) {
					if (dur > longest) {
						longest = dur;

						if (movie1.index < movie2.index) {
							res[0] = movie1.index;
							res[1] = movie2.index;
						} else {
							res[0] = movie2.index;
							res[1] = movie1.index;
						}
					} else {
						break;
					}
				}
			}
		}
		return res;
	}

}
