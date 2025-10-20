import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
//    void printReptile(int category) {
//        var type = switch (category) {
//            case 1,2 -> "Snake";
//            case 3,4 -> "Lizard";
//            case 5,6 -> "Turtle";
//            case 7,8 -> "Alligator";
//        };
//        System.out.print(type);
//    }

    public static void main(String[] args) {
        String name = "123";

        switch (name) {                    // Switch statement
            case "Sancha":        System.out.print(1);   break;
            case "Jacob", "Jake": System.out.print(2);   break;
            default:              System.out.print(999); break;
        }

        System.out.println(switch (name) { // Switch expression
            case "Sancha"        -> 1;
            case "Jacob", "Jake" -> 2;
            default              -> 999;
        });

        List<Integer> myFavoriteNumbers = new ArrayList<>();
        myFavoriteNumbers.add(10);
        myFavoriteNumbers.add(14);
        for (var a : myFavoriteNumbers) {
            System.out.print(a + ", ");
            break;
        }

//        for (int b : myFavoriteNumbers) {
//            continue;
//            System.out.print(b + ", ");
//        }

        for (Object c : myFavoriteNumbers)
            System.out.print(c + ", ");

        int count = 0;
        BUNNY: for (int row = 1; row <=3; row++)
            RABBIT: for (int col = 0; col <3 ; col++) {
                if ((col + row) % 2 == 0)
                    break RABBIT;
                count++;
            }
        System.out.println(count);

        for (var penguin : new int[2])
            System.out.println(penguin);

        var ostrich = new Character[3];
        for (var emu : ostrich)
            System.out.println(emu);

        List<Integer> parrots = new ArrayList<Integer>();
        for (var macaw  : parrots)
            System.out.println(macaw);

        final char a = 'A', e = 'E';
        char grade = 'B';
        switch (grade) {
            default:
            case a:
//            case 'B': 'C': System.out.print("great ");
            case 'D':      System.out.print("good "); break;
            case e:
            case 'F':      System.out.print("not good ");
        }


        int participants = 4, animals = 2, performers = -1;

        while ((participants = participants + 1) < 10) {}
        do {} while (animals++ <= 1);
        for ( ; performers < 2; performers += 2) {}

        System.out.println(participants);
        System.out.println(animals);
        System.out.println(performers);

//        double iguana = 0;
//        do {
//            int snake = 1;
//            System.out.print(snake++ + " ");
//            iguana--;
//        } while (snake <= 5);
//        System.out.println(iguana);

    }
}

class Zoo {
    enum Animal {BIRD, FISH, MAMMAL}
    void printLocation(Animal a) {
        long type = switch (a) {
            case BIRD -> 1;
            case FISH -> 2;
            case MAMMAL -> 3;
            default -> 4;
        };
        System.out.print(type);
    }
}
