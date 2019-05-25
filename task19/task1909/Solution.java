package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String first = reader.readLine();
            String second = reader.readLine();
            reader.close();
            BufferedReader reader1 = new BufferedReader(new FileReader(first));
            BufferedWriter writer = new BufferedWriter(new FileWriter(second, true));
            String line = "";
            while ((line = reader1.readLine()) != null){
                line = line.replaceAll("\\.", "!");
                writer.write(line);
            }
            reader1.close();
            writer.close();
        } catch (IOException e){
            e.getStackTrace();
        }
    }
}
