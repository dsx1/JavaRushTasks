package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private String lastName;
        private int age;
        private int weight;
        private int height;
        private boolean married;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, String lastName, int age) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String name, String lastName, int age, int weight, int height) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        public Human(String name, String lastName, int age, int height) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.height = height;
        }

        public Human(String lastName, int age, int weight, int height) {
            this.lastName = lastName;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        public Human(int age, int weight, int height) {
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        public Human(int age, int weight) {
            this.age = age;
            this.weight = weight;
        }

        public Human(String name, String lastName, int age, int weight, int height, boolean married) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.weight = weight;
            this.height = height;
            this.married = married;
        }
    }
}
