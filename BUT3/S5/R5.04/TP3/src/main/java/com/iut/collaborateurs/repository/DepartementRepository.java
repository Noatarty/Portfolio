package com.iut.collaborateurs.repository;

import com.iut.collaborateurs.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}
