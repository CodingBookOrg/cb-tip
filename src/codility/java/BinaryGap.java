package java;

/**
 * 100 points
 */
public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(2_147_483_647));
    }

    public static int solution(int N) {
        //first we convert integer to its binary representation (String)
        String binary = Integer.toBinaryString(N);

        int biggestGap = 0;
        int currentGap = 0;

        // We iterate over the string to find the gaps (represented by 0's)
        // and hold the value in current gap
        // if we meet a 1 that means the current gap is over and we reset the current gap value
        // The maximum of current gap values will give us the result
        for(char number : binary.toCharArray()) {
            if(number == '1') {
                if(currentGap > biggestGap) {
                    biggestGap = currentGap;
                }
                currentGap = 0;
            } else {
                currentGap++;
            }
        }
        return biggestGap;
    }
}
