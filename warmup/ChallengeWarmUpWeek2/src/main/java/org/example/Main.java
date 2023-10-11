package org.example;

public class Main {
    public static void main(String[] args) {
        int loop = 0; // this variables will count the first 3 numbers then stop the loop
        int i = 0;
        for (i = 1; i <= 100; i++) {

            if (i % 7 == 0 && i % 9 == 0) {
                System.out.println(i);
                loop++;

                if (loop == 3) {
                    System.out.println("done");
                    break;
                }
            }
        }
    }
}