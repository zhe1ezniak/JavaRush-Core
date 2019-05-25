package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException{
        //start here - начни тут
        switch(args[0]){
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        createPeople(args[i], args[i+1], args[i+2]);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople){
                    updatePeople(args);
                }
                break;
            case "-d":
                synchronized (allPeople){
                    deletePeople(args);
                }
                break;
            case "-i":
                synchronized (allPeople){
                    infoPeople(args);
                }
                break;
        }

    }

    public static void createPeople(String name, String sex, String date) throws ParseException {
            Date newDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);
            if (sex.equals("м")) allPeople.add(Person.createMale(name, newDate));
            if (sex.equals("ж")) allPeople.add(Person.createFemale(name, newDate));
            System.out.println(allPeople.size() - 1);
    }

    public static void updatePeople(String[] args) throws ParseException {
        for(int i = 1; i < args.length; i+=4) {
            String id = args[i];
            String name = args[i+1];
            String sex = args[i+2];
            String date = args[i+3];
            Date newDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);
            Person p = allPeople.get(Integer.parseInt(id));
            p.setName(name);
            p.setBirthDate(newDate);
            if (sex.equals("м")) p.setSex(Sex.MALE);
            if (sex.equals("ж")) p.setSex(Sex.FEMALE);
            allPeople.set(Integer.parseInt(id), p);
        }
    }

    public static void deletePeople(String[] args) {
        for (int i = 1; i < args.length; i++) {
            String id = args[i];
            Person p = allPeople.get(Integer.parseInt(id));
            p.setName(null);
            p.setBirthDate(null);
            p.setSex(null);
            allPeople.set(Integer.parseInt(id), p);
        }
    }

    public static void infoPeople (String[] args) {
        for (int i = 1; i < args.length; i++) {
            String id = args[i];
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Person p = allPeople.get(Integer.parseInt(id));
            String s = null;
            if (p.getSex().equals(Sex.MALE)) s = "м";
            if (p.getSex().equals(Sex.FEMALE)) s = "ж";
            System.out.println(p.getName() + " " + s + " " + dateFormat.format(p.getBirthDate()));
        }
    }
}
