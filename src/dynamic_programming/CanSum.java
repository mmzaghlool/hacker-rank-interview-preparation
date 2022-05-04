package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {
        int[] arr = { 7, 14 };
        int target = 300;
        System.out.println(canSum(target, arr));
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
