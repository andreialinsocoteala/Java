public class Main {
    public static void main(String[] args)
            throws InterruptedException {
        Runnable printInventory =
                () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++)
                System.out.println("Printing record: " + i);
        };
        System.out.println("begin");
        var platformThread = Thread.ofPlatform()
                .priority(10)
                .start(printInventory);
        var virtualThread = Thread.ofVirtual()
                .start(printRecords);
        var constructorThread = new Thread(printInventory);
        constructorThread.start();
        System.out.println("end");
        platformThread.join();
        virtualThread.join();
        constructorThread.join();

        
    }

}