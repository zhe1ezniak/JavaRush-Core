package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        try{
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            FileInputStream fIStr = new FileInputStream(fileName1);
            FileOutputStream fOStr = new FileOutputStream(fileName2);

            ArrayList<Integer> list = new ArrayList();
            while (fIStr.available() > 0){
                list.add(fIStr.read());
            }

            Collections.reverse(list);

            for(Integer i : list){
                fOStr.write(i);
            }

            reader.close();
            fIStr.close();
            fOStr.close();
        } catch (IOException e){
            e.getStackTrace();
        }
    }
}
