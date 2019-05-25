package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter (Scanner fileScaner){
            this.fileScanner = fileScaner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String line = fileScanner.nextLine();
            String[] arrayLine = line.split("\\s", 4);
            Date date = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH).parse(arrayLine[3]);
            return new Person(arrayLine[1], arrayLine[2], arrayLine[0], date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
