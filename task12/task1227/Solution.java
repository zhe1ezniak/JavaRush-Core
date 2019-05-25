package com.javarush.task.task12.task1227;

/* 
CanFly, CanRun, CanSwim для классов Duck, Penguin, Toad
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }

    public class Duck implements CanFly, CanRun, CanSwim{
        public void fly(){
            System.out.println("Duck flying");
        }
        public void run(){
            System.out.println("Duck runs every morning");
        }
        public void swim(){
            System.out.println("Duck swims all time");
        }
    }

    public class Penguin implements CanRun, CanSwim{
        public void run(){
            System.out.println("Penguin can't run");
        }
        public void swim(){
            System.out.println("Penguin swim better than else");
        }
    }

    public class Toad implements CanSwim{
        public void swim(){
            System.out.println("Toad can swim");
        }
    }
}
