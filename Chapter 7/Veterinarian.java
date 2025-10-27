record Fish(Object type) {}
public class Veterinarian {
    public static void main(String[] args) {
        Fish f1 = new Fish("Nemo");
        Fish f2 = new Fish(Integer.valueOf(1));

        if (f1 instanceof Fish(Object t)) {
            System.out.print("Match1-");
        }
        if (f1 instanceof Fish(String t)) {
            System.out.print("Match2-");
        }
        if (f1 instanceof Fish(Integer t)) {
            System.out.print("Match3-");
        }
        if (f2 instanceof Fish(String t)) {
            System.out.print("Match4-");
        }
        if (f2 instanceof Fish(Integer x)) {
            System.out.print("Match5");
        }
    }
}
