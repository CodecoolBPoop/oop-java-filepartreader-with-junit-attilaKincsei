package com.codecool.unittesting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Next: Implement FileWordAnalyzer class
 * */
public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader(String filePath, Integer fromLine, Integer toLine) {
        setup(filePath, fromLine, toLine);
    }

    void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

    }

    String getFilePath() {
        return filePath;
    }

    void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    Integer getFromLine() {
        return fromLine;
    }

    void setFromLine(Integer fromLine) {
        this.fromLine = fromLine;
    }

    Integer getToLine() {
        return toLine;
    }

    void setToLine(Integer toLine) {
        this.toLine = toLine;
    }

    String read() throws FileNotFoundException, IOException {

        BufferedReader bReader = new BufferedReader(new FileReader(filePath));

        String line;
        StringBuilder sBuilder = new StringBuilder();
        while ((line = bReader.readLine()) != null) {
            sBuilder.append(line).append(", ");
        }

        if (sBuilder.length() > 0) {
            sBuilder.delete(sBuilder.length() - 2, sBuilder.length());
        }

        return sBuilder.toString();
    }

    String readLines() throws FileNotFoundException, IOException {

        String fullString = read();
        StringBuilder sb = new StringBuilder();
        String[] stringArray = fullString.split(", ");
        sb.append("[");
        for (int i = fromLine - 1; i < toLine; i++) {
            sb.append(stringArray[i]).append(", ");
        }

        if (sb.length() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]");

        return sb.toString();
    }

}
