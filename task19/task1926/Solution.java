package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(name));
        while(reader.ready()){
            StringBuilder line = new StringBuilder(reader.readLine());
            line.reverse();
            System.out.println(line.toString());
        }
        reader.close();
    }
}
