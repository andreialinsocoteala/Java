//import java.util.*;
//import java.util.concurrent.*;
//import java.util.stream.*;
//public class PrintCounter {
//    static int count = 0;
//    public static void main(String[] args) throws
//            InterruptedException, ExecutionException {
//        try (var service = Executors.newSingleThreadExecutor()) {
//            var r = new ArrayList<Future<?>>();
//            IntStream.iterate(0,i -> i + 1).limit(5).forEach(
//                    i -> r.add(service.execute(() -> {count++;}))
//            );
//            for (Future<?> result : r) {
//                System.out.print(result.get() + " ");
//            }
//        }
//    }
// }