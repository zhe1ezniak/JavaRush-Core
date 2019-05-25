package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static{
        labels.put(2.1, "a");
        labels.put(1.2, "d");
        labels.put(3.2, "4");
        labels.put(3d, "3");
        labels.put(4.3, " ");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
