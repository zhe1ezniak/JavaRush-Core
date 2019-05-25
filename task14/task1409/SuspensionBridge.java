package com.javarush.task.task14.task1409;

public class SuspensionBridge implements Bridge {
    final int SB = 3;
    @Override
    public int getCarsCount() {
        return SB;
    }
}
