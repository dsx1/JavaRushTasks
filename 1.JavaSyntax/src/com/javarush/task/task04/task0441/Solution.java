package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /*int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());*/
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<3;i++){
            list.add(Integer.parseInt(reader.readLine()));
        }
        Collections.sort(list);
        System.out.println(list.get(1));
    }
}
