import java.util.stream.Stream;

public class PlatformVsVirtual {
    static void waitUp() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        var threads = Stream.generate(() -> Thread.ofPlatform()
                        .unstarted(PlatformVsVirtual::waitUp))
                .limit(1_000_000)
                .toList();
        threads.forEach(Thread::start);
        for (var t : threads)
            t.join();
    }

}