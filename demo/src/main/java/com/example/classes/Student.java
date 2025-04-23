package com.example.classes;

public class Student extends Person{

    public Student(String name, int age) {
            super(name, age);
        }

    private String major;
    private double gpa;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
