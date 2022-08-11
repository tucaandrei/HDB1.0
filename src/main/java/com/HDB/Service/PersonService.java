package com.HDB.Service;

import com.HDB.Entity.Medic;
import com.HDB.Entity.Person;
import com.HDB.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public void createPerson(String name, Medic medic,String cnp){
        personRepository.save(new Person(name,medic,cnp));
    }
    public Person readPerson(String name){
       return personRepository.findByName(name);
    }
    public void updatePerson(String oldName,String newName, Medic medic){
        Person person=personRepository.findByName(oldName);
        person.setName(newName);
        person.setMedic(medic);
    }
    public void deletePerson(String name){
        personRepository.deleteByName(name);
    }
}
