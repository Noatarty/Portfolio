public interface PizzaFactory {
    Dough createDough();
    Topping createTopping();
    void cook();
}

abstract class Dough {}
abstract class Topping {}

class BretagnePizzaFactory implements PizzaFactory {
    @Override
    public Dough createDough() {
        return new ThinDough();
    }
    
    @Override
    public Topping createTopping() {
        return new BretagneTopping();
    }
    
    @Override
    public void cook() {
        System.out.println("Cuisson douce à la bretonne");
    }
}

class AlsacePizzaFactory implements PizzaFactory {
    @Override
    public Dough createDough() {
        return new ThickDough();
    }
    
    @Override
    public Topping createTopping() {
        return new AlsaceTopping();
    }
    
    @Override
    public void cook() {
        System.out.println("Cuisson à vif à l'alsacienne");
    }
}

class ThinDough extends Dough {}
class ThickDough extends Dough {}

class BretagneTopping extends Topping {
    public BretagneTopping() {
        System.out.println("Fromage de chèvre de Carhaix et andouille");
    }
}

class AlsaceTopping extends Topping {
    public AlsaceTopping() {
        System.out.println("Munster et eau de vie de prune");
    }
}

class Pizza {
    private Dough dough;
    private Topping topping;
    
    public Pizza(PizzaFactory factory) {
        this.dough = factory.createDough();
        this.topping = factory.createTopping();
        factory.cook();
    }
}

class Pizzeria {
    public static void main(String[] args) {
        PizzaFactory bretagneFactory = new BretagnePizzaFactory();
        Pizza bretagnePizza = new Pizza(bretagneFactory);
        
        System.out.println("---");
        
        PizzaFactory alsaceFactory = new AlsacePizzaFactory();
        Pizza alsacePizza = new Pizza(alsaceFactory);
    }
}