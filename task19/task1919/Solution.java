package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();
        while (reader.ready()){
            String line = reader.readLine();
            String[] array = line.split(" ");
            String name = array[0];
            double value = Double.parseDouble(array[1]);
            if(map.containsKey(name)){
                for (String s: map.keySet()) {
                    if (s.equals(name)) value = map.get(s) + value;
                }
                map.put(name, value);
            } else map.put (name, value);
        }
        reader.close();

        for(Map.Entry<String, Double> m: map.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
