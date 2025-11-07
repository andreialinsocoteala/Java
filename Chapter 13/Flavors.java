import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.LongStream;
public class Flavors {
    private static int counter;
    public static void countIceCreamFlavors()  {
        counter = 0;
        Runnable task = () -> counter++;
        LongStream.range(0, 500)
                .forEach(m -> Thread.ofPlatform()
                        .priority(1)
                        .unstarted(task)
                        .run());
        System.out.println(counter);


    }
}