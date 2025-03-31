package org.example.task1;

import java.util.Scanner;

public class AppClass {
    public static void main(String[] args) {
//        System.out.println("Выполните ввод.");
        Scanner scanner = new Scanner(System.in);
//        if (scanner.hasNextLine()) {
//            String input = scanner.nextLine();
//            System.out.println("Вы ввели : " + input);
//        } else {
//            System.out.println("Нет ввода, программа завершает работу.");
//        }

        MainClass mainClass = new MainClass(scanner, System.out);
        mainClass.start();
    }

}