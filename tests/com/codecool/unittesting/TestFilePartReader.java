package com.codecool.unittesting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestFilePartReader {

    private static FilePartReader filePartReader;

    @BeforeAll
    static void initializeInstanceParameters() {
        filePartReader = new FilePartReader("1229_primes_per_line.txt", 10, 20);
    }

    @Test
    void getFilePath_NotNull_True() {
        assertNotNull(filePartReader.getFilePath());
    }

    @Test
    void getFromLine_NotNull_True() {
        assertNotNull(filePartReader.getFromLine());
    }

    @Test
    void getToLine_NotNull_True() {
        assertNotNull(filePartReader.getToLine());
    }

    @DisplayName("setup method's exception test 1: fromLine argument > toLine argument")
    @Test
    void setup_InvalidRange_ExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("", 10, 9));
    }

    @DisplayName("setup method's exception test 2: toLine argument < 1")
    @Test
    void setup_InvalidToLineArgument_ExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("", 0, 0));
    }


    @DisplayName("read method's exception test: FileNotFound")
    @Test
    void read_InvalidFilePath_FileNotFoundExceptionThrown() {
        filePartReader.setFilePath("229_primes_per_line.txt");
        assertThrows(FileNotFoundException.class, () -> filePartReader.read());
    }

    @DisplayName("read() method returns not null")
    @Test
    void read_ReturnValue_IsNotNull() throws IOException {
        assertNotNull(filePartReader.read());
    }


    @DisplayName("readLines(): assertEquals for return value")
    @Test
    void readLines_ReturnValueEquals_True() throws IOException {
        filePartReader.setFromLine(1);
        filePartReader.setToLine(17);
        String expected = "[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59]";
        assertEquals(expected, filePartReader.readLines());
    }

    @DisplayName("readLines() returns 2 if fromLine and toLine equals 1")
    @Test
    void readLines_FromLineAndToLineEquals1_ReturnValueEquals2() throws IOException {
        filePartReader.setFromLine(1);
        filePartReader.setToLine(1);
        String expected = "[2]";
        assertEquals(expected, filePartReader.readLines());
    }

}