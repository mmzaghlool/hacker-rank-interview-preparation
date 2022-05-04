package dynamic_programming;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class GridTraveler {
    public static void main(String[] args) {
        int n = 1000;
        int m = 1000;

        System.out.println(gridTravelerInit(n, m));
    }

    static BigInteger gridTravelerInit(int n, int m) {
        Map<String, BigInteger> memo = new HashMap<>();

        return gridTraveler(n, m, memo);
    }

    static BigInteger gridTraveler(int n, int m, Map<String, BigInteger> memo) {
        String key = n + "-" + m;
        String key2 = m + "-" + n;
        // Memorized value
        if (memo.containsKey(key))
            return memo.get(key);
        else if (memo.containsKey(key2))
            return memo.get(key2);

        // Base case
        if (n == 1 && m == 1)
            return BigInteger.valueOf(1);
        else if (n == 0 || m == 0)
            return BigInteger.valueOf(0);

        // Calculate
        BigInteger res = gridTraveler(n - 1, m, memo).add(gridTraveler(n, m - 1, memo));
        memo.put(key, res);
        return res;
    }

    // static class Grid {
    // int x;
    // int y;

    // Grid(int x, int y) {
    // this.x = x;
    // this.y = y;
    // }

    // public boolean equals(Grid obj) {
    // return this.x == obj.x && this.y == obj.y;
    // }
    // }
}
