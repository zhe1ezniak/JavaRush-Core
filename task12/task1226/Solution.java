package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {

    public static void main(String[] args) {

    }
    public interface CanFly{
        void fly();
    }

    public interface CanClimb{
        void climb();
    }

    public interface CanRun{
        void run();
    }

    public class Cat implements CanRun, CanClimb{
        public void run(){
            System.out.println("Cat can run");
        }
        public void climb(){
            System.out.println("Cat can climb");
        }
    }

    public class Dog implements CanRun{
        public void run(){
            System.out.println("Dog can only run");
        }
    }

    public class Tiger extends Cat {
        public void run(){
            System.out.println("Tiger can run too");
        }
        public void climb(){
            System.out.println("Can tiger climb?");
        }
    }

    public class Duck implements CanFly, CanRun{
        public void fly(){
            System.out.println("Duck can fly");
        }
        public void run(){
            System.out.println("Duck can run");
        }
    }
}
