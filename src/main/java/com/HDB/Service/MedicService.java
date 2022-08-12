package com.HDB.Service;

import com.HDB.Entity.Medic;
import com.HDB.Entity.Person;
import com.HDB.Repository.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MedicService {
    @Autowired
    MedicRepository medicRepository;
    public void createMedic(String name, String cnp){
        medicRepository.save(new Medic(name,cnp));
    }
    public Medic readMedic(String name){
        return medicRepository.findByName(name);
    }
    public void updateMedic(String oldName,String newName){
        Medic medic=medicRepository.findByName(oldName);
        medic.setName(newName);
    }
    public void deleteMedic(String name){
        medicRepository.deleteByName(name);
    }
}
