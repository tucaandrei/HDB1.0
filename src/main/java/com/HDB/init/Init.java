package com.HDB.init;

import com.HDB.Entity.Medic;
import com.HDB.Entity.Nurse;
import com.HDB.Entity.Person;
import com.HDB.Repository.MedicRepository;
import com.HDB.Repository.NurseRepository;
import com.HDB.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Init {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    MedicRepository medicRepository;
    @Autowired
    NurseRepository nurseRepository;
    @Bean
    void populateDb(){
      //  populatePerson();
        populateMedic();
        populateNurse();
    }
    void populateMedic(){
        if (medicRepository.findByCnp("12345") == null) {
            medicRepository.save(new Medic("Havrincea","12345"));
        }
   // }
   // void populatePerson() {
        Set<Person> personSet= new HashSet<Person>();

        if (personRepository.findByCnp("11234") == null) {
            personRepository.save(new Person("Tucu", medicRepository.findByCnp("12345"),"11234"));
        }
        if (personRepository.findByCnp("11234") == null) {
            personRepository.save(new Person("Tucu", medicRepository.findByCnp("12345"),"11234"));
        }
        personSet.add(personRepository.findByCnp("11234"));
        if (personRepository.findByCnp("11134") == null) {
            personRepository.save(new Person("Radu", medicRepository.findByCnp("12345"),"11134"));
        }
        personSet.add(personRepository.findByCnp("11134"));
        if (personRepository.findByCnp("11114") == null) {
            personRepository.save(new Person("Cipi", medicRepository.findByCnp("12345"),"11114"));
        }

        personSet.add(personRepository.findByCnp("11114"));
        //medicRepository.findByCnp("12345").setPersonSet(personSet);
    }
    void populateNurse(){
        if(nurseRepository.findByCnp("123456")==null){
            nurseRepository.save(new Nurse("Agnes","123456"));
        }
    }

}
