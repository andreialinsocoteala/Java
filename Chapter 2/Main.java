public class Main {

    public static void main(String[] args) {
        toggleBoolean();

        bitwiseNotDemo();

        negateDouble();

        castingAndAssignment();

        comparisons();

        booleanOperators();

        shortCircuitAndPrePost();

        ternaryExamples();

        compoundAssignments();

        overflowExample();


        invalidOperations();
    }

    private static void toggleBoolean() {
        boolean isAnimalAsleep = false;
        System.out.print(isAnimalAsleep);
        isAnimalAsleep = !isAnimalAsleep;
        System.out.println(isAnimalAsleep);
        System.out.println();
    }

    private static void bitwiseNotDemo() {
        int number = 70;
        int negated = ~number;
        System.out.println(negated);
        System.out.println(~negated);
        System.out.println();
    }

    private static void negateDouble() {
        double zooTemperature = 1.21;
        System.out.println(zooTemperature);
        zooTemperature = -zooTemperature;
        System.out.println(zooTemperature);
        zooTemperature = -(-zooTemperature);
        System.out.println(zooTemperature);
        System.out.println();
    }

    private static void castingAndAssignment() {
        int fur = (int) 5;
        int hair = (short) 2;
        String type = (String) "Bird";
        short tail = (short) (4 + 10);

        long wolf = 5;
        long coyote = (wolf = 3);
        System.out.println(wolf);
        System.out.println(coyote);
        System.out.println();
    }

    private static void comparisons() {
        int gibbonNumFeet = 2, wolfNumFeet = 4, ostrichNumFeet = 2;
        System.out.println(gibbonNumFeet < wolfNumFeet);
        System.out.println(gibbonNumFeet <= wolfNumFeet);
        System.out.println(gibbonNumFeet >= ostrichNumFeet);
        System.out.println(gibbonNumFeet > ostrichNumFeet);
        System.out.println();
    }

    private static void booleanOperators() {
        boolean eyesClosed = true;
        boolean breathingSlowly = true;
        boolean resting = eyesClosed | breathingSlowly;
        boolean asleep = eyesClosed & breathingSlowly;
        boolean awake = eyesClosed ^ breathingSlowly;
        System.out.println(resting);
        System.out.println(asleep);
        System.out.println(awake);
        System.out.println();
    }

    private static void shortCircuitAndPrePost() {
        int ph = 7, vis = 2;
        boolean clear = vis > 1 & (vis < 9 || ph < 2);
        boolean safe = (vis > 2) && (ph++ > 1);
        boolean tasty = 7 <= --ph;
        System.out.println(clear + "-" + safe + "-" + tasty);
        System.out.println();
    }

    private static void ternaryExamples() {
        int a = 2, b = 4, c = 2;
        System.out.println(a > 2 ? --c : b++);
        System.out.println(b = (a != c ? a : b++));
        System.out.println(a > b ? (b < c ? b : 2) : 1);
        System.out.println();
    }

    private static void compoundAssignments() {
        int ticketsTaken = 1;
        int ticketsSold = 3;
        ticketsSold += 1 + ticketsTaken++;
        ticketsTaken *= 2;
        ticketsSold += (long) 1;
        System.out.println("ticketsSold=" + ticketsSold + ", ticketsTaken=" + ticketsTaken);
        System.out.println();
    }

    private static void overflowExample() {
        int start = 7;
        int end = 4;
        end += ++start;
        start = (byte) (Byte.MAX_VALUE + 1);
        System.out.println("start=" + start + ", end=" + end);
        System.out.println();
    }

    private static void invalidOperations() {
        // Cod care nu compilează:
        //
        // int pelican = !5;
        // boolean penguin = -true;
        // boolean parrot = ~true;
        // boolean peacock = !0;
        //
        // long feathers = 10(long);
        //
        // boolean monkey = true == 3;
        // boolean ape = false != "Grape";
        // boolean gorilla = 10.2 == "Koko";
    }
}
