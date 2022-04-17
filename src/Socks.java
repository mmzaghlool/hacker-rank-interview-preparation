import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Socks {

	public static void main(String[] args) {

		List<Integer> ar = Arrays.asList(1 ,1, 3 ,1 ,2 ,1 ,3, 3, 3, 3);

		System.out.println(ResultSocks.sockMerchant(ar.size(), ar));
	}

}

class ResultSocks {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        HashMap<Integer, Integer> socks = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < n; i++) {
            int element = ar.get(i);
            Integer prevNumOfSocks = socks.get(element);
            
            if (prevNumOfSocks == null) {
                socks.put(element, 1);
            } else {
                socks.replace(element, prevNumOfSocks + 1);
            }
        }
        
        int numOfPairs = 0;
        
        for(Map.Entry<Integer, Integer> entry : socks.entrySet()) {
            Integer value = entry.getValue();
            int x=Math.floorDiv(value, 2); 
            numOfPairs += x;
        }

        return numOfPairs;
    }

}