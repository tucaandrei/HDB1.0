package com.HDB.Repository;

import com.HDB.Entity.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicRepository extends JpaRepository<Medic,Long> {
    Medic findByName(String name);
    Medic findByCnp(String cnp);
    void deleteByName(String name);
}

