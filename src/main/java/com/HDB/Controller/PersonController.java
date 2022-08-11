package com.HDB.Controller;

import com.HDB.Entity.Person;
import com.HDB.Repository.PersonRepository;
import com.HDB.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PostMapping("/persons")
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found" + id));
        return person;
    }
    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value="id") long id, @RequestBody Person personDetails) throws ResourceNotFoundException{
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"+id));
        person.setName(personDetails.getName());
        person.setMedic(personDetails.getMedic());
        personRepository.save(person);
        return ResponseEntity.ok().body(person);
    }
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value="id")long id)throws ResourceNotFoundException{
        personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found" + id));
        personRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
