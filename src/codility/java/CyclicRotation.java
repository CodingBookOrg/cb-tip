package codility.java;
/**
 * 100 points
 */

import java.util.ArrayList;
import java.util.Arrays;

public class CyclicRotation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{}, 3)));
    }
    public static int[] solution(int[] A, int K) {
        if(A.length == 0) return A;

        //we do not need to rotate more
        if(K > A.length) {
            K = K % A.length;
        }

        int beginIndex = A.length - K;
        ArrayList<Integer> shiftedArray = new ArrayList<>();
        for(int i = beginIndex; i < A.length; i++) {
            shiftedArray.add(A[i]);
        }
        for(int i = 0; i < beginIndex; i++) {
            shiftedArray.add(A[i]);
        }
        return shiftedArray.stream().mapToInt(i -> i).toArray();
    }
}
