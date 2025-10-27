class Birdd {
    int feathers = 0;
    Birdd(int x) { this.feathers = x; }
    Birdd fly() {
        return new Birdd(1);
    }
}

class Parrot extends Birdd {
    protected Parrot(int y) { super(y); }
    protected Parrot fly() {
        return new Parrot(2);
    }
}

public class Macaw extends Parrot {
    public Macaw(int z) { super(z); }
    public Macaw fly() {
        return new Macaw(3);
    }
    public static void main(String... sing) {
        Birdd p = new Macaw(4);
        System.out.print(((Parrot)p.fly()).feathers);
    }
}
