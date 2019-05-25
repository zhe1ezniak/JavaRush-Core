package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        while(true){
            key = reader.readLine();
            if (key.equals("user")){
                Person.User user = new Person.User();
                doWork(user);
            }
            else if (key.equals("loser")){
                Person.Loser loser = new Person.Loser();
                doWork(loser);
            }
            else if (key.equals("coder")){
                Person.Coder coder = new Person.Coder();
                doWork(coder);
            }
            else if (key.equals("proger")){
                Person.Proger proger = new Person.Proger();
                doWork(proger);
            }
            else if (!(key.equals("user")) || !(key.equals("loser")) || !(key.equals("coder")) || !(key.equals("proger"))){
                reader.close();
                break;
            }

        }
        {
            //создаем объект, пункт 2

            //doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User) ((Person.User) person).live();
        if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();
        if (person instanceof Person.Coder) ((Person.Coder) person).writeCode();
        if (person instanceof Person.Proger) ((Person.Proger) person).enjoy();
    }
}
