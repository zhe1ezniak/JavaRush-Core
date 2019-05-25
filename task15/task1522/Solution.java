package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.javarush.task.task15.task1522.Planet.*;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        try {
            s = reader.readLine();
            if (s.equals(SUN)) thePlanet = Sun.getInstance();
            else if (s.equals(MOON)) thePlanet = Moon.getInstance();
            else if (s.equals(EARTH)) thePlanet = Earth.getInstance();
            else thePlanet = null;
            reader.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
