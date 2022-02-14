package com.example.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person createPerson(Person person) {

        if (person.getUser() == null)
            throw new RuntimeException("User no puede ser nulo");

        if (person.getUser().length() > 10 || person.getUser().length() < 6)
            throw new RuntimeException("La longitud de usuario debe ser entre 6 y 10 caracteres");

//        if (person.getPassword() == null)
//            throw new RuntimeException("Password no puede ser nulo");

        if (person.getName() == null)
            throw new RuntimeException("Name no puede ser nulo");

        if (person.getPersonal_email() == null)
            throw new RuntimeException("Personal_email no puede ser nulo");

        if (person.getCompany_email() == null)
            throw new RuntimeException("Company_email no puede ser nulo");

        if (person.getCity() == null)
            throw new RuntimeException("City no puede ser nulo");

        if (person.getActive() == null)
            throw new RuntimeException("Active no puede ser nulo");

        personRepository.save(person);
        return person;
    }

    public Person findById(int id_person) throws Exception{
        return personRepository.findById(id_person).orElseThrow(() -> new Exception("Id no encontrado"));
    }

    public Person findByUser(String user) {
        return personRepository.findByUser(user);
    }

    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    public void deleteUser(int id_person){
        personRepository.deleteById(id_person);
    }
    public Person updatePerson(int id_person, PersonDtoInput personInputDTO){
        Person person = personRepository.findById(id_person).orElseThrow(() -> new RuntimeException("User no encontrado"));

        if (personInputDTO.getUser() != null)
            person.setUser(personInputDTO.getUser());

        if (personInputDTO.getPassword() != null)
            person.setPassword(personInputDTO.getPassword());

        if (personInputDTO.getName() != null && personInputDTO.getName() != "")
            person.setName(personInputDTO.getName());

        if (personInputDTO.getPersonal_email() != null)
            person.setPersonal_email(person.getPersonal_email());

        if (personInputDTO.getCompany_email() != null)
            person.setCompany_email(person.getCompany_email());

        if (personInputDTO.getCity() != null)
            person.setCity(person.getCity());

        if (personInputDTO.getActive() != null)
            person.setActive(person.getActive());

        personRepository.save(person);
        return person;
    }
}

