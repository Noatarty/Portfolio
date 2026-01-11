public class Ex3 {
    public static void main(String[] args){
        //Créez une variable de type int, affectez-lui une valeur, puis convertissez cette variable en chaîne (ex.: le nombre 12345 devient la chaîne "12345"). Utilisez la méthode valueOf() de la classe String
        //
        int nombre = 12345;
        String nombreChaine = String.valueOf(nombre);
        System.out.println(nombreChaine);
        //Au clavier, lire une chaîne entièrement composée de chiffres et la convertir dans le nombre entier qu’elle représente (ex.: la chaîne "12345" devient le nombre 12345). La solution se trouve parmi les méthodes statiques de la classe java.lang.Integer. Après affichage du nombre entier, vous lui ajouterez 1 et afficherez le nouveau nombre obtenu. Utilisez la méthode parseInt() de la classe Integer.
        //
        int nombre2 = Integer.parseInt(nombreChaine);
        System.out.println(nombre2);
        nombre2 = nombre2 + 1;
        System.out.println(nombre2);
        //Même question que ci-dessus, mais avec un nombre flottant (ex.: la chaîne "0.12345e4"devient le nombre 0.12345e4). Après affichage du nombre, vous lui ajouterez 1.1 et afficherez le nouveau nombre obtenu. Utilisez la méthode parseFloat() de la classe Float.
        //
        float nombre3 = Float.parseFloat(nombreChaine);
        System.out.println(nombre3);
        nombre3 = nombre3 + 1.1f;
        System.out.println(nombre3);
        //Lire une chaîne représentant un nom de ville, lui enlever les éventuels blancs au début et à la fin et l’afficher entièrement en majuscules.
        //
        String ville = "   Rennes   ";
        ville = ville.trim();
        System.out.println(ville);
        //Lire deux chaînes s1 et s2 et afficher la réponse à la question: «ces deux chaînes commencent-elles par le même caractère?» Utilisez la méthode d’instance charAt.
        //
        String s1 = "abc";
        String s2 = "def";
        if(s1.charAt(0) == s2.charAt(0)){
            System.out.println("Ces deux chaines commencent-elles par le meme caractere");
        }
        else{
            System.out.println("Ces deux chaines ne commencent pas par le meme caractere");
        }
        //Lire deux chaînes s1 et s2 et afficher les résultats renvoyés par les expressions : s1==s2, s1.equals(s2), s1.compareTo(s2) et  s1.compareToIgnoreCase(s2) Entre autres, essayez les couples "abcd" et "abcd", puis "abcd" et "AbcD"
        //
        String s3 = "noabcda";
        String s4 = "abcd";
        if(s3.equals(s4)){
            System.out.println("s3 == s4");
        }
        else{
            System.out.println("s3!= s4");
        }
        if(s3.compareTo(s4) == 0){
            System.out.println("s3 == s4");
        }
        else{
            System.out.println("s3!= s4");
        }
        if(s3.compareToIgnoreCase(s4) == 0){
            System.out.println("s3 == s4");
        }
        else{
            System.out.println("s3!= s4");
        }
        //Lire deux deux chaînes s1 et s2 et afficher la réponse aux questions : s1 commence-t-elle par s2 ? s1 finit-t-elle par s2 ? s1 contient-elle s2 ? Vous  utiliserez les méthodes startsWith(), endsWith() et contains()
        //
        if(s3.startsWith(s4)){
            System.out.println("s3 commence par s4");
        }
        else{
            System.out.println("s3 ne commence pas par s4");
        }
        if(s3.endsWith(s4)){
            System.out.println("s3 finit par s4");
        }
        else{
            System.out.println("s3 ne finit pas par s4");
        }
        if(s3.contains(s4)){
            System.out.println("s3 contient s4");
        }
        else{
            System.out.println("s3 ne contient pas s4");
        }
        //Lire deux chaînes s1 et s2 et, si s1 contient s2, afficher s1 privée de s2 sinon afficher s1. Intéressez-vous à  substring  et  indexOf.
        //
        if(s3.contains(s4)){
            int index = s3.indexOf(s4);
            String avant = s3.substring(0, index); 
            String apres = s3.substring(index + s4.length());
            System.out.println(avant + apres);
        } else {
            System.out.println(s3); 
        }
    }
}