// package notifiers;

package notifiers;

public class NotifierFactory {

    public enum NotifierType {
        EMAIL,
        CONSOLE
    }

    public static Notifier createNotifier(NotifierType type) {
        return switch (type) {
            case EMAIL -> new EmailNotifier();
            case CONSOLE -> new ConsoleNotifier();
        };
    }
}