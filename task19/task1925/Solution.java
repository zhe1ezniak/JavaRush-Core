package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder result = new StringBuilder();
        while (reader.ready()){
            String line = reader.readLine();
            String[] lineArray = line.split(" ");
            for(int i = 0; i < lineArray.length; i++){
                if (lineArray[i].length() > 6) result.append(lineArray[i]).append(",");
            }
        }
        reader.close();
        writer.write(result.toString().substring(0, result.length()-1));
        writer.close();
    }
}
