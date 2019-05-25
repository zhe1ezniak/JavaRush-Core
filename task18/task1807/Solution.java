package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();
            FileInputStream fileStream = new FileInputStream(fileName);
            int count = 0;
            while (fileStream.available() > 0){
                int value = fileStream.read();
                if (value == 44){
                    count++;
                }
            }
            System.out.println(count);
            reader.close();
            fileStream.close();
        } catch (IOException e){
            e.getStackTrace();
        }
    }
}
