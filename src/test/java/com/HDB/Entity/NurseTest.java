package com.HDB.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NurseTest {
    @Test
    void nurseNameShouldBeCorrect(){
        Nurse nurse=new Nurse("Agnes","16666");
        assertEquals("Agnes",nurse.getName());
    }
    @Test
    void nurseCnpShouldBeCorrect(){
        Nurse nurse=new Nurse("Agnes","16666");
        assertEquals("16666",nurse.getCnp());
    }


}