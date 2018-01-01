package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        if (number>=1 && number<=7){
            if (number==1) System.out.println("понедельник");
            if (number==2) System.out.println("вторник");
            if (number==3) System.out.println("среда");
            if (number==4) System.out.println("четверг");
            if (number==5) System.out.println("пятница");
            if (number==6) System.out.println("суббота");
            if (number==7) System.out.println("воскресенье");
        }
        else System.out.println("такого дня недели не существует");
    }
}