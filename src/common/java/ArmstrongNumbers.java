package common.java;

/**
 * https://www.geeksforgeeks.org/program-for-armstrong-numbers/
 */
public class ArmstrongNumbers {
    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
        System.out.println(isArmstrong(153));
        System.out.println(getNthArmstrong(12));
    }

    private static boolean isArmstrong(int number) {
        String numberAsString = String.valueOf(number);
        int size = numberAsString.length();

        int sum = 0;
        for(char ch : numberAsString.toCharArray()) {
            int characterAsInt = Integer.parseInt(ch+"");
            sum += Math.pow(characterAsInt, size);
        }
        return sum == number;
    }

    private static int getNthArmstrong(int n) {
        int count = 0;
        for(int i = 1; i < Integer.MAX_VALUE; i++) {
            if(isArmstrong(i) == true) {
                count++;
                if(count == n) { return i; }
            }
        }
        return count;
    }
}
