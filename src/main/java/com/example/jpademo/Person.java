package com.example.jpademo;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@Entity

public class Person {
    @Id
    @GeneratedValue
    int id;

    @NotNull
    @Size(max = 10, min = 6 )
    String user;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Date created_date;
    String image_url;
    Date termination_date;
}
