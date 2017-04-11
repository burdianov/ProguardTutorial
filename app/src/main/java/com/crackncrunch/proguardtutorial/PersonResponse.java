package com.crackncrunch.proguardtutorial;


public class PersonResponse {
    private String name;
    private String secondName;
    private int age;

    public PersonResponse(String name, String secondName, int age) {
        this.name = name;
        this.secondName = secondName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }
}
