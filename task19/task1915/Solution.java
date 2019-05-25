package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String nameFile = reader.readLine();
            reader.close();

            PrintStream consol = System.out;

            ByteArrayOutputStream array = new ByteArrayOutputStream();
            PrintStream stream = new PrintStream(array);
            System.setOut(stream);

            testString.printSomething();
            String result = array.toString();

            System.setOut(consol);

            System.out.println(result);
            FileOutputStream writer = new FileOutputStream(nameFile);
            writer.write(result.getBytes());
            writer.close();
        } catch (IOException e){
            e.getStackTrace();
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

