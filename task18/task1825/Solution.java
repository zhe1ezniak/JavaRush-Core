package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<String> list = new ArrayList();
            while(true){
                String name = reader.readLine();
                if (name.equals("end"))break;
                list.add(name);
            }
            Collections.sort(list);
            String fileOut = list.get(0).substring(0,list.get(0).lastIndexOf(".part"));
            BufferedOutputStream bufferOut = new BufferedOutputStream(new FileOutputStream(fileOut, true));
            for(String s: list){
                BufferedInputStream bufferIn = new BufferedInputStream(new FileInputStream(s));
                while(bufferIn.available() > 0){
                    bufferOut.write(bufferIn.read());
                }
                bufferIn.close();
            }
            reader.close();
            bufferOut.close();
        } catch (IOException e){
            e.getStackTrace();
        }

    }
}
