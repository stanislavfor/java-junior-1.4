package org.example.task1;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    private static final List<Person> personList = new ArrayList<>();
    private static Long idCounter = 1L;
    private final Scanner scanner;
    private final PrintStream out;

    public MainClass(Scanner scanner, PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }

    public void start() {
        while (true) {
//            out.println("Введите команду : 1-вывести список, 2-добавить в список, 3-удалить запись из списка, 5-exit");
            out.println("Введите команду : 1-вывести список, 2-добавить в список, 3-удалить запись из списка");
            String command = scanner.nextLine();
            switch (command) {
                case "вывести список":
                case "1":
                    listPersons();
                    break;
                case "добавить в список":
                case "2":
                    addPerson();
                    break;
                case "удалить запись из списка":
                case "3":
                    deletePerson();
                    break;
//                case "exit":
//                case "5":
//                    out.println("Завершение работы.");
//                    return;
                default:
                    out.println("Неизвестная команда.");
            }
        }
    }

    public void listPersons() {
        for (Person person : personList) {
            out.println(person);
        }
    }

    public void addPerson() {
        out.println("Введите имя :");
        String firstName = scanner.nextLine();
        out.println("Введите фамилию :");
        String lastName = scanner.nextLine();
        out.println("Введите возраст :");
        Integer age = Integer.valueOf(scanner.nextLine());
        Person person = new Person(firstName, lastName, age);
        person.setId(idCounter++);
        personList.add(person);
        out.println("Person добавлен.");
    }

    public void deletePerson() {
        out.println("Введите ID для удаления :");
        Long id = Long.valueOf(scanner.nextLine());
        Person personToRemove = null;
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                personToRemove = person;
                break;
            }
        }
        if (personToRemove != null) {
            personList.remove(personToRemove);
            out.println("Person удален.");
        } else {
            out.println("Person с таким ID не найден.");
        }
    }
}