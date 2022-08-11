package com.HDB.Entity;

import javax.persistence.*;

@Entity
@Table(name="Nurses")
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String cnp;

    public Nurse(String name, String cnp) {
        this.name = name;
        this.cnp = cnp;
    }

    public Nurse() {
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

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }
}
