package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
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

        String [] lines = array.toString().split("\\n");
        System.setOut(consol);

        for (int i = 0; i < lines.length; i+=2) {
            if (i != lines.length - 1) {
                System.out.println(lines[i]);
                System.out.println(lines[i + 1]);
                System.out.println("JavaRush - курсы Java онлайн");
            }
            else {
                System.out.println(lines[i]);
                break;
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
