package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
            bufferedReader1.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            File file = new File(bufferedReader.readLine());
        bufferedReader.close();
            FileInputStream inputStream = new FileInputStream(file);
            bufferedReader.close();
        bufferedReader.close();
            while (inputStream.available() > 0) {
                System.out.print((char) inputStream.read());
            }
        bufferedReader.close();
            inputStream.close();
        bufferedReader.close();
        bufferedReader.close();
        bufferedReader.close();

    }
}