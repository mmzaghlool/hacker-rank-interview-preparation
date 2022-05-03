package greedy;

import java.util.*;

public class GiftingGroup {

	public static void main(String[] args) {

		String given1[] = { "110", "110", "011" }; // 2
		String given2[] = { "1100", "1101", "0010", "0010", "0001" }; // 2
		String given3[] = { "110", "111", "011" }; // 1

		String arr1[] = { "1100", "1110", "0110", "0001" };// 2
		String arr2[] = { "10000", "01000", "00100", "00010", "00001" };// 5
		String arr3[] = { "1100", "1101", "0010", "0010", "0001" };// 2
		String arr4[] = { "1100", "1101", "0010", "0010", "0001" };// 2
		String arr5[] = { "11100", "11001", "10100", "00011", "01011" };// 1
		String arr6[] = { "11100", "11100", "11100", "00011", "00011" };// 2
		String arr7[] = { "10100", "01010", "10100", "01010", "00001" };// 3

		List<String> arr = Arrays.asList(arr2);
		System.out.println(giftingGroup(arr));
	}

	static int giftingGroup(List<String> arr) {
		int res = 0;

		boolean[][] related = new boolean[arr.size()][arr.size()];
		boolean[] isReached = new boolean[arr.size()];

		for (int i = 0; i < arr.size(); i++) {
			String e = arr.get(i);

			for (int j = 0; j < e.length(); j++) {
				related[i][j] = e.charAt(j) == '1';
			}
		}
//		for (int i = 0; i < related.length; i++) {
//			
//			System.out.println(Arrays.toString(related[i]));
//		}
		
		for (int i = 0; i < isReached.length; i++) {
			if (!isReached[i]) {
				res++;
				reach(related, isReached, i);
			}
		}

		return res;
	}
	
	static void reach(boolean[][] related, boolean[] isReached, int i) {
		isReached[i] = true;
		
		for (int j = 0; j < isReached.length; j++) {
			if (related[i][j] && !isReached[j]) {
				reach(related, isReached, j);
			}
		}
	}

}
