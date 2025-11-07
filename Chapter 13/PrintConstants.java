import java.util.concurrent.*;
import java.util.stream.*;
public class PrintConstants {
    public static void main(String[] args) {
        var s = Executors.newVirtualThreadPerTaskExecutor();
        DoubleStream.of(3.14159, 2.71828)
                .forEach(c -> s.submit(
                        () -> System.out.println(10 * c)));
        s.execute(() -> System.out.println("Printed"));
    }
}