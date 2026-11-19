package accounts;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

interface DateFormatterComponent {
    String getDateString();
}

class BasicDate implements DateFormatterComponent {
    @Override
    public String getDateString() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}

abstract class DateDecorator implements DateFormatterComponent {
    protected DateFormatterComponent wrappee;

    public DateDecorator(DateFormatterComponent wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public String getDateString() {
        return wrappee.getDateString();
    }
}

class MillisecondsDecorator extends DateDecorator {
    public MillisecondsDecorator(DateFormatterComponent wrappee) {
        super(wrappee);
    }

    @Override
    public String getDateString() {
        String baseTime = wrappee.getDateString();
        String millis = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        return baseTime + " " + millis;
    }
}

public class CreateAccount {
    public static void LogAccountStart() {
        System.out.println(" Vytvářím účet");
    }

    public static void LogAccountStop() {
        System.out.println(" Vytvořil jsem účet");
    }

    public static void TimeDate() {
        DateFormatterComponent dateService = new MillisecondsDecorator(new BasicDate());
        System.out.print(dateService.getDateString());
    }
}