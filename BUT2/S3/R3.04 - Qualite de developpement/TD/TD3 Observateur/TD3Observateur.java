import java.util.*;
import java.io.*;

interface Observateur{
	public void averti(Sujet c);
}

abstract class Sujet{
	Collection <Observateur> mesObs ;
 
            public Sujet(){
                   mesObs=new ArrayList<Observateur> () ;
            }
 
           public void attache(Observateur o){
                     mesObs.add(o) ;
            }

	public void detache(Observateur o){
                       mesObs.remove(o) ;
            }

             public void notifier(){
                 Iterator <Observateur> it ;
                 Observateur o ;

                 it=mesObs.iterator() ;
                 while (it.hasNext()){
                            o=it.next() ;
                            o.averti(this) ;
                  }
             }
}



class StationMeteo implements Observateur{
	String nomStation;
	int nbMesures;
	int sommeMesures;
	
	public StationMeteo(String n){
		nomStation=n;	
		nbMesures=0;
		sommeMesures=0;
	}




	 public void afficheMoyenne(){
		if (nbMesures>0) System.out.println("Moyenne de "+nomStation+" est :"
				+sommeMesures/nbMesures);
                        else System.out.println("Moyenne non disponible – pas de valeurs ") ;
	}



	public void averti(Sujet c){
		int v ;

                       System.out.println("Ici "+nomStation);
		System.out.println("Nouvelle mesure reçue");
                        v=((PosteMeteo)c).donnerDegre() ;
		//System.out.println(v);
		sommeMesures=sommeMesures+v;
		nbMesures++;
		
	}
}


class PosteMeteo extends Sujet{
          String nom;
	int dernierDegre;
	
	public PosteMeteo(String n){
                         super() ;
		 nom=n;
		dernierDegre=0 ;
	}

	public int donnerDegre(){
		return dernierDegre;
	}
	
	public void nouvelleMesure()throws IOException{
		String ligne;
		BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
		
        				
		System.out.println("Ici :"+nom+" donner nouveau degre ");
		// saisir un degre
		ligne = entree.readLine();
                        dernierDegre = Integer.parseInt(ligne);
	            this.notifier() ;
	}
}



public class TD3Observateur {
	public static void main(String[] args) throws IOException{
		 PosteMeteo brest, paris, londres, lyon, southampton;
		 StationMeteo fra, euro, uk;
		 
		 fra = new StationMeteo("France");
		 euro=new StationMeteo("Europe");
		 uk=new StationMeteo("UK");
		 
		 brest=new PosteMeteo("Station Brest");

		 brest.attache(fra);
		 brest.attache(euro);
		 brest.attache(uk);
		 
		 paris=new PosteMeteo("Station Paris");

		 paris.attache(fra);
		 paris.attache(euro);
		 
		 
		 londres=new PosteMeteo("Station Londres");
		 londres.attache(euro);
		 londres.attache(uk);
		 
		 lyon=new PosteMeteo("Station Lyon");
		 lyon.attache(euro);
		 lyon.attache(fra);
		 
		 southampton=new PosteMeteo("Station Southampton");
		 southampton.attache(fra);
		 southampton.attache(euro);
		 southampton.attache(uk);
		 
		 brest.nouvelleMesure();
		 paris.nouvelleMesure();
		 lyon.nouvelleMesure();
		 londres.nouvelleMesure();
		 southampton.nouvelleMesure();
		 
		 fra.afficheMoyenne();
		 uk.afficheMoyenne();
		 euro.afficheMoyenne();
		}
}