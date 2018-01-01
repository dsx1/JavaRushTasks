package com.javarush.task.task34.task3404;

/* 
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        //implement
        char[] buf = expression.toCharArray();
        String newExpression="";
        for (int i=0;i<buf.length;i++){
            if (buf[i]=='('){
                for (int j=i+1;j<buf.length-1;j++){
                    newExpression+=buf[j];
                }
                recursion(newExpression,countOperation+1);
            }
        }
    }

    public Solution() {
        //don't delete
    }
}
