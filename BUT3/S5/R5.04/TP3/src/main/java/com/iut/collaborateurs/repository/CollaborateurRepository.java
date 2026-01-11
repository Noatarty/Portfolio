package com.iut.collaborateurs.repository;

import com.iut.collaborateurs.entity.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {
    
    Optional<Collaborateur> findByMatricule(String matricule);
    
    List<Collaborateur> findByNom(String nom);
    
    List<Collaborateur> findByDepartementIdDepartement(Integer idDepartement);
    
    List<Collaborateur> findByActif(Boolean actif);
}
