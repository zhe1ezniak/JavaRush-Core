package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fr = new FileReader(fileName);
        String line = "";
        while (fr.ready()){
            line += (char) fr.read();
        }
        Matcher matcher = Pattern.compile("world\\s").matcher(line);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        fr.close();
        System.out.println(count);
    }
}
