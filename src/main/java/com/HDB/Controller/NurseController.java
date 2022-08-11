package com.HDB.Controller;

import com.HDB.Entity.Nurse;
import com.HDB.Repository.NurseRepository;
import com.HDB.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
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
        if(nurseRepository.findByCnp(nurse.getCnp())==null)
        {return nurseRepository.save(nurse);}
        else{
            return null;
        }
    }
    @GetMapping("/nurses/{id}")
    public Nurse getNurseById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        Nurse nurse = nurseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found" + id));
        return nurse;
    }
    @PutMapping("/nurses/{id}")
    public ResponseEntity<Nurse> nurseUpdate(@PathVariable(value="id") long id, @RequestBody Nurse nurseDetails) throws ResourceNotFoundException{
        Nurse nurse = nurseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"+id));
        nurse.setName(nurseDetails.getName());
        if(nurseRepository.findByCnp(nurseDetails.getCnp())==null) {
            nurse.setCnp(nurseDetails.getCnp());
        }else {
            return null;
        }
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
