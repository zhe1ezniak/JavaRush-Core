package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    @Override
    public void fly() {

    }

    public int countPas;

    public Plane(int countPas){
        this.countPas = countPas;
    }
}
