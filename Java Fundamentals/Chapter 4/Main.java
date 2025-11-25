import java.time.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        additionAndConcatenation();

        stringCodePoints();

        stringIndexExamples();

        stringStartEndContains();

        stringFormatting();

        stringBuilderEquality();

        stringConcatenationAndInterning();

        arrayAndMismatchExamples();

        mathAndTimeExamples();

        stringInternComparison();

        stringBuilderInsertions();

        stringIndentAndSubstring();

        invalidCodeExamples();
    }

    private static void additionAndConcatenation() {
        int three = 3;
        String four = "4";
        System.out.println(1 + 2 + three + four);
        System.out.println();
    }

    private static void stringCodePoints() {
        var s = "We’re done feeding the animals";
        System.out.println(s.charAt(0) + " " + s.codePointAt(0));
        System.out.println(s.charAt(2) + " " + s.codePointAt(2));
        System.out.println(s.codePointBefore(3));
        System.out.println(s.codePointCount(0, 4));
        System.out.println();
    }

    private static void stringIndexExamples() {
        var name = "animals";
        System.out.println(name.indexOf('a'));
        System.out.println(name.indexOf("al"));
        System.out.println(name.indexOf('a', 4));
        System.out.println(name.indexOf("al", 5));
        System.out.println(name.indexOf('a', 2, 4));
        System.out.println(name.indexOf("al", 2, 6));
        System.out.println();
    }

    private static void stringStartEndContains() {
        System.out.println("abc".startsWith("a"));
        System.out.println("abc".startsWith("A"));
        System.out.println("abc".startsWith("b", 1));
        System.out.println("abc".startsWith("b", 2));
        System.out.println("abc".endsWith("c"));
        System.out.println("abc".endsWith("a"));
        System.out.println("abc".contains("b"));
        System.out.println("abc".contains("B"));
        System.out.println();
    }

    private static void stringFormatting() {
        var ename = "James";
        var score = 90.25;
        var total = 100;
        System.out.println("%s:%n   Sco: %f out of %d"
                .formatted(ename, score, total));
        System.out.println();
    }

    private static void stringBuilderEquality() {
        var one = new StringBuilder();
        var two = new StringBuilder();
        var three3 = one.append("a");
        System.out.println(one == two);
        System.out.println(one == three3);
        System.out.println();
    }

    private static void stringConcatenationAndInterning() {
        var singleString = "hello world";
        var concat = "hello ";
        concat += "world";
        System.out.println(singleString == concat);

        var first = "rat" + 1;
        var second = "r" + "a" + "t" + "1";
        var third = "r" + "a" + "t" + new String("1");
        System.out.println(first == second);
        System.out.println(first == second.intern());
        System.out.println(first == third);
        System.out.println(first == third.intern());
        System.out.println();
    }

    private static void arrayAndMismatchExamples() {
        var numbers = new int[10];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = i + 5;
        for (int n : numbers)
            System.out.println(n);

        System.out.println(Arrays.mismatch(new int[]{1}, new int[]{1}));
        System.out.println(Arrays.mismatch(new String[]{"a"}, new String[]{"A"}));
        System.out.println(Arrays.mismatch(new int[]{1, 2}, new int[]{1}));
        System.out.println();
    }

    private static void mathAndTimeExamples() {
        double c = Math.ceil(3.14);
        double f = Math.floor(3.14);

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());

        System.out.println(Period.ofMonths(3));

        var zone = ZoneId.of("US/Eastern");
        var date = LocalDate.of(2028, 11, 6);
        var time = LocalTime.of(2, 15);
        var z = ZonedDateTime.of(date, time, zone);
        System.out.println();
    }

    private static void stringInternComparison() {
        var ss = "Hello";
        var t = new String(ss);
        if ("Hello".equals(ss)) System.out.println("one");
        if (t == ss) System.out.println("two");
        if (t.intern() == ss) System.out.println("three");
        if ("Hello" == ss) System.out.println("four");
        if ("Hello".intern() == t) System.out.println("five");
        System.out.println();
    }

    private static void stringBuilderInsertions() {
        var sb = new StringBuilder();
        sb.append("aaa").insert(1, "bb").insert(4, "ccc");
        System.out.println(sb);
        System.out.println();
    }

    private static void stringIndentAndSubstring() {
        var numberss = "012345678".indent(1);
        numberss = numberss.stripLeading();
        System.out.println(numberss.substring(1, 3));
        System.out.println(numberss.substring(7, 7));
        System.out.println(numberss.substring(7));
        System.out.println();
    }

    private static void invalidCodeExamples() {
        // System.out.println(s.charAt(2) + " " + s.codePointAt(2)); /
        //
        // double iguana = 0;
        // do {
        //     int snake = 1;
        //     System.out.print(snake++ + " ");
        //     iguana--;
        // } while (snake <= 5);
        //
    }
}
