import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Lion {

    public void roar(String roar1, StringBuilder roar2) {
        roar1.concat("!!!");
        roar2.append("!!!");
    }

    public static void main(String[] args) {
        stringAndBuilderExample();
        stringOperationsExample();
        zonedDateTimeExample();
        stringBuilderPuzzle();
        localDateExample();
        dateManipulationExample();
        invalidCodeExamples();  // cod comentat
    }

    private static void stringAndBuilderExample() {
        var roar1 = "roar";
        var roar2 = new StringBuilder("roar");
        new Lion().roar(roar1, roar2);
        System.out.println(roar1 + " " + roar2);
        System.out.println();
    }

    private static void stringOperationsExample() {
        String s1 = """
   purr""";
        String s2 = "";

        s1.toUpperCase();
        s1.trim();
        s1.substring(1, 3);
        s1 += "two";

        s2 += 2;
        s2 += 'c';
        s2 += false;

        if (s2 == "2cfalse") System.out.println("==");
        if (s2.equals("2cfalse")) System.out.println("equals");
        System.out.println(s1.length());
        System.out.println();
    }

    private static void zonedDateTimeExample() {
        var date = LocalDate.of(2028, Month.MARCH, 12);
        var time = LocalTime.of(1, 30);
        var zone = ZoneId.of("US/Eastern");
        var dateTime1 = ZonedDateTime.of(date, time, zone);
        var dateTime2 = dateTime1.plus(1, ChronoUnit.HOURS);

        long diff = ChronoUnit.HOURS.between(dateTime1, dateTime2);
        int hour = dateTime2.getHour();
        boolean offset = dateTime1.getOffset() == dateTime2.getOffset();
        System.out.println("diff = " + diff);
        System.out.println("hour = " + hour);
        System.out.println("offset = " + offset);
        System.out.println();
    }

    private static void stringBuilderPuzzle() {
        var puzzle = new StringBuilder("Java");
        puzzle.append("vaJ$").append("vaJ$")
                .delete(0, 3)
                .deleteCharAt(puzzle.length() - 1);
        System.out.println(puzzle);
        System.out.println();
    }

    private static void localDateExample() {
        var d = LocalDate.of(2025, Month.APRIL, 30);
        d.plusDays(2);
        d.plusYears(3);
        System.out.println(d.getYear() + " " + d.getMonth() + " " + d.getDayOfMonth());
        System.out.println();
    }

    private static void dateManipulationExample() {
        var result = LocalDate.of(2025, Month.OCTOBER, 31)
                .plusYears(1)
                .plusMonths(-5)
                .plusMonths(1)
                .withYear(2026)
                .atTime(LocalTime.of(13, 4));
        System.out.println(result);
        System.out.println();
    }

    private static void invalidCodeExamples() {
//        var date = LocalDate.now();
//        var time = LocalTime.now();
//        var dateTime = date.atTime(time);
//        var zoneId = ZoneId.systemDefault();
//        var zonedDateTime = ZonedDateTime.of(dateTime, zoneId);
//        Instant instant = zonedDateTime.toInstant();
    }
}
