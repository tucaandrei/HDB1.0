package com.HDB.Controller;

import com.HDB.Entity.Medic;
import com.HDB.Entity.Person;
import com.HDB.Repository.MedicRepository;
import com.HDB.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicController {
    @Autowired
    private MedicRepository medicRepository;

    @GetMapping("/medics")
    public List<Medic> getAllMedics() {
        return medicRepository.findAll();
    }
    @PostMapping("/medics")
    public Medic createMedic (@RequestBody Medic medic){
        if(medicRepository.findByCnp(medic.getCnp())==null)
        {return medicRepository.save(medic);}
        else{
            return null;
        }
    }
    @GetMapping("/medics/{id}")
    public Medic getMedicById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        Medic medic = medicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Medic not found" + id));
        return medic;
    }
    @PutMapping("/medics/{id}")
    public ResponseEntity<Medic> updateMedic(@PathVariable(value="id") long id, @RequestBody Medic medicDetails) throws ResourceNotFoundException{
        Medic medic = medicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"+id));
        medic.setName(medicDetails.getName());
        if(medicRepository.findByCnp(medicDetails.getCnp())==null) {
            medic.setCnp(medicDetails.getCnp());
        }else {
            return null;
        }
        medicRepository.save(medic);
        return ResponseEntity.ok().body(medic);
    }
    @DeleteMapping("/medics/{id}")
    public ResponseEntity<?> deleteMedic(@PathVariable(value="id")long id)throws ResourceNotFoundException{
        medicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found" + id));
        medicRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

