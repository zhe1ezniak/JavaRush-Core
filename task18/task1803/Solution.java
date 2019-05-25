package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileStream = new FileInputStream(fileName);
        ArrayList<Integer> list = new ArrayList();
        while (fileStream.available() > 0){
            list.add(fileStream.read());
        }
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (Integer i : list){
            map.put(i , Collections.frequency(list, i));
        }
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            int value = m.getValue();
            if (count < value){
                count = value;
            }
        }
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            int value = m.getValue();
            if (count == value){
                str.append(m.getKey()).append(" ");
            }
        }
        System.out.println(str.toString());
        reader.close();
        fileStream.close();
    }
}
