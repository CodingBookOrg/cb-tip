package hackerrank.java.HashMap;

import java.util.HashMap;
import java.util.Map;

public class TwoStrings {
    public static String twoStrings(String s1, String s2) {

        Map<Character, Integer> countChar = new HashMap<>();
        char[] charArrayS1 = s1.toCharArray();
        char[] charArrayS2 = s2.toCharArray();

        for (char c : charArrayS1) {
            if(countChar.containsKey(c)) {
                Integer currentCount = countChar.get(c);
                countChar.put(c, ++currentCount);
            } else {
                countChar.put(c, 1);
            }
        }

        for (char c : charArrayS2) {
            if (countChar.containsKey(c)) {
                return "YES";
            }
        }

        return "NO";
    }
}
