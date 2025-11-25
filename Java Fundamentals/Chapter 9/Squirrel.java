import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public record Squirrel(int weight, String species) {

    public static void main(String[] args) {

        Squirrel s1 = new Squirrel(15, "Red");
        Squirrel s2 = new Squirrel(15, "Gray");
        Comparator<Squirrel> c = Comparator.comparing(Squirrel::species)
                .thenComparingInt(Squirrel::weight);
        List<Squirrel> squirrels = new ArrayList<>();
        squirrels.add(s1);
        squirrels.add(s2);
        Collections.sort(squirrels, c);
        System.out.println(squirrels);
    }

}