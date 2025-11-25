public class River {
    int Depth = 1;
    float temp = 50.0f;
    public void flow() {
        for (int i = 0; i < 1; i++) {
            int depth = 2;
            depth++;
            temp--;
        }
        System.out.println(depth);
        System.out.println(temp);
    }
    public static void main(String... s) {
        new River().flow();
    }
}
