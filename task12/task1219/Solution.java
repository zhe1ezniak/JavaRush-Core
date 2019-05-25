package com.javarush.task.task12.task1219;

/* 
Создаем человека
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


    public class Human implements CanRun, CanSwim{
        public void run(){
            System.out.println("just run");
        }
        public void swim(){
            System.out.println("Vitya can't swim");
        }
    }

    public class Duck implements CanRun, CanSwim, CanFly{
        public void run(){
            System.out.println("This duck run so good");
        }
        public void swim(){
            System.out.println("Duck swim better than Vitya");
        }
        public void fly(){
            System.out.println(" Duck can fly");
        }
    }

    public class Penguin implements CanSwim, CanRun{
        public void swim(){
            System.out.println("Everyone swim better than Vitya");
        }
        public void run(){
            System.out.println("He can run too");
        }
    }

    public class Airplane implements CanFly, CanRun{
        public void fly(){
            System.out.println("Fly better than else");
        }
        public void run(){
            System.out.println("Can run");
        }
    }
}
