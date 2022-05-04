package dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    public static void main(String[] args) {
        int[] arr = { 7, 14 };
        int target = 300;

        List<Integer> res = howSum(target, arr);
        if (res != null) {
            System.out.println(res.toString());

        }
        System.out.println("None");
    }

    static List<Integer> howSum(int target, int[] arr) {
        Map<Integer, List<Integer>> memo = new HashMap<>();

        return howSum(target, arr, memo);
    }

    static List<Integer> howSum(int target, int[] arr, Map<Integer, List<Integer>> memo) {
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
        for (int i = 0; i < arr.length; i++) {
            res = howSum(target - arr[i], arr, memo);
            if (res != null) {
                res.add(arr[i]);
                break;
            }
        }
        memo.put(target, res);

        return res;
    }
}
