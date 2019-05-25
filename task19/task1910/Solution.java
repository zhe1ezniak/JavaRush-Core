package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader readerName = new BufferedReader(new InputStreamReader(System.in));
        try {
            String first = readerName.readLine();
            String second = readerName.readLine();
            readerName.close();
            BufferedReader readerFile = new BufferedReader(new FileReader(first));
            BufferedWriter writer = new BufferedWriter(new FileWriter(second, true));
            String line = "";
            while((line = readerFile.readLine()) != null){
                line = line.replaceAll("\\p{Punct}|\\n", "");
                writer.write(line);
            }
            readerFile.close();
            writer.close();
        } catch (IOException e){
            e.getStackTrace();
        }
    }
}
