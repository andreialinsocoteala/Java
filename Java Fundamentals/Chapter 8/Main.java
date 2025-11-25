import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
       var str = "Zoo";
       StringStart methodRef = str::startsWith;
       StringStart lambda = s -> str.startsWith(s);

       System.out.println(methodRef.beginningCheck("A"));

       testSupplier();

       testConsumer();

       testBiConsumer();

       testPredicate();

       testBiPredicate();

       testFunction();

       testBiFunction();

       testUnaryOperator();

       testBinaryOperator();


    }

    private static void testSupplier()
    {
        Supplier<StringBuilder> s1 = StringBuilder::new;
        Supplier<StringBuilder> s2 = () -> new StringBuilder();

        System.out.println(s1.get());
        System.out.println(s2.get());
    }

    private static void testConsumer()
    {
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);

        c1.accept("Annie");
        c2.accept("Annie");
    }

    private static void testBiConsumer()
    {
        var map = new HashMap<String, Integer>();
        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);

        b1.accept("chicken", 7);
        b2.accept("chick", 1);

        System.out.println(map);
    }

    private static void testPredicate(){
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();

        System.out.println(p1.test(""));
        System.out.println(p2.test(""));
    }

    private static void testBiPredicate(){
        BiPredicate<String, String> b1 = String::startsWith;
        BiPredicate<String, String> b2 =
                (string, prefix) -> string.startsWith(prefix);

        System.out.println(b1.test("chicken", "chick"));
        System.out.println(b2.test("chicken", "chick"));
    }

    private static void testFunction(){
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();

        System.out.println(f1.apply("cluck"));
        System.out.println(f2.apply("cluck"));
    }

    private static void testBiFunction(){
        BiFunction<String, String, String> b1 = String::concat;
        BiFunction<String, String, String> b2 =
                (string, toAdd) -> string.concat(toAdd);

        System.out.println(b1.apply("baby ", "chick"));
        System.out.println(b2.apply("baby ", "chick"));
    }

    private static void testUnaryOperator(){
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();

        System.out.println(u1.apply("chirp"));
        System.out.println(u2.apply("chirp"));
    }
    private static void testBinaryOperator(){
        BinaryOperator<String> b1 = String::concat;
        BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);

        System.out.println(b1.apply("baby ", "chick"));
        System.out.println(b2.apply("baby ", "chick"));
    }


}



interface StringStart {
    boolean beginningCheck(String prefix);
}