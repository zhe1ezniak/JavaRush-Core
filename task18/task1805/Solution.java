package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileStream = new FileInputStream(fileName);
        ArrayList<Integer> list = new ArrayList();
        int value;
        while (fileStream.available() > 0){
            value = fileStream.read();
            if (!list.contains(value)){
                list.add(value);
            }
        }
        Collections.sort(list);
        StringBuilder str = new StringBuilder();
        for (Integer i : list){
            str.append(i).append(" ");
        }
        System.out.println(str.toString().trim());
        reader.close();
        fileStream.close();
    }
}
