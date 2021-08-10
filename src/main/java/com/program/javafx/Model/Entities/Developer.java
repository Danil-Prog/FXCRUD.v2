package com.program.javafx.Model.Entities;

public class Developer {
    private int id;
    private String name;
    private String specialty;
    private int salary;
    private int phone;

    public Developer(int id, String name, String specialty, int salary, int phone) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.salary = salary;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getSalary() {
        return salary;
    }

    public int getPhone() {
        return phone;
    }
}
