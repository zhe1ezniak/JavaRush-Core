package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try{
            String str = reader.readLine();
            if("helicopter".equals(str)){
                result = new Helicopter();
            }
            if("plane".equals(str)){
                int numb = Integer.parseInt(reader.readLine());
                result = new Plane(numb);
            }
            reader.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
