package codility.java;

/**
 * 100 points
 */
public class FrogJmp {
    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));
    }

    public static int solution(int X, int Y, int D) {
        return (int) Math.ceil((Y-X)/(double)D);
    }
}
