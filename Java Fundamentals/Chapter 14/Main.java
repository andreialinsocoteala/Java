import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        io(new File("src/ex.txt"));

        System.out.println();
        try {
            nio(Path.of("src"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        testSubpath();
        System.out.println();
        testNormalize();
        System.out.println();
        try {
            testMissmatchAndIsSameFile();
        } catch (IOException e) {
            System.out.println("IO Exception: " + e);
        }
        System.out.println();
        try {
            copyStream(new FileInputStream("src/ex.txt"), new FileOutputStream("src/ex_copy.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println();

        var gorillas = new ArrayList<Gorilla>();
        gorillas.add(new Gorilla("George", 5, true, "Bananas"));
        gorillas.add(new Gorilla("Martha", 7, false, "Apples"));
        var dataFile = new File("src/gorillas.dat");
        try {
            saveToFile(gorillas, dataFile);
            var loadedGorillas = readFromFile(dataFile);
            for (var g : loadedGorillas) {
                System.out.println("Gorilla: " + g);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Exception: " + e);
        }

    }

    public static void io(File file) {
        if (file.exists()) {
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Parent Path: " + file.getParent());
            if (file.isFile()) {
                System.out.println("Size: " + file.length());
                System.out.println("Last Modified: " + file.lastModified());
            } else {
                for (File subfile : file.listFiles()) {
                    System.out.println("   " + subfile.getName());
                }
            }
        }
    }

    public static void nio(Path path) throws IOException {
        if (Files.exists(path)) {
            System.out.println("Absolute Path: " + path.toAbsolutePath());
            System.out.println("Is Directory: " + Files.isDirectory(path));
            System.out.println("Parent Path: " + path.getParent());
            if (Files.isRegularFile(path)) {
                System.out.println("Size: " + Files.size(path));
                System.out.println("Last Modified: "
                        + Files.getLastModifiedTime(path));
            } else {
                try (Stream<Path> stream = Files.list(path)) {
                    stream.forEach(p ->
                            System.out.println("   " + p.getFileName()));
                }
            }
        }
    }

    public static void testSubpath()
    {
        var p = Path.of("/mammal/omnivore/raccoon.image");
        System.out.println("Path is: " + p);
        for (int i = 0; i < p.getNameCount(); i++) {
            System.out.println("   Element " + i + " is: " + p.getName(i));
        }
        System.out.println();
        System.out.println("subpath(0,3): " + p.subpath(0, 3));
        System.out.println("subpath(1,2): " + p.subpath(1, 2));
        System.out.println("subpath(1,3): " + p.subpath(1, 3));
    }

    public static void testNormalize()
    {
        var p1 = Path.of("./armadillo/../shells.txt");
        System.out.println(p1.normalize());

        var p2 = Path.of("/cats/../panther/food");
        System.out.println(p2.normalize());

        var p3 = Path.of("../../fish.txt");
        System.out.println(p3.normalize());

        var p4 = Path.of("/pony/../weather.txt");
        var p5 = Path.of("/weather.txt");
        System.out.println(p4.equals(p5));
        System.out.println(p4.normalize().equals(p5.normalize()));
    }

    public static void testMissmatchAndIsSameFile() throws IOException
    {
        System.out.println(Files.isSameFile(
                Path.of("/animals/cobra"),
                Path.of("/animals/snake")));


        System.out.println(Files.isSameFile(
                Path.of("/animals/monkey/ears.png"),
                Path.of("/animals/wolf/ears.png")));

        System.out.println(Files.mismatch(
                Path.of("/animals/monkey.txt"),
                Path.of("/animals/wolf.txt")));
    }

    public static void copyStream(InputStream in, OutputStream out) throws IOException {
        int batchSize = 1024;
        var buffer = new byte[batchSize];
        int lengthRead;
        while ((lengthRead = in.read(buffer, 0, batchSize)) > 0) {
            out.write(buffer, 0, lengthRead);
            out.flush();
        }
    }

    static void saveToFile(List<Gorilla> gorillas, File dataFile)
            throws IOException {
        try (var out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dataFile)))) {
            for (Gorilla gorilla : gorillas)
                out.writeObject(gorilla);
        }
    }

    static List<Gorilla> readFromFile(File dataFile) throws IOException,
            ClassNotFoundException {
        var gorillas = new ArrayList<Gorilla>();
        try (var in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                var object = in.readObject();
                if (object instanceof Gorilla g)
                    gorillas.add(g);
            }
        } catch (EOFException e) {

        }
        return gorillas;
    }

}