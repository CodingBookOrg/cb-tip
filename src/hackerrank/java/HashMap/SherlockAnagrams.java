import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAnagrams {
    public static int sherlockAndAnagrams(String s) {

        Map<String, Integer> mapAnagramsCount = new HashMap<>();
        String subString;
        String compareSubString;
        int totalAnagrams = 0;

        //abba
        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j < s.length(); j++) {

                subString = sortString(s.substring(i, j)); //a

                for (int k = i + 1; k + subString.length() <= s.length(); k++) {

                    compareSubString = sortString(s.substring(k, k + subString.length()));
                    if (subString.equals(compareSubString)) {
                        if(mapAnagramsCount.containsKey(subString)) {
                            Integer currentCount = mapAnagramsCount.get(subString);
                            mapAnagramsCount.put(subString, ++currentCount);
                        } else {
                            mapAnagramsCount.put(subString, 1);
                        }
                    }
                }

            }
        }

        for (Integer count : mapAnagramsCount.values()) {
            totalAnagrams += count;
        }

        return totalAnagrams;

    }

    private static String sortString(String input) {
        String sortedString;
        char[] tempArray;
        tempArray = input.toCharArray();
        Arrays.sort(tempArray);
        sortedString = new String(tempArray);
        return sortedString;
    }
}
