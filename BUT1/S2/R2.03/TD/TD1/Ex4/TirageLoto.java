package Ex4;

import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Calendar;

public class TirageLoto {
    private int num;
    private Calendar dateT;
    private Collection<Integer> lesNum;

    public TirageLoto() {
        this.lesNum = new HashSet<Integer>();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Calendar getDateT() {
        return dateT;
    }

    public void setDateT(Calendar dateT) {
        this.dateT = dateT;
    }

    public void addNumero(int numero) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            throw new InputMismatchException("Vous devez saisir un entier.");
        }

        int num = sc.nextInt();

        if (num < 1 || num > 49) {
            throw new InputMismatchException("Le numero doit etre compris entre 1 et 49.");
        }

        if (this.lesNum.size() == 6) {
            throw new InputMismatchException("Vous ne pouvez ajouter plus de 6 numeros.");
        }

        if (this.lesNum.contains(num)) {
            throw new InputMismatchException("Ce numero a deja ete saisi.");
        }

        this.lesNum.add(num);
    }

    public int nbNumeroGagnants(Collection<Integer> numJoueur) {
        int nb = 0;

        for (Integer num : numJoueur) {
            if (this.lesNum.contains(num)) {
                nb++;
            }
        }

        return nb;
    }

    public static void main(String[] args) {
        TirageLoto t = new TirageLoto();
        Scanner scan = new Scanner(System.in);

        System.out.println("Veuillez saisir les 6 numeros du tirage : ");
        for (int i = 0; i < 6; i++) {
            try {
                t.addNumero(scan.nextInt());
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }
        System.out.println("Les numeros saisis sont : " + t.lesNum);
        System.out.println("Nombre de numeros gagnants : " + t.nbNumeroGagnants(t.lesNum));
        scan.close();
    }
}
