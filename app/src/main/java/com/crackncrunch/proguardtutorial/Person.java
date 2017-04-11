package com.crackncrunch.proguardtutorial;


import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = -6711694568707647944L;

    private String firstName;
    private String familyName;
    private int personAge;
    private int weight;

    public Person(String firstName, String familyName,
                  int personAge, int weight) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.personAge = personAge;
        this.weight = weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getPersonAge() {
        return personAge;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", personAge=" + personAge +
                ", weight=" + weight +
                '}';
    }
}
