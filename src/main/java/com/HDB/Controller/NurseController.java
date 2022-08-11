package com.HDB.Controller;

import com.HDB.Entity.Nurse;
import com.HDB.Repository.NurseRepository;
import com.HDB.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NurseController {
    @Autowired
    private NurseRepository nurseRepository;
    @GetMapping("/nurses")
    public List<Nurse> getAllNurses(){
        return nurseRepository.findAll();
    }
    @PostMapping("/nurses")
    public Nurse createNurse(@RequestBody Nurse nurse){
        return nurseRepository.save(nurse);
    }
    @GetMapping("/nurses/{id}")
    public Nurse getNurseById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        Nurse nurse = nurseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found" + id));
        return nurse;
    }
    @PutMapping("/nurses/{id}")
    public ResponseEntity<Nurse> updatePerson(@PathVariable(value="id") long id, @RequestBody Nurse personDetails) throws ResourceNotFoundException{
        Nurse nurse = nurseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"+id));
        nurse.setName(personDetails.getName());
        nurse.setCnp(personDetails.getCnp());
        nurseRepository.save(nurse);
        return ResponseEntity.ok().body(nurse);
    }
    @DeleteMapping("/nurses/{id}")
    public ResponseEntity<?> deleteNurse(@PathVariable(value="id")long id)throws ResourceNotFoundException{
        nurseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found" + id));
        nurseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
