package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = reader.readLine();
            if(s.equals("exit")){
                reader.close();
                break;
            }else{
            ReadThread rt = new ReadThread(s);
            rt.start();
        }}

    }

    public static class ReadThread extends Thread {
        private String file;

        public ReadThread(String fileName) {
            //implement constructor body
            this.file = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run(){
            try {
                FileInputStream stream = new FileInputStream(file);
                HashMap<Integer, Integer> map = new HashMap();
                while (stream.available() > 0){
                    int x = stream.read();
                    map.put(x, map.getOrDefault(x, 0)+1);
                }
                int max = Collections.max(map.values());
                for(Map.Entry<Integer, Integer> m : map.entrySet()){
                    if (m.getValue() == max){
                        resultMap.put(file, m.getKey());
                    }
                }
                stream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            interrupt();
        }
    }
}
