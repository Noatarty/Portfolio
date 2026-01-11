package com.iut.collaborateurs.controller;

import com.iut.collaborateurs.entity.Departement;
import com.iut.collaborateurs.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departements")
public class DepartementController {
    
    @Autowired
    private DepartementService departementService;
    
    @GetMapping
    public List<Departement> listerDepartements() {
        return departementService.getAllDepartements();
    }
    
    @GetMapping("/{id}")
    public Departement listerDepartementParId(@PathVariable("id") String id) {
        return departementService.getDepartementById(Integer.valueOf(id));
    }
    
    @PostMapping("/create")
    public ResponseEntity<Departement> createDepartement(@RequestBody Departement departement) {
        Departement newDepartement = departementService.saveDepartement(departement);
        return new ResponseEntity<>(newDepartement, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Departement> updateDepartement(@PathVariable Integer id, @RequestBody Departement departement) {
        Departement updatedDepartement = departementService.updateDepartement(id, departement);
        return new ResponseEntity<>(updatedDepartement, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Integer id) {
        departementService.deleteDepartement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
