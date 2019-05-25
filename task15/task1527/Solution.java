package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            URL url = new URL(reader.readLine());
            String s = url.getQuery();
            ArrayList<String> list = new ArrayList();
            for (String str : s.split("&")){
                list.add(str);
            }
            String[] strArray;
            String word;
            String value = null;
            StringBuilder strBuild = new StringBuilder();
            for (String str : list) {
                if (str.contains("=")) {
                    strArray = str.split("=");
                    word = strArray[0];
                    strBuild.append(word).append(" ");
                    if (word.equals("obj")) {
                        value = strArray[1];
                    }
                } else strBuild.append(str).append(" ");
        }
            System.out.println(strBuild.toString().trim());
            reader.close();

            if (value != null) {
                try {
                    double d = Double.parseDouble(value);
                    alert(d);
                } catch (NumberFormatException e) {
                    alert(value);
                }
            }
        } catch (IOException e ){
            System.out.println(e);
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
