public class Zoo {
    public static void pause() {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {}
        System.out.println("Thread finished!");
    }

    public static void main(String[] unused) {
        var job = Thread.ofPlatform().start(Zoo::pause);
        System.out.println("Main method finished!");
    }
}
