package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        int number = Integer.parseInt(reader.readLine());
        while (number!=-1){
            sum+=number;
            number = Integer.parseInt(reader.readLine());
        }
        System.out.println(sum-1);
    }
}
