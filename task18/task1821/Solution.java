package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Map<Character, Integer> map = new TreeMap();

        try {
            FileInputStream fileStream = new FileInputStream(args[0]);
            while(fileStream.available() > 0){
                char key = (char) fileStream.read();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (Map.Entry<Character, Integer> m : map.entrySet()){
                System.out.println(m.getKey() + " " + m.getValue());
            }
            fileStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
