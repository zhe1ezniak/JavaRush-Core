package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new AllTime());
        threads.add(new printException());
        threads.add(new Ura());
        threads.add(new StopMessage());
        threads.add(new SumNumbers());
    }

    public static void main(String[] args) {
        Thread s = threads.get(4);
        s.start();

    }

    public static class AllTime extends Thread {
        private int x;

        public int getX() {
            return x;
        }

        @Override
        public void run() {
            while (true) {
                x++;
            }
        }
    }

    public static class printException extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < threads.size(); i++) {
                try {
                    Thread.sleep(1);
                    threads.get(i);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class Ura extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static class StopMessage extends Thread implements Message {
        @Override
        public void run() {
            while (!this.isInterrupted()) ;
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }

    public static class SumNumbers extends Thread {
        @Override
        public void run() {
            int a = 0;
            int sum = 0;
            String s;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try{
                while (true){
                    s = reader.readLine();
                    if (s.equals("N")) {
                        System.out.println(sum);
                        break;
                    }
                    else {
                        a = Integer.parseInt(s);
                        sum += a;
                    }
                }
            } catch (IOException e){}
        }
    }
}