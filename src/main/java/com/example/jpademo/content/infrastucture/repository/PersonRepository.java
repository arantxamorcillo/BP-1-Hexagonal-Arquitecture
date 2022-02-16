package com.example.jpademo.content.infrastucture.repository;

import com.example.jpademo.content.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("select person from Person person where person.user = ?1"
    )
    Person findByUser(String user);


}


