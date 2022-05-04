package dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    public static void main(String[] args) {
        // int[] arr = { 7, 14 };
        // int target = 300;
        int[] arr = { 3, 5, 4, 7, 2 };
        int target = 8;

        List<Integer> res = howSumTabulation(target, arr);
        if (res != null) {
            System.out.println(res.toString());

        } else {
            System.out.println("null");
        }
    }

    static List<Integer> howSumTabulation(int target, int[] arr) {
        List<Integer>[] table = new ArrayList[target + 1];
        table[0] = new ArrayList<>();

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null)
                continue;

            for (int num : arr) {
                int sum = num + i;
                if (sum > target)
                    continue;

                table[sum] = new ArrayList<>(table[i]);
                table[sum].add(num);
            }
        }

        return table[target];
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
