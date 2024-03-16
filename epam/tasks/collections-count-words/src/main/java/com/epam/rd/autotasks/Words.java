package com.epam.rd.autotasks;

import java.util.*;

public class Words {
    private static final int MIN_WORD_LENGTH = 4;
    private static final int MIN_OCCURRENCE_COUNT = 10;

    public String countWords(List<String> lines) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        Map<String, Integer> filteredWordCountMap = new HashMap<>();
        for (String line : lines) {
            List<String> words = List.of(line.split("[^\\p{L}\\p{N}]+"));
            for (String word : words) {
                String lowerCaseWord = word.toLowerCase();
                if (word.length() >= MIN_WORD_LENGTH) {
                    wordCountMap.put(lowerCaseWord, wordCountMap.getOrDefault(lowerCaseWord, 0) + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() >= MIN_OCCURRENCE_COUNT) {
                filteredWordCountMap.put(entry.getKey(), entry.getValue());
            }
        }

        List<Map.Entry<String,Integer>> entries = new ArrayList<>(filteredWordCountMap.entrySet());

        entries.sort((Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey())));

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : entries) {
            result.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        result.delete(result.length() - 1, result.length());
        return result.toString();
    }
}
