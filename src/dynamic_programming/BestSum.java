package dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {
    public static void main(String[] args) {
        // int[] arr = { 7, 14 };
        // int[] arr = { 5, 4, 3, 7 };
        // int[] arr = { 5, 2, 3 };
        int[] arr = { 1, 2, 5, 25 };
        // int target = 7;
        int target = 100;
        // int target = 300;

        List<Integer> res = bestSum(target, arr);
        if (res != null) {
            System.out.println(res.toString());

        } else {
            System.out.println("None");
        }
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
