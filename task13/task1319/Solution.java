package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            File file = new File(bufferedReader.readLine());
            bufferedReader.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            String line;
            while (true){
                line = reader.readLine();
                if (line.equals("exit")){
                writer.write(line);
                break;}
                else {
                    writer.write(line);
                    writer.newLine();
                }
            }

            reader.close();
            writer.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
