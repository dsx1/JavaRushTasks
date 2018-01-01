package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        String firstString = bufferedReader.readLine();
        String answer = "";
        char[] str = firstString.toCharArray();
        for (int i = 0; i<str.length;i++){
            if (str[i] == ' ') answer+=str[i];
            else if ((str[i]>=65) && (str[i]<=90)){
                answer+=(char)(str[i]+key);
            }
            else if ((str[i]>=97) && (str[i]<=122)){
                answer+=(char)(str[i]+key);
            }
        }

        if (answer.equals("")){
            return new String();
        }
        else {
            return answer.toString();
        }
    }

}
