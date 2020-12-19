public class RansomNote {
    public static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> countWords = new HashMap<>();

        for (String word : magazine) {
            if(countWords.containsKey(word)) {
                Integer currentCount = countWords.get(word);
                countWords.put(word, ++currentCount);
            } else {
                countWords.put(word, 1);
            }
        }

        for (String word : note) {
            if (countWords.containsKey(word) && countWords.get(word) > 0) {
                Integer currentValue = countWords.get(word);
                countWords.put(word, --currentValue);
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");

    }
}
