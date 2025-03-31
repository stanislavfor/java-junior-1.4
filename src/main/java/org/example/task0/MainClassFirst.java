package org.example.task0;

//import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

class MainClassFirst {
    public static void main(String[] args) {
        // Создаем новый экземпляр MainClassFirst и передаем ему Scanner
        MainClassFirst mainClassFirst = new MainClassFirst(new Scanner(System.in));
        // Запускаем программу
        mainClassFirst.start();
    }
    // Список объектов типа PersonFirst
    private static final List<PersonFirst> personList = new ArrayList<>();
    // Счетчик идентификаторов
    private static long idCounter = 1L;
    // Scanner для считывания входных данных
    private final Scanner scanner;

    // Конструктор принимает Scanner
    public MainClassFirst(Scanner scanner) {
        this.scanner = scanner;
    }

    // Основной цикл программы
    public void start() {
        while (true) {
            System.out.println("Введите команду : 1-вывести список, 2-добавить в список, 3-удалить запись из списка, 5-exit");

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
                case "exit":
                case "5":
                    System.out.println("Завершение работы.");
                    return;
                default:
                    System.out.println("Неизвестная команда.");
            }
        }
    }

    // Метод для отображения всех записей
    public void listPersons() {
        // Проходимся по списку и выводим каждую запись
        for (PersonFirst person : personList) {
            System.out.println(person);
        }
    }

    // Метод добавления новой записи
    public void addPerson() {
        try {

            System.out.print("Введите имя : ");
            String firstName = scanner.nextLine();

            System.out.print("Введите фамилию : ");
            String lastName = scanner.nextLine();

            System.out.print("Введите возраст : ");
            int age = Integer.parseInt(scanner.nextLine());
            // Создаем новую запись
            PersonFirst person = new PersonFirst(firstName, lastName, age);
            // Устанавливаем уникальный идентификатор
            person.setId(idCounter++);
            // Добавляем запись в список
            personList.add(person);
            System.out.println("Запись успешно добавлена.");
        } catch (NumberFormatException e) {
            System.err.println("Возраст должен быть числом!");
        }
    }

    // Метод удаления записи по идентификатору
    public void deletePerson() {
        try {

            System.out.print("Введите ID для удаления : ");
            long id = Long.parseLong(scanner.nextLine());
            // Находим запись с указанным идентификатором
            boolean found = false;
            for (int i = 0; i < personList.size(); i++) {
                if (personList.get(i).getId() == id) {
                    // Удаляем запись
                    personList.remove(i);
                    System.out.println("Запись удалена.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Запись с таким ID не найдена.");
            }
        } catch (NumberFormatException e) {
            System.err.println("ID должно быть числом!");
        }
    }
}