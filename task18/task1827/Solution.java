package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        int maxId = 0;
        String prodName = "";
        String price = "";
        String quantity = "";
        if (args.length > 0){
            prodName = String.format("%-30s", args[1]);
            price = String.format("%-8s", args[2]);
            quantity = String.format("%-4s", args[3]);
        }
        if (args.length > 0 && args[0].equals("-c")){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()){
                int getId = Integer.parseInt(reader.readLine().substring(0,8).trim());
                if (getId > maxId){
                    maxId = getId;
                }
            }
            reader.close();

            int nextId = maxId + 1;
            String id =String.format("%-8s", nextId);
            String result = id + prodName + price + quantity;
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.newLine();
            writer.write(result);
            writer.close();
        }
        }
      }
