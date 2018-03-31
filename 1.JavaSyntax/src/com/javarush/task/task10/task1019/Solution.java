package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,String> map = new HashMap<>();
        while(true) {
            String ids = reader.readLine();
            if (ids.equals("")) break;
            int id = Integer.parseInt(ids);
            String name = reader.readLine();
            if (name.equals("")) break;
            map.put(id,name);
        }

        for (HashMap.Entry<Integer,String> pair : map.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
