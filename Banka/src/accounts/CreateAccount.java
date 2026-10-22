package accounts;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class CreateAccount {
    public static void LogAccountStart() {
        System.out.println(" Vytvářím účet");
    }

    public static void LogAccountStop() {
        System.out.println(" Vytvořil jsem účet");
    }

    public static void TimeDate() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");

        String formattedDate = myDateObj.format(myFormatObj);
        System.out.print(formattedDate);
    }
}
