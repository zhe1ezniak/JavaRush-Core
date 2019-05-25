package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) {
        try{
            FileInputStream fileStream = new FileInputStream(args[0]);
            int space = 0;
            int litters = 0;
            while (fileStream.available() > 0){
                int c = fileStream.read();
                litters++;
                if (c == 32){
                    space++;}
            }
            double x = (double) space/litters*100;
            DecimalFormat df = new DecimalFormat("0.00");
            df.setRoundingMode(RoundingMode.CEILING);
            System.out.println(df.format(x));
            fileStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
