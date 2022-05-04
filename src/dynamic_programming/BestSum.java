package dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {
    public static void main(String[] args) {
        // int[] arr = { 5, 2, 3 };
        // int[] arr = { 5, 4, 3, 7 };
        // int target = 7;
        int[] arr = { 1, 2, 5, 25 };
        int target = 100;
        // int[] arr = { 7, 14 };
        // int target = 300;
        // int[] arr = { 3, 5, 4, 7, 2 };
        // int target = 8;

        List<Integer> res = bestSumTabulation(target, arr);
        if (res != null) {
            System.out.println(res.toString());

        } else {
            System.out.println("None");
        }
    }

    static List<Integer> bestSumTabulation(int target, int[] arr) {
        List<Integer>[] table = new ArrayList[target + 1];
        table[0] = new ArrayList<>();

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null)
                continue;

            for (int num : arr) {
                int sum = i + num;
                if (sum > target)
                    continue;

                if (table[sum] == null || table[i].size() + 1 < table[sum].size()) {
                    table[sum] = new ArrayList<>(table[i]);
                    table[sum].add(num);
                }

            }
        }

        return table[target];
    }

    static List<Integer> bestSum(int target, int[] arr) {
        Map<Integer, List<Integer>> memo = new HashMap<>();

        return bestSum(target, arr, memo);
    }

    static List<Integer> bestSum(int target, int[] arr, Map<Integer, List<Integer>> memo) {
        List<Integer> res = null;
        // Memoization
        if (memo.containsKey(target))
            return memo.get(target);

        // Base cases
        if (target == 0)
            return new ArrayList<>();
        if (target < 0)
            return null;

        // calculate
        List<Integer> best = null;
        for (int i = 0; i < arr.length; i++) {
            res = bestSum(target - arr[i], arr, memo);
            if (res != null) {
                if (best == null || res.size() + 1 < best.size()) {
                    best = new ArrayList<>(res);
                    best.add(arr[i]);
                }
            }
        }
        memo.put(target, best);

        return best;
    }
}
