package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;

/*
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] Arr = new int[5];
        for (int i=0;i<Arr.length;i++){
            Arr[i] = Integer.parseInt(reader.readLine());
        }
        for (int i=0;i<Arr.length;i++){
            for (int j=0;j<Arr.length-1;j++){
                if (Arr[j+1]<Arr[j]) {
                    int tmp = Arr[j];
                    Arr[j]=Arr[j+1];
                    Arr[j+1]=tmp;
                }
            }

        }
        for (int i=0;i<Arr.length;i++){
            System.out.println(Arr[i]);
        }
        //напишите тут ваш код
    }
}
