package codility.java;

/**
 * 100 points
 */

public class PermMissingElem {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2}));
    }

    public static int solution(int[] A) {
        // check empty array
        if(A.length == 0) return 1;

        // let's use the sum formula
        // the sum of number [1, n] is n(n+1) / 2
        long n = A.length + 1; // remember one element is missing, therefore we add 1
        long expectedSum = (n * (n + 1)) / 2;
        long actualSum = 0;
        // using streams API sum method here causes performance issues and causes your grade to decrease
        // we we are using for loop instead
        for(int i = 0; i < A.length; i++) {
            actualSum += A[i];
        }
        return (int)(expectedSum - actualSum);
    }
}
