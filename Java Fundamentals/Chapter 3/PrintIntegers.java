public class PrintIntegers {
//    double dance(Object speed) {
//        return switch (speed) {
//            case 5 -> {yield 4};
//            case 10 -> 8;
//            case 15, 20 -> 12;
//            default -> 20;
//            case null -> 16;
//        }
//    }

    public static void main(String[] args) {
        int y = -2;
        do System.out.print(++y + " ");
        while (y <= 5);
    }
}
