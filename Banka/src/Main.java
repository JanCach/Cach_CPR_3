import accounts.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import di.BankModule;

public class Main {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new BankModule());
        App app = injector.getInstance(App.class);
        app.run();

    }
}