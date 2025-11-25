public class Weather {
    enum Seasons {
        WINTER, SPRING, SUMMER, FALL
    }

    public static void main(String[] args) {
        Seasons v = null;
        switch (v) {
            case Seasons.SPRING -> System.out.print("s");
            case Seasons.WINTER -> System.out.print("w");
            case Seasons.SUMMER -> System.out.print("m");
            default -> System.out.println("missing data"); }
    } }