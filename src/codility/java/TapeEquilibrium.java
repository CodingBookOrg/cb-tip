package codility.java;

public class TapeEquilibrium {
    public static  int solution(int[] A) {
        int smallest = Integer.MAX_VALUE;

        int sum = 0;
        for(int number : A) {
            sum += number;
        }

        /**
         * Sum IS: part1 + part2
          */

        int part1 = 0;
        int part2 = 0;
        int diff = 0;
        for(int i = 1; i < A.length; i++) {
            part1 += A[i - 1];
            part2 = sum - part1;
            diff = part1 - part2;
            if(diff < 0) diff *= -1;
            smallest = Math.min(diff, smallest);
        }
        return smallest;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,4,3}));
    }
}
