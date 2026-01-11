import java.util.Scanner;
public class Ex1 {
    public static void main(String[] args) {
        String ligne;
        Scanner entree= new Scanner(System.in);
        //Question 1 Ecrire  le  code  Java  correspondant  à  la  saisie  d’une  chaîne  au  clavier  puis  à  son  codage (chaque  caractère  de  la  chaîne  est  décalé  de  deux  positions  dans  l’ordre  lexicographique)  et  enfin  à l’affichage du résultat à l’écran (le codage de la chaîne « azerty » est « cbgtva »).
        //saisie d'une ligne
        System.out.println("Tapez une ligne");
        ligne = entree.next();
        //codage de la chaine
        String code = "";
        for(int i=0; i<ligne.length(); i++){
            char c = ligne.charAt(i);
            if(c >= 'a' && c <= 'z'){
                c += 2;
                if(c > 'z'){
                    c -= 26;
                }
            }
            code += c;
        }
        //affichage du résultat à l'écran
        System.out.println(code);
        //Question 2 Ecrire le code Java correspondant à la saisie d’une chaîne au clavier puis à l’affichage de la chaîne « palindrome » si celle-ci est un palindrome (et « pas palindrome » sinon).
        //saisie d'une ligne
        System.out.println("Tapez une ligne");
        ligne = entree.next();
        //verifier si la chaine est un palindrome
        String inverse = new StringBuffer(ligne).reverse().toString();
        if(ligne.equals(inverse)){
            System.out.println("palindrome");
        }
        else {
            System.out.println("pas palindrome");
        }
        entree.close();
    }
}
        

