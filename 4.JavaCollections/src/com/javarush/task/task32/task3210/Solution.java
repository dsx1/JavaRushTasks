package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        //args[0]="c:/file1";
        //args[1]="4";
        //args[2]="sr *com.javarush.task.task20.task2014.Solutionѓ7Ў®`ZЄ“\u0002 \u0001L ";
        try {
            RandomAccessFile raf = new RandomAccessFile(args[0],"rw");
            raf.seek(Long.parseLong(args[1]));
            byte[] array = new byte[args[2].length()];
            raf.read(array,0,args[2].length());
            String text = convertByteToString(array);
            if (text.equals(args[2])){
                raf.seek(raf.length());
                String answer = "true";
                byte[] buf = answer.getBytes();
                raf.write(buf);
            }
            else {
                raf.seek(raf.length());
                String answer = "false";
                byte[] buf = answer.getBytes();
                raf.write(buf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String convertByteToString (byte readBytes[]) {
        //return new String(readBytes, StandardCharsets.UTF_8);
        return new String(readBytes);
    }
}
