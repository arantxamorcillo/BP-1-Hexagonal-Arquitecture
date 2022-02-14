package com.example.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonService personService;



    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        userRepository.save(user);
        return user;
    }

    @GetMapping("{id}")
    public User getById(@PathVariable String id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception("user not found"));
    }

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


