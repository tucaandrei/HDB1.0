package com.HDB.Entity;

import com.HDB.Repository.MedicRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicTest {
    @Test
    void twoMedicsShouldntHaveIdenticalCnps(){
        MedicRepository medicRepository;
        Medic medic1=new Medic("Costean","01019");
        Medic medic2=new Medic("Haul","01019");
        assertNotEquals(medic1.getCnp(),medic2.getCnp());
    }//aici se ocupa baza
}