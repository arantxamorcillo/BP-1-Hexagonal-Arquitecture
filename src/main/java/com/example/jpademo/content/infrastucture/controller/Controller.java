package com.example.jpademo.content.infrastucture.controller;

import com.example.jpademo.content.application.PersonService;
import com.example.jpademo.content.domain.Person;
import com.example.jpademo.content.infrastucture.dto.PersonDtoInput;
import com.example.jpademo.content.infrastucture.dto.PersonDtoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {



    @Autowired
    PersonService personService;

    @PostMapping("/addperson")
    public String addPerson(@RequestBody PersonDtoInput personDtoInput){
        System.out.println(personDtoInput.toString());
        personService.createPerson(personDtoInput.person());
        return "ok";
    }

    @PutMapping("{id}")
    public PersonDtoOutput updatePerson(@PathVariable int id, @RequestBody PersonDtoInput personDtoInput){
        Person personToUpdate = personService.updatePerson(id, personDtoInput);
        PersonDtoOutput personUpdated = new PersonDtoOutput(personToUpdate);
        return personUpdated;

    }

    @DeleteMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable int id){
        personService.deleteUser(id);
        return "delete";
    }

    @GetMapping("/person")
    public List<Person> getAll(){
        return personService.getPersons();
    }

    @GetMapping("/person/{id}")
    public Person getById(@PathVariable int id) throws  Exception {
        return personService.findById(id);
    }

    @GetMapping("/person/user/{user}")
    public Person getByUser(@PathVariable String user)  {
        return personService.findByUser(user);
    }

}


