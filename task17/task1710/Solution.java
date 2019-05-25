package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException{
        //start here - начни тут
        switch(args[0]){
            case "-c":
                addPeople(args[1], args[2], args[3]);
                break;
            case "-u":
                updatePeople(args[1], args[2], args[3],args[4]);
                break;
            case "-d":
                deletePeople(args[1]);
                break;
            case "-i":
                infoAboutPeople(args[1]);
                break;
            }
        }


    public static void addPeople(String name, String sex, String date) throws ParseException {
        Date birthNewDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);
        if (sex.equals("м")) allPeople.add(Person.createMale (name, birthNewDate));
        if (sex.equals("ж")) allPeople.add(Person.createFemale(name, birthNewDate));
        System.out.println(allPeople.size() - 1);
    }

    public static void updatePeople(String id, String name, String sex, String date) throws ParseException{
        Date birthDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);
        Person updatePerson = allPeople.get(Integer.parseInt(id));
        updatePerson.setName(name);
        updatePerson.setBirthDate(birthDate);
        if (sex.equals("м")) updatePerson.setSex(Sex.MALE);
        if (sex.equals("ж")) updatePerson.setSex(Sex.FEMALE);
        allPeople.set(Integer.parseInt(id), updatePerson);
    }

    public static void deletePeople (String id) {
        Person delete = allPeople.get(Integer.parseInt(id));
        delete.setName(null);
        delete.setSex(null);
        delete.setBirthDate(null);
        allPeople.set(Integer.parseInt(id), delete);
    }

    public static void infoAboutPeople (String id) throws ParseException{
        Person updateBirthDatePerson = allPeople.get(Integer.parseInt(id));
        SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String sex = null;
        if (updateBirthDatePerson.getSex().equals(Sex.MALE)) sex = "м";
        if (updateBirthDatePerson.getSex().equals(Sex.FEMALE)) sex = "ж";
        System.out.println(updateBirthDatePerson.getName() + " " + sex + " "
                + date.format(updateBirthDatePerson.getBirthDate()));
    }
}
