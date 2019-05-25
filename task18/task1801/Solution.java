package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream file = new FileInputStream(fileName);
        byte max = 0;

        while (file.available() > 0){
            int x = file.read();
            if (x > max){
                max =(byte) x;
            }
        }
        System.out.println(max);
        reader.close();
        file.close();
    }
}
