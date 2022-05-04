package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {
        int[] arr = { 7, 14 };
        int target = 300;
        // int[] arr = { 3, 5, 4, 7 };
        // int target = 8;
        System.out.println(canSumTabulation(target, arr));
    }

    static boolean canSumTabulation(int target, int[] arr) {
        boolean[] table = new boolean[target + 1];
        table[0] = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= target) {
                table[arr[i]] = true;
            }
        }

        for (int i = 0; i < table.length; i++) {
            if (table[i] == false)
                continue;

            for (int j = 0; j < arr.length; j++) {
                if (i + arr[j] > target)
                    continue;

                table[i + arr[j]] = true;
            }
        }

        return table[target];
    }

    static boolean canSum(int target, int[] arr) {
        Map<Integer, Boolean> memo = new HashMap<>();

        return canSum(target, arr, memo);
    }

    static boolean canSum(int target, int[] arr, Map<Integer, Boolean> memo) {
        // Memoization
        if (memo.containsKey(target))
            return memo.get(target);

        // Base cases
        if (target == 0)
            return true;
        if (target < 0)
            return false;

        // calculate
        boolean valid = false;
        for (int i = 0; i < arr.length; i++) {
            valid = canSum(target - arr[i], arr, memo);

            if (valid)
                break;
        }
        memo.put(target, valid);

        return valid;
    }
}
