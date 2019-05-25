package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String firstName = reader.readLine();
            String secondName = reader.readLine();
            reader.close();
            reader = new BufferedReader(new FileReader(firstName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(secondName));
            while (reader.ready()){
                String line = reader.readLine();
                String[] words = line.split(" ");
                for (String s : words){
                    if(s.matches("\\d+")){
                        writer.write(s + " ");
                    }
                }
            }
            reader.close();
            writer.close();
        } catch (IOException e){
            e.getStackTrace();
        }
    }
}
