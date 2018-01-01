package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        try {
            RandomAccessFile raf = new RandomAccessFile(args[0],"w");
            raf.seek(Long.parseLong(args[1]));
            byte[] buffer = args[2].getBytes();
            if (raf.length()<Long.parseLong(args[1])){
                raf.seek(raf.length());
                raf.write(buffer);
            }
            else{
                raf.write(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
