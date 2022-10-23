package com.dsalgado.persons.domain;

import java.util.Date;

public class Person {
    private String name;
    private Date birthDate;

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getBirthDateInMilliseconds(){
        return birthDate.getTime();
    }

}
