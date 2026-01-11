class Adherent {
    static countAdherent = 0;
    static listeAdherents = [];
    
    constructor(nom, prenom, adresse) {
        this.no_adherent = ++Adherent.countAdherent;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.licences = [];
        Adherent.listeAdherents.push(this);
    }

    changerAdresse(nouvelleAdresse) {
        this.adresse = nouvelleAdresse;
    }
    
    listeAdherents() {
        return Adherent.listeAdherents;
    }
}

class Licencie {
    static countLicence = 0;
    
    constructor(grade) {
        this.no_licence = ++Licencie.countLicence;
        this.grade = grade;
    }
    
    changerGrade(nouveauGrade) {
        this.grade = nouveauGrade;
    }
}

class Sportif extends Adherent {
    constructor(nom, prenom, adresse) {
        super(nom, prenom, adresse);
        this.totalPoints = 0;
    }
    
    ajouterPoints(points) {
        this.totalPoints += points;
    }
    
    inscrire(grade) {
        let licence = new Licencie(grade);
        this.licences.push(licence);
    }
}

let adherent1 = new Adherent("Dupont", "Jean", "10 rue de Paris");
let sportif1 = new Sportif("Martin", "Paul", "5 avenue Lyon");
sportif1.inscrire("Ceinture noire");
sportif1.ajouterPoints(10);

console.log(Adherent.listeAdherents);
