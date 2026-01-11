package com.iut.collaborateurs.service;

import com.iut.collaborateurs.entity.Collaborateur;
import com.iut.collaborateurs.repository.CollaborateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CollaborateurService {
    
    @Autowired
    private CollaborateurRepository collaborateurRepository;
    
    public List<Collaborateur> getAllCollaborateurs() {
        return collaborateurRepository.findAll();
    }
    
    public Collaborateur getCollaborateurByMatricule(String matricule) {
        return collaborateurRepository.findByMatricule(matricule)
            .orElseThrow(() -> new RuntimeException("Collaborateur non trouvé avec le matricule: " + matricule));
    }
    
    public List<Collaborateur> getCollaborateursByNom(String nom) {
        return collaborateurRepository.findByNom(nom);
    }
    
    public List<Collaborateur> getCollaborateursByDepartement(Integer idDepartement) {
        return collaborateurRepository.findByDepartementIdDepartement(idDepartement);
    }
    
    public List<Collaborateur> getCollaborateursActifs() {
        return collaborateurRepository.findByActif(true);
    }
    
    public Collaborateur saveCollaborateur(Collaborateur collaborateur) {
        return collaborateurRepository.save(collaborateur);
    }
    
    public Collaborateur updateCollaborateur(String matricule, Collaborateur collaborateurDetails) {
        Collaborateur collaborateur = getCollaborateurByMatricule(matricule);
        
        collaborateur.setNom(collaborateurDetails.getNom());
        collaborateur.setPrenom(collaborateurDetails.getPrenom());
        collaborateur.setCivilite(collaborateurDetails.getCivilite());
        collaborateur.setAdressePostale(collaborateurDetails.getAdressePostale());
        collaborateur.setEmailProfessionnel(collaborateurDetails.getEmailProfessionnel());
        collaborateur.setNumeroSecuriteSociale(collaborateurDetails.getNumeroSecuriteSociale());
        collaborateur.setPhotoUrl(collaborateurDetails.getPhotoUrl());
        collaborateur.setActif(collaborateurDetails.getActif());
        collaborateur.setIntitulePoste(collaborateurDetails.getIntitulePoste());
        collaborateur.setNomBanque(collaborateurDetails.getNomBanque());
        collaborateur.setBic(collaborateurDetails.getBic());
        collaborateur.setBan(collaborateurDetails.getBan());
        collaborateur.setDepartement(collaborateurDetails.getDepartement());
        
        return collaborateurRepository.save(collaborateur);
    }
    
    public void deleteCollaborateur(String matricule) {
        Collaborateur collaborateur = getCollaborateurByMatricule(matricule);
        collaborateurRepository.deleteById(collaborateur.getIdCollaborateur());
    }
}
