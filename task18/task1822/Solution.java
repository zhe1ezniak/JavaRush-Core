package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        String s = args[0] + " ";
        while((line = br.readLine()) != null){
            if (line.startsWith(s)){
                System.out.println(line);
            }
        }
        reader.close();
        br.close();
    }
}
