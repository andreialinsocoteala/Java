import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public record Duck(String name, int weight) implements Comparable<Duck> {
    public int compareTo(Duck d) {
        return name.compareTo(d.name);
    }

    public static void main(String[] args) {
        var ducks = new ArrayList<Duck>();
        ducks.add(new Duck("Quack", 5));
        ducks.add(new Duck("Puddles", 1));
        Collections.sort(ducks);
        System.out.println(ducks);

        testDuckSorting();
    }

    public static void testDuckSorting() {
        Comparator<Duck> byWeight = new Comparator<>() {
            public int compare(Duck d1, Duck d2) {
                return d1.weight() - d2.weight();
            }
        };
        var ducks = new ArrayList<Duck>();
        ducks.add(new Duck("Quack", 7));
        ducks.add(new Duck("Puddles", 10));
        Collections.sort(ducks);
        System.out.println(ducks);
        Collections.sort(ducks, byWeight);
        System.out.println(ducks);
    }
    public String toString() { return name; }
}