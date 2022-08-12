package com.HDB.Entity;

import com.HDB.Repository.MedicRepository;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Medics")
public class Medic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    //@OneToMany(mappedBy = "medic")
    //private Set<Person> personSet;
    private String cnp;

    /*public Medic(String name,Set<Person> personSet ,String cnp) {
        this.name = name;
        this.cnp=cnp;
        this.personSet=personSet;
    }*/
    public Medic(String name ,String cnp) {
        this.name = name;
        this.cnp=cnp;
    }
    public Medic(String name){
        this.name=name;
    }
    public Medic() {
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }*/
}
