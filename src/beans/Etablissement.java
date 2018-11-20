/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Dell
 */

@Entity
public class Etablissement {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id ;
    private String nom ; 
    private String type ;
    private String region ;
    @OneToMany
    @JoinColumn(name = "etablissement_id")
    private List<Employe> emp = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "etablissement_id")
    private List<Etudiant> etu = new ArrayList<>();

    public Etablissement() {
    }

    public Etablissement(int id, String nom, String type, String region) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.region = region;
    }

    public List<Employe> getEmp() {
        return emp;
    }

    public void setEmp(List<Employe> emp) {
        this.emp = emp;
    }

    public List<Etudiant> getEtu() {
        return etu;
    }

    public void setEtu(List<Etudiant> etu) {
        this.etu = etu;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    
    
}
