package Homework.Map;

import java.util.*;

public class GroupWords {
    public static void main(String[] args) {
        String strings[] = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf", "ogd", "tac", "wooolloooff"};

        System.out.println(findSameSymbols(strings));
    }

    public static List<List<String>> findSameSymbols(String strings[]) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strings) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            HashMap<Character, Integer> wordMap = new HashMap<>();
            for (char c : chars) {
                if (wordMap.get(c) != null) {
                    wordMap.put(c, wordMap.get(c) + 1);
                } else {
                    wordMap.put(c, 1);
                }
            }

            char[] uniqueWordChars = new char[wordMap.size()];

            int index = 0;
            for (Map.Entry<Character, Integer> pair : wordMap.entrySet()) {
                Character key = pair.getKey();
                uniqueWordChars[index] = key;
                index++;
            }

            String key = new String(uniqueWordChars);
            if (map.containsKey(key)) {
                map.get(key).add(word);
            } else {
                List<String> words = new ArrayList<>();
                words.add(word);
                map.put(key, words);
            }
        }
        return new ArrayList(map.values());
    }
}
