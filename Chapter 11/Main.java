import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("t");
        } catch (Exception e) {
            sb.append("c");
        } finally {
            sb.append("f");
        }
        sb.append("a");
        System.out.print(sb.toString());

        LocalDate date = LocalDate.parse("2025-04-30",
                DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(date.getYear() + " "
                + date.getMonth() + " "+ date.getDayOfMonth());
    }
    public static void fall(int distance) throws IOException {
        if(distance> 10) {
            throw new IOException();
        }
    }
    public static void invalid(){
         try {
                throw new RuntimeException();
//                throw new ArrayIndexOutOfBoundsException();
         } catch (Exception e) {}

    }
}