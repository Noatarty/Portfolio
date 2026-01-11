/*Exercice 1 : gestion des dates
Le but de cet exercice est d’essayer diverses manières d’obtenir et d’afficher la date courante
(encore un pretexte pour vous faire chercher dans la documentation...) */
import java.lang.System;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Ex1 {
    public static void main(String[] args){
        //Question 1 : première manière
        long date = System.currentTimeMillis();
        System.out.println(date);
        //Question 2 : deuxième manière
        ArrayList<String> listeJoursSemaine = new ArrayList<String>();
        listeJoursSemaine.add("dimanche");
        listeJoursSemaine.add("lundi");
        listeJoursSemaine.add("mardi");
        listeJoursSemaine.add("mercredi");
        listeJoursSemaine.add("jeudi");
        listeJoursSemaine.add("vendredi");
        listeJoursSemaine.add("samedi");
        ArrayList<String> listeMois = new ArrayList<String>();
        listeMois.add("janvier");
        listeMois.add("fevrier");
        listeMois.add("mars");
        listeMois.add("avril");
        listeMois.add("mai");
        listeMois.add("juin");
        listeMois.add("juillet");
        listeMois.add("août");
        listeMois.add("septembre");
        listeMois.add("octobre");
        listeMois.add("novembre");
        listeMois.add("decembre");
        Calendar c = Calendar.getInstance();
        System.out.println("Aujourd'hui est le " + listeJoursSemaine.get(c.get(Calendar.DAY_OF_WEEK) - 1) + " " + c.get(Calendar.DAY_OF_MONTH) + " " + listeMois.get(c.get(Calendar.MONTH)) + " " + c.get(Calendar.YEAR));
        //Question 3 : troisième manière (la meilleure)
        /*
        Écrivez un programme pour afficher la date d’aujourd’hui (éventuellement l’heure) sous la forme :
        • jj / mois en lettres / année   hh:mm
        • jj / mm / aa  à  hh:mm:ss
        • jour de la semaine en toutes lettres, puis jour du mois en chiffres, puis mois en lettres, puis
        année en chiffres, puis hh:mm:ss (ex : mardi 23 janvier 2018 15:47:29).
        */
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd MMMMM yyyy HH:mm");
        System.out.println("maintenant: " + f.format(d));
        SimpleDateFormat f2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("maintenant: " + f2.format(d));
        SimpleDateFormat f3 = new SimpleDateFormat("EEEE dd MMMMM yyyy HH:mm:ss");
        System.out.println("maintenant: " + f3.format(d));
    }
}