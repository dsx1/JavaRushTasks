package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String date = reader.readLine();
        String[] arr = date.split(",");
        System.out.println("Меня зовут " + name +".");
        System.out.println("Я родился " + arr[2] + "." + arr[1]+"."+arr[0]);
    }
}
