package com.HDB.Repository;

import com.HDB.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByName(String name);
    Person findByCnp(String cnp);
    void deleteByName(String name);

}

