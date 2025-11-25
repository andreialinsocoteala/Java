public class Bunny {
//    private void eatCarrot() {}
////    public void bad() {
////        try {
////            eatCarrot();
////        } catch (NoMoreCarrotsException e) {
////            System.out.print("sad rabbit");
////        }
////    }
public static void main(String[] args) {
    try {
        hop();
    } catch (Exception e) {
        System.out.println(e + "\n");
        System.out.println(e.getMessage() + "\n");
        e.printStackTrace();
    }
}

    private static void hop() {
        throw new RuntimeException("cannot hop");
    }

}



class NoMoreCarrotsException extends Exception {}