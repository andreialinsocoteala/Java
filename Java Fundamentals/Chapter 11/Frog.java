public class Frog {
    static String name;
    public void hop() {
        System.out.print(name.toLowerCase() + " is hopping");
    }
    public static void main(String[] args) {
        new Frog().hop();
    }
}