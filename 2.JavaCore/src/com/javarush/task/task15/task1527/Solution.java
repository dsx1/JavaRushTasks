package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        //String URL = "https://www.youtube.com/?gl=RU&hl=ru";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URL = reader.readLine();
        String[] words1 = URL.split("/");
        String[] words2 = words1[words1.length-1].split("\\?");
        String[] words3 = words2[words2.length-1].split("&");
        String value = "";
        for (int i=0;i<words3.length;i++){
            String[] lastWords = words3[i].split("=");
            System.out.print(lastWords[0] + " ");
            if (lastWords[0].equals("obj")) {
                value=lastWords[1];
            }

        }
        System.out.println();
        if (!value.equals("")) {
            try {
                double forAlert = Double.parseDouble(value);
                alert(forAlert);
            } catch (NumberFormatException e) {
                alert(value);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
