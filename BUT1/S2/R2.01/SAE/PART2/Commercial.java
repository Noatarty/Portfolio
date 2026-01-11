package SAE.PART2;

public class Commercial {
    private String identif;
    private String specialite;

    public Commercial(String identif, String specialite) {
        this.identif = identif;
        this.specialite = specialite;
    }

    public String getIdentif() {
        return identif;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setIdentif(String identif) {
        this.identif = identif;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String toString() {
        return specialite + " " + identif;
    }

    public void affiche() {
        System.out.println(this.toString());
    }

    public boolean equals(Commercial c) {
        if (c == null) {
            return false;
        }
        if (this.identif.compareTo(c.getIdentif()) == 0 && this.specialite.compareTo(c.getSpecialite()) == 0) {
            return true;
        }
        return false;
    }

}
