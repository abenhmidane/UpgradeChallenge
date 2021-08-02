package helpers;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

public class HelpersFunctions {

    public static String dateBetween(LocalDate from, LocalDate to) {
        long days = from.until(to, ChronoUnit.DAYS);
        long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
        LocalDate randomDate = from.plusDays(randomDays);

        return randomDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).replaceAll("/", "");

    }
}
