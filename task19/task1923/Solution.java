package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder result = new StringBuilder();
        while(reader.ready()){
            String line = reader.readLine();
            String[] arrayLine = line.split(" ");
            Pattern p = Pattern.compile(".*\\d+.*");
            for (int i = 0; i < arrayLine.length; i++){
                Matcher m = p.matcher(arrayLine[i]);
                if (m.find()) result.append(arrayLine[i]).append(" ");
            }
        }
        reader.close();
        writer.write(result.toString());
        writer.close();
    }
}
