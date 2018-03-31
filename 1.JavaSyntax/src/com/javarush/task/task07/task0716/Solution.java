package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("мера");
        list.add("лоза"); //1
        list.add("лира"); //2
        list.add("вода");
        list.add("кора");
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        //напишите тут ваш код
        ArrayList<String> result = new ArrayList<>();
        result.addAll(list);
        for (String word : list){
            if (word.contains("р")){
                if (word.contains("л")) continue;
                result.remove(word);
            }
            else if (word.contains("л")){
                result.add(word);
            }

        }
        return result;
    }
}