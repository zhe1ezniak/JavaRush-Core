package com.javarush.task.task19.task1920;

/* 
Самый богатый
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
        while(reader.ready()){
            String[] array = reader.readLine().split(" ");
            double value = Double.parseDouble(array[1]);
            if (map.containsKey(array[0])) {
                for (String s: map.keySet()){
                    if (s.equals(array[0])) value += map.get(array[0]);
                }
                map.put(array[0], value);
            }
            else map.put(array[0], value);
        }
        reader.close();
        double max = 0;
        for(Double d: map.values()){
            if (d > max) max = d;
        }
        for(Map.Entry<String, Double> m: map.entrySet()){
            if (m.getValue() == max) System.out.println(m.getKey());
        }
    }
}
