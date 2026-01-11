import java.util.ArrayList;

public class Set {

    private ArrayList<Integer> elements;

    public static Set singleton(Integer x) {
        Set set = new Set();
        set.elements.add(x);
        return set;
    }

    public int cardinal() {
        return elements.size();
    }

    public Integer get(int i) {
        return elements.get(i);
    }

    public void add(Integer x) {
        if (!elements.contains(x)) {
            elements.add(x);
        }
    }

    public void print() {
        System.out.print("{");
        for (Integer element : elements) {
            System.out.print(element + ", ");
        }
        System.out.println("}");
    }

    public boolean contains(Integer x, Set otherSet) {
        return otherSet.elements.contains(x);
    }

    public Set intersect(Set otherSet) {
        Set intersection = new Set();
        for (Integer element : elements) {
            if (contains(element, otherSet)) {
                intersection.add(element);
            }
        }
        return intersection;
    }

    public boolean contains(Integer x) {
        return elements.contains(x);
    }

    public Set union(Set setSet) {
        Set union = new Set();
        union.elements.addAll(this.elements);

        for (Integer element : setSet.elements) {
            if (!this.contains(element)) {
                union.add(element);
            }
        }

        return union;
    }

}
