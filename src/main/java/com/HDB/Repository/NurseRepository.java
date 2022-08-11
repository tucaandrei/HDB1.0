package com.HDB.Repository;

import com.HDB.Entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends JpaRepository<Nurse,Long> {
    Nurse findByName(String name);
    Nurse findByCnp(String cnp);
    void deleteByName(String name);
}
