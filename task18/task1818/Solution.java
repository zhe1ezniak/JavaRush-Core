package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            String fileName3 = reader.readLine();
            FileInputStream fileStream2 = new FileInputStream(fileName2);
            FileInputStream fileStream3 = new FileInputStream(fileName3);
            FileOutputStream fileStream1 = new FileOutputStream(fileName1, true);
            byte[] buffer = new byte[fileStream2.available()];
            if (fileStream2.available() > 0){
                int count = fileStream2.read(buffer);
                fileStream1.write(buffer, 0, count);
            }
            while (fileStream3.available() > 0){
                fileStream1.write(fileStream3.read());
            }
            fileStream1.close();
            fileStream2.close();
            fileStream3.close();
        } catch (IOException e){
            e.getStackTrace();
        }

    }
}
