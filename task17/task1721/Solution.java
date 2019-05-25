package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFirstFile;
        String nameSecondFile;
        try{
            nameFirstFile = reader.readLine();
            nameSecondFile = reader.readLine();
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(nameFirstFile)));
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(nameSecondFile)));
            String line;
            while((line = reader1.readLine()) != null){
                allLines.add(line);
            }
            while((line = reader2.readLine()) != null){
                forRemoveLines.add(line);
            }
            reader.close();
            reader1.close();
            reader2.close();
        } catch(FileNotFoundException e){
            System.out.println(e);
        }
        catch (IOException e){
            System.out.println(e);
        }
        Solution sol = new Solution();
        try {
            sol.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
