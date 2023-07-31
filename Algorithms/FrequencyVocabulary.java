package Homework.Algorithms;

import java.util.HashMap;

public class FrequencyVocabulary {
    public static void main(String[] args) {
        String text = "A cat chased the mouse.";
        HashMap<Character, Integer> frequencyMap = buildFrequencyMap(text);
        frequencyMap.forEach((k, v) -> System.out.println("Letter: " + k + ", Frequency: " + v));
    }

    private static HashMap<Character, Integer> buildFrequencyMap(String text) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (Character.isLetter(c)) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }
        return frequencyMap;
    }
}
