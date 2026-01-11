import java.util.ArrayList;

public abstract class Animal {

    private int id;
    private String name;
    private String foodType;
    private int foodQuantity;

    public Animal(int id, String name, String foodType, int foodQuantity) {
        this.id = id;
        this.name = name;
        this.foodType = foodType;
        this.foodQuantity = foodQuantity;
    }

    public abstract void cri();

    @Override
    public String toString() {
        return "Animal [" + id + ", " + name + ", " + foodType + ", " + foodQuantity + "]";
    }

    public abstract boolean equals(Animal animal);

}

class Ane extends Animal {

    public Ane(int id, String name, int foodQuantity) {
        super(id, name, "foin", foodQuantity);
    }

    @Override
    public void cri() {
        System.out.println("Hi han !");
    }

    @Override
    public boolean equals(Animal animal) {
        if (!(animal instanceof Ane)) {
            return false;
        }
        return true;
    }

}

class Chouette extends Animal {

    public Chouette(int id, String name, int foodQuantity) {
        super(id, name, "viande", foodQuantity);
    }

    @Override
    public void cri() {
        System.out.println("Hou hou !");
    }

    @Override
    public boolean equals(Animal animal) {
        if (!(animal instanceof Chouette)) {
            return false;
        }
        return true;
    }

}

class Lion extends Animal {

    public Lion(int id, String name, int foodQuantity) {
        super(id, name, "viande", foodQuantity);
    }

    @Override
    public void cri() {
        System.out.println("Grrr !");
    }

    @Override
    public boolean equals(Animal animal) {
        if (!(animal instanceof Lion)) {
            return false;
        }
        return true;
    }

}

class Zoo {

    private ArrayList<Animal> animaux;

    public Zoo() {
        animaux = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animaux.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animaux.remove(animal);
    }

    public void afficherAnimaux() {
        for (Animal animal : animaux) {
            System.out.println(animal);
        }
    }

    public int nombreAnimaux() {
        return animaux.size();
    }

    public int quantiteeConsomation() {
        int somme = 0;
        for (Animal animal : animaux) {
            somme += animal.foodQuantity;
        }
        return somme;
    }
}

class Tests {

    public static void main(String[] args) {
        Ane ane = new Ane(1, "Rantanplan", 2);
        System.out.println(ane);

        Chouette chouette = new Chouette(2, "Athéna", 1);
        System.out.println(chouette);

        Lion lion = new Lion(3, "Simba", 3);
        System.out.println(lion);
    }

}