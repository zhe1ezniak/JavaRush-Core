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
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String oldFileName = reader.readLine();
        String newFileName = reader.readLine();
        reader.close();
        List<String> oldFileLines = readFileLines(oldFileName);
        List<String> newFileLines = readFileLines(newFileName);

        boolean iterateByOldFile = true;

        while (oldFileLines.size() > 0 && newFileLines.size() > 0) {
            if (iterateByOldFile){
                if ( oldFileLines.get(0).equals(newFileLines.get(0)) ) {
                    lines.add(new LineItem(Type.SAME, oldFileLines.get(0)));
                    oldFileLines.remove(0);
                    newFileLines.remove(0);
                } else if ( oldFileLines.get(0).equals(newFileLines.get(1)) ) {
                    lines.add(new LineItem(Type.ADDED, newFileLines.get(0)));
                    newFileLines.remove(0);
                    iterateByOldFile = !iterateByOldFile;
                } else {
                    lines.add(new LineItem(Type.REMOVED, oldFileLines.get(0)));
                    oldFileLines.remove(0);
                }
            } else {
                if ( newFileLines.get(0).equals(oldFileLines.get(0)) ) {
                    lines.add(new LineItem(Type.SAME, newFileLines.get(0)));
                    newFileLines.remove(0);
                    oldFileLines.remove(0);
                } else if ( newFileLines.get(0).equals(oldFileLines.get(1)) ) {
                    lines.add(new LineItem(Type.REMOVED, oldFileLines.get(0)));
                    oldFileLines.remove(0);
                    iterateByOldFile = !iterateByOldFile;
                } else {
                    lines.add(new LineItem(Type.ADDED, newFileLines.get(0)));
                    newFileLines.remove(0);
                }
            }
        }
        if (oldFileLines.size() > 0) lines.add(new LineItem(Type.REMOVED, oldFileLines.get(0)));
        else if (newFileLines.size() > 0) lines.add(new LineItem(Type.ADDED, newFileLines.get(0)));
        for (LineItem i : lines) {
            System.out.println(i.type + " " + i.line);
        }
    }

    static List<String> readFileLines(String fileName) throws IOException {
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        List<String> fileLines = new ArrayList<>();
        String line;
        while ((line = fReader.readLine()) != null) {
            fileLines.add(line);
        }
        fReader.close();
        return fileLines;
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