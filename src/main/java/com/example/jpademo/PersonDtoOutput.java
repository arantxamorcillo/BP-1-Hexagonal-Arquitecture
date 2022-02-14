package com.example.jpademo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PersonDtoOutput {

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

        public PersonDtoOutput(Person person){
           setId((person.getId()));
           setUser(person.getUser());
           setName(person.getName());
           setSurname(person.getSurname());
           setPersonal_email(person.getPersonal_email());
           setCity(person.getCity());
           setCreatedDate(person.getCreated_date());
           setImage_url(person.getImage_url());
        }
    }

