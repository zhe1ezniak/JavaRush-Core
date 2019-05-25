package com.javarush.task.task16.task1626;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountdownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
    }

    public static class CountUpRunnable implements Runnable{
        //Add your code here - добавь код тут
        private int countIndexUp = 0;


        @Override
        public void run() {
            try{
                while (true){
                    Thread.sleep(500);

                    countIndexUp++;
                    System.out.println(toString());
                    if(countIndexUp == Solution.number) return;
                }
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }

        @Override
        public String toString(){return Thread.currentThread().getName() + ": " + countIndexUp;}
    }


    public static class CountdownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
