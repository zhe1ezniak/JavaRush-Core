package com.javarush.task.task18.task1810;

/* 
DownloadException
*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{
                String nameFile = reader.readLine();
                FileInputStream fileStream = new FileInputStream(nameFile);
                if (fileStream.available() < 1000){
                    reader.close();
                    fileStream.close();
                    throw new DownloadException();
                }
            } catch (IOException e){}
        }
    }

    public static class DownloadException extends Exception {

    }
}
