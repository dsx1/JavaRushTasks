package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        int digitCount=0;
        int LowerLetterCount=0;
        int UpperLetterCount=0;
        ByteArrayOutputStream password = new ByteArrayOutputStream();
        for (int i=0;i<8;i++){
            if (i>=5){
                if (digitCount<1){
                    byte digit =(byte)(Math.random()*10);
                    String str = ""+digit;
                    try {
                        password.write(str.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    digitCount++;
                }
                else if (LowerLetterCount<1){
                    char lowerLetter = (char) ((Math.random()*(122-97))+97);
                    String letter = ""+lowerLetter;
                    try {
                        password.write(letter.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    LowerLetterCount++;
                }
                else if (UpperLetterCount<1){
                    char upperLetter = (char) ((Math.random()*(90-65))+65);
                    String letter = ""+upperLetter;
                    try {
                        password.write(letter.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    UpperLetterCount++;
                }
                else {
                    int rand = 1 + (int) (Math.random() * 3);
                    if (rand == 1) {
                        byte digit = (byte) (Math.random() * 10);
                        String str = "" + digit;
                        try {
                            password.write(str.getBytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        digitCount++;
                    } else if (rand == 2) {
                        char lowerLetter = (char) ((Math.random() * (122 - 97)) + 97);
                        String letter = "" + lowerLetter;
                        try {
                            password.write(letter.getBytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        LowerLetterCount++;
                    } else if (rand == 3) {
                        char upperLetter = (char) ((Math.random() * (90 - 65)) + 65);
                        String letter = "" + upperLetter;
                        try {
                            password.write(letter.getBytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        UpperLetterCount++;
                    }
                }

            }
            if (i<5) {
                int rand1 = 1 + (int) (Math.random() * 3);
                if (rand1 == 1) {
                    byte digit = (byte) (Math.random() * 10);
                    String str = "" + digit;
                    try {
                        password.write(str.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    digitCount++;
                } else if (rand1 == 2) {
                    char lowerLetter = (char) ((Math.random() * (122 - 97)) + 97);
                    String letter = "" + lowerLetter;
                    try {
                        password.write(letter.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    LowerLetterCount++;
                } else if (rand1 == 3) {
                    char upperLetter = (char) ((Math.random() * (90 - 65)) + 65);
                    String letter = "" + upperLetter;
                    try {
                        password.write(letter.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    UpperLetterCount++;
                }
            }
        }

        return password;
    }
}