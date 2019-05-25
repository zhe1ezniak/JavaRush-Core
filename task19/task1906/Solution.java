package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile;
        String secondFile;
        try{
            firstFile = reader.readLine();
            secondFile = reader.readLine();
            reader.close();

            FileReader fileReader = new FileReader(firstFile);
            FileWriter fileWriter = new FileWriter(secondFile);
            while(fileReader.ready()){
                fileReader.skip(1);
                int value = fileReader.read();
                fileWriter.write(value);
            }
            fileReader.close();
            fileWriter.close();
        } catch (IOException e){
            e.getStackTrace();
        }

    }
}
