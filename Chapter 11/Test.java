import java.text.NumberFormat;
import java.util.Locale;

public class Test {
    public static void printCurrency(Locale locale, double money) {
        System.out.println(
                NumberFormat.getCurrencyInstance().format(money)
                        + ", " + locale.getDisplayLanguage());
    }

    public static void main(String[] args) {
        var spain = Locale.of("es", "ES");
        var money = 1.23;

        Locale.setDefault(Locale.of("en", "US"));
        printCurrency(spain, money);

        Locale.setDefault(Locale.Category.DISPLAY, spain);
        printCurrency(spain, money);

        Locale.setDefault(Locale.Category.FORMAT, spain);
        printCurrency(spain, money);
    }

}
