package org.example;

public class Main {
    public static void main(String[] args) {

        int[] score = {2, 3, 1, 4, 2, 0, 2, 1, 3, 2};
        int TotScore = 0;


        for (int i = 0; i < score.length; i++) {
            TotScore += score[i];
        }
        int average=0;
         average=TotScore/score.length;


        System.out.println("The total numbers of goals is: " + TotScore);
        System.out.println("the average score is "+ average);
    }
}