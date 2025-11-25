import java.util.*;
import java.util.concurrent.*;
public class CountZooAnimals {
    public static void performCount(int animal) {
    }
    public static void printResults(Future<?> f) {
        try {
            System.out.println(f.get(1, TimeUnit.DAYS));
        } catch (Exception e) {
            System.out.println("Exception!");
        }
    }
    public static void main(String[] args) throws Exception {
        final var r = new ArrayList<Future<?>>();
        try (var s = Executors.newSingleThreadExecutor()) {
            for (int i = 0; i < 10; i++) {
                final int animal = i;
                r.add(s.submit(() -> performCount(animal)));
            }
            r.forEach(f -> printResults(f));
        }
    } }