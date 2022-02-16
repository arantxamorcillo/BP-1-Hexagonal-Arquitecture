package com.example.jpademo.content.domain;


import com.example.jpademo.content.infrastucture.dto.PersonDtoInput;
import com.sun.istack.NotNull;
import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

import java.util.Date;


@Data
@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue
    int id;

    @NotNull
    @Size(max = 10, min = 6 )
    String user;

    @NotNull
    String password;
    @NotNull
    String name;
    @NotNull
    String surname;
    @NotNull
    String company_email;
    @NotNull
    String personal_email;
    @NotNull
    String city;
    @NotNull
    Boolean active;
    @NotNull
    LocalDate created_date;

    String image_url;

    Date termination_date;

    public Person(PersonDtoInput personDto) {
        setId(personDto.getId());
        setUser(personDto.getUser());
        setPassword(personDto.getPassword());
        setName(personDto.getName());
        setSurname(personDto.getSurname());
        setCompany_email(personDto.getCompany_email());
        setPersonal_email(personDto.getPersonal_email());
        setCity(personDto.getCity());
        setActive(personDto.getActive());
        setCreated_date(personDto.getCreatedDate());
        setImage_url(personDto.getImage_url());

    }

    public Person(){

        this.created_date = LocalDate.now();

    }



}

