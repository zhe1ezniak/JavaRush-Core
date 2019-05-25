package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fileName));

        StringBuilder sb = new StringBuilder();
        while (reader.readLine() != null){
            sb.append(reader.readLine());
        }
        reader.close();

        Map<Integer, Integer> map = new TreeMap<>();
        String line = sb.toString();//.replaceAll("[\\n\\r]", "");
        Matcher matcher = Pattern.compile("(<\\s*/?\\s*" + args[0] + ".*?>)").matcher(line);
        while(matcher.find()){
            if(matcher.group().matches("<\\s*" + args[0] + ".*?>")) map.put(matcher.start(), null);
            else{
                Integer op = null;
                for (Integer i: map.keySet())
                    if(map.get(i) == null) op = i;
                map.put(op, matcher.end());
            }
        }
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            System.out.println(line.substring(m.getKey(), m.getValue()));
        }
    }
}
