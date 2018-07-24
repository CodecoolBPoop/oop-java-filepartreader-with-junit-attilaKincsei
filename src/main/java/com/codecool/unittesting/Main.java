package com.codecool.unittesting;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FilePartReader testFPR = new FilePartReader("1229_primes_per_line.txt", 1, 11);
        String primes = testFPR.read();
//        System.out.println(primes);


        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(
                new FilePartReader("dictonary.txt", 1, 100)
        );
        System.out.println(fileWordAnalyzer.isPalindrome("Aqnwqa"));

    }



}
