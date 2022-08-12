package com.HDB.Entity;

import com.HDB.Repository.MedicRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void personsMedicShouldBeNullIfPersonWasConstructedWithoutMedicVariable(){
        Person person = new Person("Tucu","21405");
        assertNull(person.getMedic());
    }
}