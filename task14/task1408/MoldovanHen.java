package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen implements Country{
    @Override
    int getCountOfEggsPerMonth() {
        return 500;
    }

    @Override
    String getDescription(){
        return super.getDescription() + " Моя страна - " + MOLDOVA +
                ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
