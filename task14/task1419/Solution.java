package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        Exception e = new IndexOutOfBoundsException();
        exceptions.add(e);
        e = new NullPointerException();
        exceptions.add(e);
        e = new IOException();
        exceptions.add(e);
        e = new FileNotFoundException();
        exceptions.add(e);
        e = new ClassCastException();
        exceptions.add(e);
        e = new IllegalArgumentException();
        exceptions.add(e);
        e = new RuntimeException();
        exceptions.add(e);
        e = new NegativeArraySizeException();
        exceptions.add(e);
        e = new NumberFormatException();
        exceptions.add(e);
    }
}
