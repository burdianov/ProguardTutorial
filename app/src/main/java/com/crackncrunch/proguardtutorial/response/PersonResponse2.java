package com.crackncrunch.proguardtutorial.response;


import com.crackncrunch.proguardtutorial.BaseResponse;

public class PersonResponse2 implements BaseResponse {
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
