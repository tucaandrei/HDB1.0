package com.HDB.Entity;

import javax.persistence.*;

@Entity
@Table(name="Persons")//AI PUTEA SA ADAUGI UN CNP CA CHEIE PRINCIPALA() SI SA RESCRIU EQUALS AND HASHCODE()
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "medic")
    private Medic medic;
    private String cnp;


    public Person(String name, Medic medic,String cnp) {
        this.name = name;
        this.medic = medic;
        this.cnp=cnp;
    }
    public Person(String name,String cnp) {
        this.name = name;
        this.cnp=cnp;
    }
    public Person(){}

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
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
}

