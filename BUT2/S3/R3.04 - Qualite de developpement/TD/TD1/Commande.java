interface StartegieTaxe {
    double calculeTTC(int m);
}

abstract class Commande {
    String cli;
    int montantHT;
    StartegieTaxe st;

    public Commande(String c, int m) {
        cli = c;
        montantHT = m;
    }
    double calculeTTC(){
        return st.calculeTTC(montantHT);
    }
}