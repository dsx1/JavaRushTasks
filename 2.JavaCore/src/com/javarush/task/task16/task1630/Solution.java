package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fileName;
        private ArrayList<String> content = new ArrayList<>();

        public void setFileName(String fullFileName){
            this.fileName = fullFileName;
        }

        public void run(){
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                while (reader.ready()){
                    content.add(reader.readLine());
                }
            }
            catch (FileNotFoundException e){
                System.out.println("File " + fileName + " not found");
            }
            catch (IOException e){
                System.out.println("File " + fileName + " can't be read");
            }

        }

        @Override
        public String getFileContent() {
            StringBuffer sbuf = new StringBuffer();
            for (String s : content){
                sbuf.append(s).append(" ");
            }
            return sbuf.toString();
        }
    }

}
