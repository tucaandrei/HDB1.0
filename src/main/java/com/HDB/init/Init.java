package com.HDB.init;

import com.HDB.Entity.Medic;
import com.HDB.Entity.Person;
import com.HDB.Repository.MedicRepository;
import com.HDB.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Init {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    MedicRepository medicRepository;
    @Bean
    void populateDb(){
        populatePerson();
        populateMedic();
    }
    void populateMedic(){
        if (medicRepository.findByCnp("12345") == null) {
            medicRepository.save(new Medic("Havrincea", "12345"));
        }
    }
    void populatePerson() {
        if (personRepository.findByCnp("11234") == null) {
            personRepository.save(new Person("Tucu", medicRepository.findByCnp("12345"),"11234"));
        }
        if (personRepository.findByCnp("11134") == null) {
            personRepository.save(new Person("Radu", medicRepository.findByCnp("12345"),"11134"));
        }
        if (personRepository.findByCnp("11114") == null) {
            personRepository.save(new Person("Cipi", medicRepository.findByCnp("12345"),"11114"));
        }
    }

    void populateEvent(){

    }
}
