package com.tw;

import java.util.Scanner;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class Library {
    public static void main(String[] args) {
        ScoreService scoreService = new ScoreService();
        StudentService studentService = new StudentService();


        while (true) {
            System.out.println(scoreService.printMenu());
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    studentService.dealMenu1();
                    break;
                case 2:
                    System.out.println(scoreService.printScore());
                    break;
                case 3:
                    return;

            }
        }

    }

}
