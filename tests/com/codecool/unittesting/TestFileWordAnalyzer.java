package com.codecool.unittesting;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestFileWordAnalyzer {

    private static FilePartReader filePartReader;
    private static FileWordAnalyzer fileWordAnalyzer;


    @BeforeAll
    static void createFileWordAnalyzerInstance() {
        filePartReader = new FilePartReader("dictonary.txt", 1, 10);
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }

    @DisplayName("Are words ordered by ABC?")
    @Test
    void wordsByABC_assertEquals_True() throws IOException {
        filePartReader.setToLine(10);
        String expected = "[a, and, in, is, it, of, that, the, to, you]";
        assertEquals(expected, fileWordAnalyzer.wordsByABC().toString());
    }

    @DisplayName("Do words contain given substring?")
    @Test
    void wordsContainingSubString_assertEquals_True() throws IOException {
        filePartReader.setToLine(100);
        String expected = "[you, out, your, about, would, could, sound]";
        assertEquals(expected, fileWordAnalyzer.wordsContainingSubString("ou").toString());
    }

    @Test
    void wordsArePalindrome() throws IOException {
        filePartReader.setToLine(115);
        String expected = "[a, I, did, Anna, boob, civic, dewed, Elle, Eve, Hannah, kayak, level, madam, mom, noon, racecar, radar]";
        assertEquals(expected, fileWordAnalyzer.wordsArePalindrome().toString());
    }

    @Test
    void isPalindrome_IfContainsCapitalLetter_True() {
        assertTrue(fileWordAnalyzer.isPalindrome("AnnaanNa"));
    }

    @Test
    void isPalindrome_IfLengthIsOddNumber_True() {
//        filePartReader.setToLine(115);
        assertTrue(fileWordAnalyzer.isPalindrome("Ana"));
    }


    @Test
    void isPalindrome_IfOnlyMiddleLetterDiffers_False() {
        assertFalse(fileWordAnalyzer.isPalindrome("Aqnwqa"));
    }

}