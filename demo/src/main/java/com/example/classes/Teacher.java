package com.example.classes;

enum employmentType {
    FULLTIME,
    PARTTIME,
    CONTRACT
}

public class Teacher extends Person {
    public Teacher(String name, int age) {
        super(name, age);
    }

    public String[] classes;
    public employmentType employmentType;


    public void setGpa(Student student, double gpa) {
        student.setGpa(gpa);
        System.out.printf("%s has set %s's grade to %.2f\n", this.getName(), student.getName(), student.getGpa());
    } 
    
}
