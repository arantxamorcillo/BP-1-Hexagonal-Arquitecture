package com.example.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonRepository personRepository;



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
    public String addPerson(@RequestBody Person person) throws Exception {

        String message;

        if(person.user == null){
            throw new Exception("User mustn't be null");
//            message = "User mustn't be null";
        }else {
            personRepository.saveAndFlush(person);
            message = "Added "+person;
        }
        return message;
    }

//    @PutMapping("{attribute}")
//    public Person updatePerson(@PathVariable int id, @RequestBody Person person){
//        Person personToUpdate = personRepository.getById(id);
//        personToUpdate.
//
//    }

    @GetMapping("/person")
    public List<Person> getAll(){
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public Person getById(@PathVariable int id) throws  Exception {
        return personRepository.findById(id).orElseThrow(() -> new Exception("id not found"));
    }

    @GetMapping("/person/user/{user}")
    public Person getByUser(@PathVariable String user)  {
        return personRepository.findByUser(user);
    }

}


