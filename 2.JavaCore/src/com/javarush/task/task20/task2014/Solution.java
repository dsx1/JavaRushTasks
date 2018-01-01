package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));
        FileOutputStream fileOutputStream = new FileOutputStream("c://file1.txt");
        FileInputStream fileInputStream = new FileInputStream("c://file1.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Solution savedObject = new Solution(5);
        outputStream.writeObject(savedObject);
        Solution loadedObject = new Solution(3);
        loadedObject = (Solution) inputStream.readObject();
        if (savedObject.string.equals(loadedObject.string))
            System.out.println("Yes");
    }

    transient final String pattern = "dd MMMM yyyy, EEEE";
    transient Date currentDate;
    transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }


}
