package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            String fileName3 = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(fileName1);
            FileOutputStream fileOutputStream1 = new FileOutputStream(fileName2);
            FileOutputStream fileOutputStream2 = new FileOutputStream(fileName3);
            byte[] file = new byte[fileInputStream.available()];

            if (fileInputStream.available() > 0) {
                int count = fileInputStream.read(file);
                fileOutputStream1.write(file, 0 , count/2+count%2);
                fileOutputStream2.write(file, count/2+count%2, count/2);
            }

            reader.close();
            fileInputStream.close();
            fileOutputStream1.close();
            fileOutputStream2.close();
        } catch (IOException e){
            e.getStackTrace();
        }
    }
}
