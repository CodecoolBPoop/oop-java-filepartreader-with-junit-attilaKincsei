package com.codecool.unittesting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FileWordAnalyzer {

    private FilePartReader filePartReader;

    FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    ArrayList wordsByABC() throws IOException {
        String wordsString = filePartReader.readLines();
        String wordsStringWithoutSquareBrackets = wordsString.substring(1, wordsString.length() - 1);
        String[] wordsArray = wordsStringWithoutSquareBrackets.split(", ");
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(wordsArray));
        wordsList.sort(String::compareTo);

        return wordsList;
    }

    ArrayList wordsContainingSubString(String subString) throws IOException {

        String wordsString = filePartReader.readLines();
        String wordsStringWithoutSquareBrackets = wordsString.substring(1, wordsString.length() - 1);
        String[] wordsArray = wordsStringWithoutSquareBrackets.split(", ");
        Stream<String> wordsStream = Arrays.stream(wordsArray);

        return (ArrayList) wordsStream
                .filter(s -> s.contains(subString))
                .collect(Collectors.toList());
    }

    ArrayList wordsArePalindrome() throws IOException {
        String wordsString = filePartReader.readLines();
        String wordsStringWithoutSquareBrackets = wordsString.substring(1, wordsString.length() - 1);
        String[] wordsArray = wordsStringWithoutSquareBrackets.split(", ");

        Stream<String> wordsStream = Arrays.stream(wordsArray);

        return (ArrayList) wordsStream
                .filter(this::isPalindrome)
                .collect(Collectors.toList());

    }

    boolean isPalindrome(String item) {
        int itemHalfLength = item.length() / 2;
        for (int i = 0; i < itemHalfLength; i++) {
            Character character1 = Character.toLowerCase(item.charAt(i));
            Character character2 = Character.toLowerCase(item.charAt(item.length() - 1 - i));
            boolean equals = character1.equals(character2);

            if (!equals) {
                return false;
            }
        }
        return true;
    }


}
