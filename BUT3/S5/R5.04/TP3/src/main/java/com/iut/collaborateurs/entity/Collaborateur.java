package com.iut.collaborateurs.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "collaborateurs")
public class Collaborateur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_collaborateur")
    private Integer idCollaborateur;
    
    @Column(name = "matricule", unique = true, nullable = false)
    private String matricule;
    
    @Column(name = "nom", nullable = false)
    private String nom;
    
    @Column(name = "prenom", nullable = false)
    private String prenom;
    
    @Column(name = "adresse_postale")
    private String adressePostale;
    
    @Column(name = "email_professionnel")
    private String emailProfessionnel;
    
    @Column(name = "numero_securite_sociale")
    private String numeroSecuriteSociale;
    
    @Column(name = "photo_url")
    private String photoUrl;
    
    @Column(name = "actif")
    private Boolean actif;
    
    @Column(name = "intitule_poste")
    private String intitulePoste;
    
    @Column(name = "civilite")
    private String civilite;
    
    @Column(name = "nom_banque")
    private String nomBanque;
    
    @Column(name = "bic")
    private String bic;
    
    @Column(name = "ban")
    private String ban;
    
    @ManyToOne
    @JoinColumn(name = "id_departement")
    @JsonIgnoreProperties("collaborateurs")
    private Departement departement;
    
    public Collaborateur() {
        this.actif = true;
    }
    
    public Collaborateur(String matricule, String nom, String prenom) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.actif = true;
    }
    
    public Integer getIdCollaborateur() {
        return idCollaborateur;
    }
    
    public void setIdCollaborateur(Integer idCollaborateur) {
        this.idCollaborateur = idCollaborateur;
    }
    
    public String getMatricule() {
        return matricule;
    }
    
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getAdressePostale() {
        return adressePostale;
    }
    
    public void setAdressePostale(String adressePostale) {
        this.adressePostale = adressePostale;
    }
    
    public String getEmailProfessionnel() {
        return emailProfessionnel;
    }
    
    public void setEmailProfessionnel(String emailProfessionnel) {
        this.emailProfessionnel = emailProfessionnel;
    }
    
    public String getNumeroSecuriteSociale() {
        return numeroSecuriteSociale;
    }
    
    public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }
    
    public String getPhotoUrl() {
        return photoUrl;
    }
    
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    
    public Boolean getActif() {
        return actif;
    }
    
    public void setActif(Boolean actif) {
        this.actif = actif;
    }
    
    public String getIntitulePoste() {
        return intitulePoste;
    }
    
    public void setIntitulePoste(String intitulePoste) {
        this.intitulePoste = intitulePoste;
    }
    
    public String getCivilite() {
        return civilite;
    }
    
    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }
    
    public String getNomBanque() {
        return nomBanque;
    }
    
    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }
    
    public String getBic() {
        return bic;
    }
    
    public void setBic(String bic) {
        this.bic = bic;
    }
    
    public String getBan() {
        return ban;
    }
    
    public void setBan(String ban) {
        this.ban = ban;
    }
    
    public Departement getDepartement() {
        return departement;
    }
    
    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
