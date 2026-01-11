package com.iut.collaborateurs.controller;

import com.iut.collaborateurs.entity.Collaborateur;
import com.iut.collaborateurs.service.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {
    
    @Autowired
    private CollaborateurService collaborateurService;
    
    @GetMapping
    public List<Collaborateur> listerCollaborateurs() {
        return collaborateurService.getAllCollaborateurs();
    }
    
    @GetMapping("/{idDepartement}")
    public List<Collaborateur> listerCollaborateursParDepartement(@PathVariable Integer idDepartement) {
        return collaborateurService.getCollaborateursByDepartement(idDepartement);
    }
    
    @GetMapping("/{matricule}")
    public Collaborateur listerCollaborateurParMatricule(@PathVariable String matricule) {
        return collaborateurService.getCollaborateurByMatricule(matricule);
    }
    
    @GetMapping("/nom/{nom}")
    public List<Collaborateur> listerCollaborateursParNom(@PathVariable String nom) {
        return collaborateurService.getCollaborateursByNom(nom);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Collaborateur> createCollaborateur(@RequestBody Collaborateur collaborateur) {
        Collaborateur newCollaborateur = collaborateurService.saveCollaborateur(collaborateur);
        return new ResponseEntity<>(newCollaborateur, HttpStatus.CREATED);
    }
    
    @PutMapping("/{matricule}")
    public ResponseEntity<Collaborateur> updateCollaborateur(@PathVariable String matricule, @RequestBody Collaborateur collaborateur) {
        Collaborateur updatedCollaborateur = collaborateurService.updateCollaborateur(matricule, collaborateur);
        return new ResponseEntity<>(updatedCollaborateur, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{matricule}")
    public ResponseEntity<Void> deleteCollaborateur(@PathVariable String matricule) {
        collaborateurService.deleteCollaborateur(matricule);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
