package com.crackncrunch.proguardtutorial;


public class PersonResponse2 {
    private String name;
    private String secondName;

    public PersonResponse2(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }
}
