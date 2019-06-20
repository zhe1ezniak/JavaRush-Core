package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
Прайсы 2
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        if ("-u".equals(args[0])) {
            String id = padRight(args[1], 8);
            String newProductName = padRight(args[2], 30);
            String newPrice = padRight(args[3], 8);
            String newQuantity = padRight(args[4], 4);

            List<String> fileLines = readFileLines(fileName);
            StringBuilder builder = new StringBuilder();
            for (String line : fileLines) {
                if (id.equals(line.substring(0, 8))) {
                    builder.setLength(0);
                    builder.append(id).append(newProductName).append(newPrice).append(newQuantity);
                    break;
                }
            }
            writeFile(fileName, fileLines);

        }
        else if ("-d".equals(args[0])) {
            String id = padRight(args[1], 8);

            List<String> fileLines = readFileLines(fileName);
            Iterator<String> iter = fileLines.iterator();
            while (iter.hasNext()) {
                if (id.equals(iter.next().substring(0, 8))) {
                    iter.remove();
                    break;
                }
            }
            writeFile(fileName, fileLines);
        }
    }

    private static List<String> readFileLines(String fileName) throws IOException {
        List<String> fileLines = new LinkedList<>();
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        String str;
        while ((str = fReader.readLine()) != null) {
            fileLines.add(str);
        }
        fReader.close();
        return fileLines;
    }

    private static void writeFile(String fileName, List<String> fileLines) throws IOException {
        BufferedWriter fWriter = new BufferedWriter(new FileWriter(fileName));
        for (String line : fileLines) {
            fWriter.write(line);
            fWriter.newLine();
        }
        fWriter.close();
    }

    private static String padRight(String input, int len) {
        if (input.length() < len) {
            return String.format("%1$-" + len + "s", input);
        } else {
            return input.substring(0, len);
        }
    }
}