package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String s;
        while (true) {
            s = reader.readLine();
            if (s.equals("exit")) {
                reader.close();
                break;
            }
            list.add(s);
        }
        for (String str : list) {
            try {
                int a = Integer.parseInt(str);
                if (a > 0 && a < 128){
                    print ((short) a);
                } else print (a);
            } catch (NumberFormatException e){
                if (str.contains(".")){
                    try {
                        print(Double.parseDouble(str));
                    } catch (NumberFormatException e1) {
                        print(str);
                    }
                } else print(str);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
