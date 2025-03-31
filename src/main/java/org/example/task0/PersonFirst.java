package org.example.task0;

import jakarta.persistence.*;

// Класс для хранения информации о людях
class PersonFirst {

    private long id;

    private String firstName;

    private String lastName;

    private int age;

    public PersonFirst() {}

    public PersonFirst(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Геттеры и сеттеры
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Перегруженный метод toString для удобного вывода информации
    @Override
    public String toString() {
        return "Person {" +
                "id: " + id +
                ", Имя: '" + firstName + '\'' +
                ", Фамилия: '" + lastName + '\'' +
                ", Возраст: " + age +
                '}';
    }
}