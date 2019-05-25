package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName2)));

            String line = reader1.readLine();
            String [] arrayValue = line.split(" ");
            double dValue;
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < arrayValue.length; i++){
                dValue = Double.parseDouble(arrayValue[i]);
                str.append((int)Math.round(dValue)).append(" ");
            }
            reader.close();
            reader1.close();
            writer.write(str.toString());
            writer.close();
        }catch (NumberFormatException e){
            e.getStackTrace();
        }
        catch (FileNotFoundException e){
            e.getStackTrace();
        }
        catch (IOException e){
            e.getStackTrace();
        }
    }
}
