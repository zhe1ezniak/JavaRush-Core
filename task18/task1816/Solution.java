package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList(52);

        for (int i = 65; i < 123; i++){
            if (i > 90 && i < 97) i++;
            list.add(i);
        }

        try {
            FileInputStream fileStream = new FileInputStream(args[0]);
            int count = 0;
            while (fileStream.available() > 0){
                int value = fileStream.read();
                if (list.contains(value)){
                    count++;
                }
            }
            System.out.println(count);
            fileStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
