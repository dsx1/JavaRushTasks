package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> listMultiply = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            char[] string = s.toCharArray();
            String newString="";
            if (string.length%2==0){
                newString = newString+s+" "+s;
                listMultiply.add(newString);
            }
            else{
                newString = newString+s+" "+s+" "+s;
                listMultiply.add(newString);
            }
        }

        for (int i = 0; i < listMultiply.size(); i++) {
            System.out.println(listMultiply.get(i));
        }
    }
}
