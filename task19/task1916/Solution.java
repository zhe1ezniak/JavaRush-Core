package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            reader.close();

            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            BufferedReader reader2 = new BufferedReader(new FileReader(file2));

            ArrayList<String> list1 = new ArrayList<>();
            ArrayList<String> list2 = new ArrayList<>();

            while (reader1.readLine() != null){
                list1.add(reader1.readLine());
            }
            reader1.close();
            while (reader2.readLine() != null){
                list2.add(reader2.readLine());
            }
            reader2.close();
            for (int i = 0; i < list1.size(); i++){
               if (list2.contains(list1.get(i))) {
                   lines.add(new LineItem(Type.SAME, list1.get(i)));
               }
               else lines.add(new LineItem(Type.REMOVED, list1.get(i)));
            }
            int j = 0;
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).equals(list2.get(j))) {
                    i++;
                    j++;
                } else {
                    lines.add(i, new LineItem(Type.ADDED, list2.get(j)));
                    j++;
                }
            }
        } catch (IOException e){
            e.getStackTrace();
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
