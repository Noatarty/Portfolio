// ComptePersonne

class Personne {
	private String nom, prenom, adresse;

	Personne(String nom, String prenom, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public String toString() {
		return nom + " " + " " + prenom + " " + adresse;
	}

	public void afficher() {
		System.out.println("Nom : " + nom);
		System.out.println("Prenom : " + prenom);
		System.out.println("Adresse : " + adresse);
	}

	public String getNom() {
		return nom + " " + prenom;
	}
}

class Compte {
	private String numero;
	private Personne titulaire;
	private double solde;

	Compte(String i, Personne ti) {
		this.numero = i;
		this.titulaire = ti;
		this.solde = 0;
	}

	public String toString() {
		return "compte numero : " + numero + " titulaire : " + titulaire.getNom() + "solde : " + solde;
	}

	void afficher() {
		System.out.println("compte numero : " + numero + " titulaire : " + titulaire.getNom() + "solde : " + solde);
	}

	void deposer(double montant) {
		solde += montant;
	}

	void retirer(double montant) {
		if ((montant - solde) >= 0) {
			solde -= montant;
		} else {
			System.out.println("Le compte n'est pas suffisament aprovisionne pour retirer " + montant);
		}
	}
}

class CompteRemunere extends Compte {
	private String numero;
	private Personne titulaire;
	private double solde;
	private double taux;

	// constructeur
	public CompteRemunere(String i, Personne ti, double solde, double taux) {
		super(i, ti);
		this.numero = i;
		this.titulaire = ti;
		this.solde = solde;
		this.taux = taux;
	}

	public String toString() {
		return "compte numero : " + numero + " titulaire : " + titulaire.getNom() + "solde : " + solde + "taux : "
				+ taux;
	}

	// affichage
	public void afficher() {
		System.out.println("compte numero : " + numero + " titulaire : " + titulaire.getNom() + "solde : " + solde
				+ "taux : " + taux);
	}

	// versementInt() : verse les intérêts sur le solde du compte remunéré
	public void versementInt() {
		solde += solde * taux;
	}
}

class Td4_Banque {
	public static void main(String[] args) {
		Personne p1 = new Personne("Dupont", "Jean", "1 rue des fleurs");
		Personne p2 = new Personne("Durand", "Marie", "2 rue des fleurs");
		// affichage des personnes
		p1.afficher();
		p2.afficher();
		// création des comptes
		Compte c1 = new Compte("12345678", p1);
		Compte c2 = new Compte("23456789", p2);
		// affichage des comptes
		c1.afficher();
		c2.afficher();
		// dépôt de 1000
		c1.deposer(1000);
		c2.deposer(500);
		// affichage des comptes
		c1.afficher();
		c2.afficher();
		// retirer de 1000
		c1.retirer(1000);
		c2.retirer(1000);
		// affichage des comptes
		c1.afficher();
		c2.afficher();
		// création des comptes rémunérés
		CompteRemunere cr1 = new CompteRemunere("12345678", p1, 10, 0.05);
		CompteRemunere cr2 = new CompteRemunere("23456789", p2, 100, 0.10);
		// affichage des comptes
		cr1.afficher();
		cr2.afficher();
	}
}
