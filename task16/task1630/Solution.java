package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;


public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private static String fileName;
        private static String getFileString = "";

        public void setFileName(String fileName){
            this.fileName = fileName;
        }

        public String getFileContent(){
            return this.getFileString;
        }

        public void run(){
            StringBuilder s = new StringBuilder();

            try{
                BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
                while(reader.ready()) {
                        s.append(reader.readLine()).append(" ");
                    }
                reader.close();
            } catch (IOException e){
                System.out.println(e);
            }
            getFileString = s.toString();
        }

    }
}
