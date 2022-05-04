package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public static void main(String[] args) {
        // String[] arr = { "ab", "abc", "cd", "def", "abcd", "abcdef" };
        // String target = "abcdef";
        String[] arr = { "purp", "le", "pur", "ple", "p", "urple" };
        String target = "purple";
        // String[] arr = { "bo", "rd", "ate", "t", "ska", "sk", "boar" };
        // String target = "skateboard";
        // String target = "";
        // String[] arr = { "ee", "eeee", "eeeee", "e", "eee", "eeeeee" };
        // String target =
        // "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        System.out.println(canConstruct(target, arr));
    }

    static int canConstruct(String target, String[] arr) {
        Map<String, Integer> memo = new HashMap<>();

        return canConstruct(target, arr, memo);
    }

    static int canConstruct(String target, String[] arr, Map<String, Integer> memo) {
        int count = 0;
        // Memoization
        if (memo.containsKey(target))
            return memo.get(target);

        // Base cases
        if (target.isEmpty())
            return 1;

        // calculate
        for (int i = 0; i < arr.length; i++) {
            int subLen = arr[i].length();
            if (target.length() < subLen)
                continue;
            String sub = target.substring(0, subLen);

            if (sub.equals(arr[i]))
                count += canConstruct(target.substring(subLen), arr, memo);

        }
        memo.put(target, count);

        return count;
    }
}
