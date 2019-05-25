package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result;
        ArrayList<Long> list = new ArrayList<>();
        if (N < 10){
            for (int i = 0; i < N; i++){
                list.add((long)i);
            }
        } else {
            long s = 0;
            for (long i = 10; i < N; i++) {
                short stepen = (short) Math.ceil(Math.log10(Math.abs(i)));
                for (long j = i; j > 0; j /= 10) {
                    long k = j % 10;
                    if (k == 0) continue;
                    else if (k == 1) s += 1;
                    s += (long) Math.pow(k, stepen);
                }
                list.add(s);
            }
        }
        Collections.sort(list);
        result = list.stream().mapToLong(i -> i).toArray();
        return result;
    }

    public static void main(String[] args) {

    }
}
