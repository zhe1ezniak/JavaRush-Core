package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        switch(args[0]){
            case "-e" :
                try {
                    BufferedInputStream bufferIn = new BufferedInputStream(new FileInputStream(args[1]));
                    BufferedOutputStream bufferOut = new BufferedOutputStream(new FileOutputStream(args[2]));
                    while(bufferIn.available() > 0){
                        int value = bufferIn.read();
                        value++;
                        bufferOut.write(value);
                    }
                    bufferIn.close();
                    bufferOut.close();
                } catch (FileNotFoundException e){
                    e.getStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "-d" :
                try {
                    BufferedInputStream bufferIn = new BufferedInputStream(new FileInputStream(args[1]));
                    BufferedOutputStream bufferOut = new BufferedOutputStream(new FileOutputStream(args[2]));
                    while(bufferIn.available() > 0){
                        int value = bufferIn.read();
                        value--;
                        bufferOut.write(value);
                    }
                    bufferIn.close();
                    bufferOut.close();
                } catch (FileNotFoundException e){
                    e.getStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}
