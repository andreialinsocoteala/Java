import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(average(1, 2, 3));
        System.out.println(average());

        Stream<Integer> oddNumberUnder100 = Stream.iterate(
            1,n -> n < 100, n -> n + 2);
        oddNumberUnder100.forEach(System.out::print);

        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println();
        System.out.println(s.count());

        Stream<String> ss = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = ss.min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println);

        testMatching();

        testOptional();

        testFilter();

        testMap();

        testSorted();

        testCollect();

        testCollectingIntoMaps();

        testGrouping();

        testPartitioning();

        testSpliterator();

        testEx1();

//        testEx2();

//        testEx3();
    }



    public static void testEx3(){
        Predicate<String> predicate = s -> s.length()> 3;
        var stream = Stream.iterate("-",
                s -> ! s.isEmpty(), (s) -> s + s);
        var b1 = stream.noneMatch(predicate);
        var b2 = stream.anyMatch(predicate);
        System.out.println(b1 + " " + b2);
    }

    public static void testEx1(){
        var stream = Stream.iterate("", (s) -> s + "1");
        System.out.println(stream.limit(2).map(x -> x + "2"));
    }

    public static void testEx2(){
        Predicate<String> predicate = s -> s.startsWith("g");
        var stream1 = Stream.generate(() -> "growl!");
        var stream2 = Stream.generate(() -> "growl!");
        var b1 = stream1.anyMatch(predicate);
        var b2 = stream2.allMatch(predicate);
        System.out.println(b1 + " " + b2);
    }

    public static void testSpliterator(){
        System.out.println();
        var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-",
                "mouse-");
        Spliterator<String> originalBagOfFood = stream.spliterator();
        Spliterator<String> emmasBag = originalBagOfFood.trySplit();
        emmasBag.forEachRemaining(System.out::println);
        System.out.println();
        Spliterator<String> jillsBag = originalBagOfFood.trySplit();
        jillsBag.tryAdvance(System.out::println);
        System.out.println();
        jillsBag.forEachRemaining(System.out::println);
        System.out.println();
        originalBagOfFood.forEachRemaining(System.out::println);
    }

    public static void testPartitioning(){
        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map = ohMy.collect(
                Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map);
    }

    public static void testGrouping(){
        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map = ohMy.collect(
                Collectors.groupingBy(String::length));
        System.out.println(map);
    }

    public static void testCollectingIntoMaps()
    {
        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = ohMy.collect(
                Collectors.toMap(s -> s, String::length));
        System.out.println(map);
    }

    public static void testCollect(){
        var ohMy = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result = ohMy
                .filter(s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result); // [tigers]
    }

    public static void testSorted(){
        Stream<String> s = Stream.of("brown bear-", "grizzly-");
        s.sorted(Comparator.reverseOrder())
                .forEach(System.out::print);
    }

    public static void testMap(){
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.map(String::length)
                .forEach(System.out::print);
    }

    public static void testFilter()
    {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m"))
                .forEach(System.out::print);
    }

    public static void testOptional(){
        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);

        empty.reduce(op).ifPresent(System.out::println);
        oneElement.reduce(op).ifPresent(System.out::println);
        threeElements.reduce(op).ifPresent(System.out::println);
    }
    public static void testMatching(){
        var list = List.of("monkey", "2", "chimp");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

        System.out.println(list.stream().anyMatch(pred));
        System.out.println(list.stream().allMatch(pred));
        System.out.println(list.stream().noneMatch(pred));
        System.out.println(infinite.anyMatch(pred));
    }

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) return Optional.empty();
        int sum = 0;
        for (int score : scores) sum += score;
        return Optional.of((double) sum / scores.length);
    }

}