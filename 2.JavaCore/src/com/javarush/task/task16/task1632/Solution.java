package com.javarush.task.task16.task1632;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }


    public static void main(String[] args) {
        for (Thread thread : threads){
            thread.start();
        }
    }


    public static class Thread1 extends Thread{
        public Thread1() {
            super();
        }

        /*public Thread1(String name) {
            super(name);
        }*/

        @Override
        public void run() {
            while (true){

            }
        }
    }

    public static class Thread2 extends Thread{
        public Thread2() {
            super();
        }

        @Override
        public void run() {
            try{
                Thread.sleep(100000000);
            }
            catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread{
        public Thread3() {
            super();
        }

        @Override
        public void run() {
            try{
                while (true) {

                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e){

            }
        }
    }

    public static class Thread4 extends Thread implements Message{

        private boolean stop = false;

        public Thread4() {
            super();
        }

        @Override
        public void run() {
            while (stop == false){

            }
        }

        @Override
        public void showWarning() {
            this.stop = true;
        }
    }

    public static class Thread5 extends Thread {

        private int sum = 0;

        public Thread5() {
            super();
        }

        @Override
        public void run() {
            while (true){
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    String str = reader.readLine();
                    if (!str.equals("N")){
                        sum+= Integer.parseInt(str);
                        reader.close();
                    }
                    else break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                catch (IllegalArgumentException e){

                }
            }
            System.out.println(sum);
        }
    }
}