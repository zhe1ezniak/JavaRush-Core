package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();

            FileInputStream fileInput1 = new FileInputStream(fileName1);
            byte[] arrrayFile1 = new byte[fileInput1.available()];
            fileInput1.read(arrrayFile1);
            fileInput1.close();

            FileInputStream fileInput2 = new FileInputStream(fileName2);
            byte[] arrayFile2 = new byte[fileInput2.available()];
            fileInput2.read(arrayFile2);
            fileInput2.close();

            byte[] arrayAll = new byte[arrrayFile1.length + arrayFile2.length];
            for(int i = 0; i < arrayFile2.length; i++){
                arrayAll[i] = arrayFile2[i];
            }
            for(int i = 0, j = arrayFile2.length; i < arrrayFile1.length; i++, j++){
                arrayAll[j] = arrrayFile1[i];
            }

            FileOutputStream fileOut = new FileOutputStream(fileName1);
            fileOut.write(arrayAll);
            fileOut.close();

        } catch (IOException e){
            e.getStackTrace();
        }
    }
}
