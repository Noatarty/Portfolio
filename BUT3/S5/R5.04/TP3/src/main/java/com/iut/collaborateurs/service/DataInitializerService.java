package com.iut.collaborateurs.service;

import com.iut.collaborateurs.entity.Collaborateur;
import com.iut.collaborateurs.entity.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataInitializerService {
    
    @Autowired
    private DepartementService departementService;
    
    @Autowired
    private CollaborateurService collaborateurService;
    
    public void initialiser() {
        Departement informatique = new Departement("Informatique");
        Departement rh = new Departement("Ressources Humaines");
        Departement comptabilite = new Departement("Comptabilité");
        Departement marketing = new Departement("Marketing");
        Departement production = new Departement("Production");
        Departement commercial = new Departement("Commercial");
        
        informatique = departementService.saveDepartement(informatique);
        rh = departementService.saveDepartement(rh);
        comptabilite = departementService.saveDepartement(comptabilite);
        marketing = departementService.saveDepartement(marketing);
        production = departementService.saveDepartement(production);
        commercial = departementService.saveDepartement(commercial);
        
        Collaborateur collab1 = new Collaborateur("EMP001", "Dupont", "Jean");
        collab1.setCivilite("M.");
        collab1.setAdressePostale("10 Rue de la Paix, 75001 Paris");
        collab1.setEmailProfessionnel("jean.dupont@entreprise.com");
        collab1.setNumeroSecuriteSociale("1850567890123");
        collab1.setPhotoUrl("https://i.pravatar.cc/150?img=12");
        collab1.setActif(true);
        collab1.setIntitulePoste("Développeur Full Stack");
        collab1.setNomBanque("BNP Paribas");
        collab1.setBic("BNPAFRPPXXX");
        collab1.setBan("FR7630004000031234567890143");
        collab1.setDepartement(informatique);
        
        Collaborateur collab2 = new Collaborateur("EMP002", "Martin", "Sophie");
        collab2.setCivilite("Mme");
        collab2.setAdressePostale("25 Avenue des Champs, 69002 Lyon");
        collab2.setEmailProfessionnel("sophie.martin@entreprise.com");
        collab2.setNumeroSecuriteSociale("2750378901234");
        collab2.setPhotoUrl("https://i.pravatar.cc/150?img=5");
        collab2.setActif(true);
        collab2.setIntitulePoste("Responsable RH");
        collab2.setNomBanque("Crédit Agricole");
        collab2.setBic("AGRIFRPPXXX");
        collab2.setBan("FR7614508000501234567890154");
        collab2.setDepartement(rh);
        
        Collaborateur collab3 = new Collaborateur("EMP003", "Bernard", "Pierre");
        collab3.setCivilite("M.");
        collab3.setAdressePostale("8 Boulevard Voltaire, 31000 Toulouse");
        collab3.setEmailProfessionnel("pierre.bernard@entreprise.com");
        collab3.setNumeroSecuriteSociale("1650489012345");
        collab3.setPhotoUrl("https://i.pravatar.cc/150?img=33");
        collab3.setActif(true);
        collab3.setIntitulePoste("Chef Comptable");
        collab3.setNomBanque("Société Générale");
        collab3.setBic("SOGEFRPPXXX");
        collab3.setBan("FR7630003000301234567890165");
        collab3.setDepartement(comptabilite);
        
        Collaborateur collab4 = new Collaborateur("EMP004", "Dubois", "Marie");
        collab4.setCivilite("Mme");
        collab4.setAdressePostale("15 Rue du Commerce, 44000 Nantes");
        collab4.setEmailProfessionnel("marie.dubois@entreprise.com");
        collab4.setNumeroSecuriteSociale("2850590123456");
        collab4.setPhotoUrl("https://i.pravatar.cc/150?img=9");
        collab4.setActif(true);
        collab4.setIntitulePoste("Responsable Marketing");
        collab4.setNomBanque("LCL");
        collab4.setBic("CRLYFRPPXXX");
        collab4.setBan("FR7630002000021234567890176");
        collab4.setDepartement(marketing);
        
        Collaborateur collab5 = new Collaborateur("EMP005", "Petit", "Thomas");
        collab5.setCivilite("M.");
        collab5.setAdressePostale("30 Rue de l'Industrie, 59000 Lille");
        collab5.setEmailProfessionnel("thomas.petit@entreprise.com");
        collab5.setNumeroSecuriteSociale("1750601234567");
        collab5.setPhotoUrl("https://i.pravatar.cc/150?img=52");
        collab5.setActif(true);
        collab5.setIntitulePoste("Chef de Production");
        collab5.setNomBanque("Caisse d'Épargne");
        collab5.setBic("CEPAFRPPXXX");
        collab5.setBan("FR7610096000501234567890187");
        collab5.setDepartement(production);
        
        Collaborateur collab6 = new Collaborateur("EMP006", "Leroy", "Julie");
        collab6.setCivilite("Mme");
        collab6.setAdressePostale("42 Avenue Victor Hugo, 67000 Strasbourg");
        collab6.setEmailProfessionnel("julie.leroy@entreprise.com");
        collab6.setNumeroSecuriteSociale("2650712345678");
        collab6.setPhotoUrl("https://i.pravatar.cc/150?img=10");
        collab6.setActif(true);
        collab6.setIntitulePoste("Ingénieur Logiciel");
        collab6.setNomBanque("BNP Paribas");
        collab6.setBic("BNPAFRPPXXX");
        collab6.setBan("FR7630004000031234567890198");
        collab6.setDepartement(informatique);
        
        Collaborateur collab7 = new Collaborateur("EMP007", "Moreau", "Luc");
        collab7.setCivilite("M.");
        collab7.setAdressePostale("18 Rue du Marché, 33000 Bordeaux");
        collab7.setEmailProfessionnel("luc.moreau@entreprise.com");
        collab7.setNumeroSecuriteSociale("1850823456789");
        collab7.setPhotoUrl("https://i.pravatar.cc/150?img=15");
        collab7.setActif(true);
        collab7.setIntitulePoste("Commercial Senior");
        collab7.setNomBanque("Crédit Mutuel");
        collab7.setBic("CMCIFRPPXXX");
        collab7.setBan("FR7610278000501234567890209");
        collab7.setDepartement(commercial);
        
        Collaborateur collab8 = new Collaborateur("EMP008", "Simon", "Claire");
        collab8.setCivilite("Mme");
        collab8.setAdressePostale("5 Place de la République, 35000 Rennes");
        collab8.setEmailProfessionnel("claire.simon@entreprise.com");
        collab8.setNumeroSecuriteSociale("2750934567890");
        collab8.setPhotoUrl("https://i.pravatar.cc/150?img=20");
        collab8.setActif(false);
        collab8.setIntitulePoste("Assistante RH");
        collab8.setNomBanque("La Banque Postale");
        collab8.setBic("PSSTFRPPXXX");
        collab8.setBan("FR7620041000011234567890210");
        collab8.setDepartement(rh);
        
        collaborateurService.saveCollaborateur(collab1);
        collaborateurService.saveCollaborateur(collab2);
        collaborateurService.saveCollaborateur(collab3);
        collaborateurService.saveCollaborateur(collab4);
        collaborateurService.saveCollaborateur(collab5);
        collaborateurService.saveCollaborateur(collab6);
        collaborateurService.saveCollaborateur(collab7);
        collaborateurService.saveCollaborateur(collab8);
        
        System.out.println("Base de données initialisée avec succès!");
    }
}
