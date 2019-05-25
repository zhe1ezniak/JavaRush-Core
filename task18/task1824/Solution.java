package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            while(true) {
                String fileName = reader.readLine();
                try {
                    FileInputStream fileStream = new FileInputStream(fileName);
                    fileStream.close();
                } catch (FileNotFoundException e){
                    System.out.println(fileName);
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
