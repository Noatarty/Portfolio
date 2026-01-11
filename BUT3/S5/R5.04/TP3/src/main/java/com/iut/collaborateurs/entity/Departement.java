package com.iut.collaborateurs.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@Entity
@Table(name = "departements")
public class Departement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_departement")
    private Integer idDepartement;
    
    @Column(name = "nom_departement", nullable = false)
    private String nomDepartement;
    
    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("departement")
    private List<Collaborateur> collaborateurs;
    
    public Departement() {
    }
    
    public Departement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }
    
    public Integer getIdDepartement() {
        return idDepartement;
    }
    
    public void setIdDepartement(Integer idDepartement) {
        this.idDepartement = idDepartement;
    }
    
    public String getNomDepartement() {
        return nomDepartement;
    }
    
    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }
    
    public List<Collaborateur> getCollaborateurs() {
        return collaborateurs;
    }
    
    public void setCollaborateurs(List<Collaborateur> collaborateurs) {
        this.collaborateurs = collaborateurs;
    }
}
