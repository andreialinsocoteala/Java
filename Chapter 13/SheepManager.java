import java.util.concurrent.*;
//public class SheepManager {
//    private int sheepCount = 0;
//    private void incrementAndReport() {
//        System.out.print((++sheepCount) + " ");
//    }
//    public static void main(String[] args) {
//        try (var service = Executors.newFixedThreadPool(20)) {
//            SheepManager manager = new SheepManager();
//            for (int i = 0; i < 10; i++)
//                service.submit(() -> manager.incrementAndReport());
//        }
//    }
//}

public class SheepManager {
    private int sheepCount = 0;
    private void incrementAndReport() {
        synchronized(this) {
            System.out.print((++sheepCount) + " ");
        }
    }
    public static void main(String[] args) {
        try (var service = Executors.newFixedThreadPool(20)) {
            var manager = new SheepManager();
            for (int i = 0; i < 10; i++)
                service.submit(() -> manager.incrementAndReport());
        }
    }
}

