package com.example.jpademo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PersonDtoInput {

    int id;
    String user;
    String password;
    String name;
    String surname;
    String personal_email;
    String company_email;
    String city;
    Boolean active;
    LocalDate createdDate;
    String image_url;
    LocalDateTime terminationDate;

        public Person person() {
            Person person = new Person();
            person.setId((this.getId()));
            person.setUser(this.getUser());
            person.setPassword(this.getPassword());
            person.setName(this.getName());
            person.setSurname(this.getSurname());
            person.setCompany_email(this.getCompany_email());
            person.setPersonal_email(this.getPersonal_email());
            person.setActive(this.getActive());
            person.setCity(this.getCity());
            person.setCreated_date(this.getCreatedDate());
            person.setImage_url(this.getImage_url());
            return person;
        }
    }

