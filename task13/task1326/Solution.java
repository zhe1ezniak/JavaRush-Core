package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            File file = new File(reader.readLine());
            reader.close();
            BufferedReader readFile = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            ArrayList<Integer> list = new ArrayList();
            while (readFile.ready()){
                int numb = Integer.parseInt(readFile.readLine());
                if (numb%2 == 0){
                    list.add(numb);
                }
            }
            readFile.close();
            Collections.sort(list);
            for (int i : list){
                System.out.println(i);
            }
        }
}
