package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileStream = new FileInputStream(fileName);
        byte minValue = 127;
        while (fileStream.available() > 0){
            int min = fileStream.read();
            if (min < minValue){
                minValue =(byte) min;
            }
        }
        System.out.println(minValue);
        fileStream.close();
        reader.close();
    }
}
