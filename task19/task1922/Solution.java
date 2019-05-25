package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(name));
        ArrayList<String> listLines = new ArrayList<>();
        while (reader.ready()){
            listLines.add(reader.readLine());
        }
        reader.close();
        for(String s: listLines){
            String [] array = s.split(" ");
            int count = 0;
            for(int i =0; i < array.length; i++){
                String word = array[i].replaceAll("[^a-zA-zа-яА-Я]", "");
                if (words.contains(word)) count++;
            }
            if (count == 2) System.out.println(s);
        }
     }
}
