package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consol = System.out;

        ByteArrayOutputStream array = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(array);
        System.setOut(stream);

        testString.printSomething();
        String result = array.toString();
        System.setOut(consol);

        String [] value = result.split(" ");
        int a = Integer.parseInt(value[0]);
        int b = Integer.parseInt(value[2]);
        int c = 0;
        if (value[1].equals("+")) c = a + b;
        else if (value[1].equals("-")) c = a - b;
        else if (value[1].equals("*")) c = a * b;
        System.out.println(a + " " + value[1] + " " + b + " " + "=" + " " + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

