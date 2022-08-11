package com.HDB.Service;

import com.HDB.Entity.Nurse;
import com.HDB.Repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NurseService {
    @Autowired
    NurseRepository nurseRepository;
    public void createNurse(String name,String cnp){
        nurseRepository.save(new Nurse(name,cnp));
    }
    public Nurse readNurse(String name){
        return nurseRepository.findByName(name);
    }
    public void updateNurse(String oldName,String newName,String cnp){
        Nurse nurse = nurseRepository.findByName(oldName);
        nurse.setName(newName);
        nurse.setCnp(cnp);
    }
    public void deleteNurse(String name){
        nurseRepository.deleteByName(name);
    }

}
