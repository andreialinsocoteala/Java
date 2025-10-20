import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        switchStatementExample();

        switchExpressionExample();

        listIterationExample();

        labeledLoopsExample();

        arrayLoopExamples();

        emptyListLoopExample();

        switchWithCharsExample();

        loopCountersExample();

        invalidCodeExamples();  
    }

    private static void switchStatementExample() {
        String name = "123";
        switch (name) {
            case "Sancha":        System.out.print(1);   break;
            case "Jacob", "Jake": System.out.print(2);   break;
            default:              System.out.print(999); break;
        }
        System.out.println();
        System.out.println();
    }

    private static void switchExpressionExample() {
        String name = "123";
        System.out.println(switch (name) {
            case "Sancha"        -> 1;
            case "Jacob", "Jake" -> 2;
            default              -> 999;
        });
        System.out.println();
    }

    private static void listIterationExample() {
        List<Integer> myFavoriteNumbers = new ArrayList<>();
        myFavoriteNumbers.add(10);
        myFavoriteNumbers.add(14);

        for (var a : myFavoriteNumbers) {
            System.out.print(a + ", ");
            break;
        }
        System.out.println();

        for (Object c : myFavoriteNumbers)
            System.out.print(c + ", ");

        System.out.println("\n");
    }

    private static void labeledLoopsExample() {
        int count = 0;
        BUNNY: for (int row = 1; row <= 3; row++)
            RABBIT: for (int col = 0; col < 3; col++) {
                if ((col + row) % 2 == 0)
                    break RABBIT;
                count++;
            }
        System.out.println(count);
        System.out.println();
    }

    private static void arrayLoopExamples() {
        for (var penguin : new int[2])
            System.out.println(penguin);
        System.out.println();

        var ostrich = new Character[3];
        for (var emu : ostrich)
            System.out.println(emu);
        System.out.println();
    }

    private static void emptyListLoopExample() {
        List<Integer> parrots = new ArrayList<>();
        for (var macaw : parrots)
            System.out.println(macaw);
        System.out.println();
    }

    private static void switchWithCharsExample() {
        final char a = 'A', e = 'E';
        char grade = 'B';
        switch (grade) {
            default:
            case a:
                // case 'B': 'C': System.out.print("great ");
            case 'D': System.out.print("good "); break;
            case e:
            case 'F': System.out.print("not good ");
        }
        System.out.println("\n");
    }

    private static void loopCountersExample() {
        int participants = 4, animals = 2, performers = -1;

        while ((participants = participants + 1) < 10) {}
        do {} while (animals++ <= 1);
        for (; performers < 2; performers += 2) {}

        System.out.println(participants);
        System.out.println(animals);
        System.out.println(performers);
        System.out.println();
    }

    private static void invalidCodeExamples() {

        // void printReptile(int category) {
        //     var type = switch (category) {
        //         case 1,2 -> "Snake";
        //         case 3,4 -> "Lizard";
        //         case 5,6 -> "Turtle";
        //         case 7,8 -> "Alligator";
        //     };
        //     System.out.print(type);
        // }
        //
        // for (int b : myFavoriteNumbers) {
        //     continue;
        //     System.out.print(b + ", ");
        // }
        //
        //
        // double iguana = 0;
        // do {
        //     int snake = 1;
        //     System.out.print(snake++ + " ");
        //     iguana--;
        // } while (snake <= 5);
    
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
