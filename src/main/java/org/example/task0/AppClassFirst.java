package org.example.task0;

import java.util.Scanner;

public class AppClassFirst {
    public static void main(String[] args) {
        // Создаем новый экземпляр MainClassFirst и передаем ему Scanner
        MainClassFirst mainClassFirst = new MainClassFirst(new Scanner(System.in));
        // Запускаем программу
        mainClassFirst.start();
    }
}