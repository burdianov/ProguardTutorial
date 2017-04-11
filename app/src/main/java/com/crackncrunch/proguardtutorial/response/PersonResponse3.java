package com.crackncrunch.proguardtutorial.response;


import com.crackncrunch.proguardtutorial.BaseResponse;

public class PersonResponse3 implements BaseResponse {
    private String name;
    private int age;

    public PersonResponse3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
