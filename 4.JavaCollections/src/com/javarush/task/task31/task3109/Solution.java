package com.javarush.task.task31.task3109;


import java.io.*;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) throws IOException {
        Properties properties = new Properties();
        try {
            properties.loadFromXML(new FileInputStream(fileName));
        } catch (Exception e) {
            e.printStackTrace();
            try {
                properties.load(new FileInputStream(fileName));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
                return properties;
            }
        }

        return properties;
    }
}
