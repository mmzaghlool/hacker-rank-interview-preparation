public class CountingValleys {

	public static void main(String[] args) {
		// TODO: Auto-generated method stub
		String x = "DDUUUUDDDDUU";
		System.out.println(ResultCountingValleys.countingValleys(x.length(), x));
	}

}


class ResultCountingValleys {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
		int seaLevel = 0;
		int prevSeaLevel = 0;
		int valleys = 0;
		
    	for (int i = 0; i < steps; i++) {
			char step = path.charAt(i);
			
			if (step == 'U') {
				seaLevel += 1;
			}else {
				seaLevel -= 1;
			}
			
			if (seaLevel < 0 && prevSeaLevel >= 0) {
				valleys += 1;
			}
			
			prevSeaLevel = seaLevel;
		}
    	
    	
    	return valleys;
    }

}
