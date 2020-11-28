package codility.java;
/**
 * 100 points
 */

import java.util.HashMap;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int[] numbers = {9,3,9,3,9,7,9};
        System.out.println(oddOccurrencesInArray.solution(numbers));
    }

    public int solution(int[] A) {

        HashMap<Integer, Integer> occurences = new HashMap<>(A.length);
        for(int number : A) {
            occurences.put(number, occurences.getOrDefault(number, 0) + 1);
        }

        for(Integer key: occurences.keySet()) {
            int value = occurences.get(key);
            if(value % 2 == 1) {
                return key;
            }
        }
        return Integer.MIN_VALUE;
    }
}
