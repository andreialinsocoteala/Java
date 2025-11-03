import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundle {

    public static void printWelcomeMessage(Locale locale) {
        var rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(rb.getString("hello")
                + ", " + rb.getString("open"));
    }
    public static void main(String[] args) {
        var us = Locale.of("en", "US");
        var france = Locale.of("fr", "FR");
        printWelcomeMessage(us);
        printWelcomeMessage(france);

    }

}

