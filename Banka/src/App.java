import accounts.BankAccount;
import accounts.InterestPoint;
import accounts.StudentAccount;
import accounts.serialization.BankAccountSerialization;
import accounts.serialization.BankAccountXmlJacksonSerializationService;
import accounts.services.AccountService;

import currencies.CurrencyConverter;
import people.Owner;
import transfers.AccountTransferService;
import transfers.TransferService;

import java.util.ArrayList;
import java.util.List;

import static accounts.CreateAccount.LogAccountStart;
import static accounts.CreateAccount.LogAccountStop;
import static accounts.CreateAccount.TimeDate;

public class App {

    public void run() {
        AccountService accountService = new AccountService();

        TransferService transferService = new TransferService();
        Owner owner = new Owner("Tomas", "Pesek");

        List<BankAccount> accounts = new ArrayList<>();

        // Vytváření účtů pomocí TOVÁRNY (Factory Pattern)
        LogAccountStart();
        TimeDate();
        LogAccountStart();

        BankAccount bankAccount = accountService.createCurrentAccount(owner, 1000, "CZK");
        accounts.add(bankAccount);

        TimeDate();
        LogAccountStop();
        LogAccountStop();

        LogAccountStart();
        TimeDate();
        LogAccountStart();

        BankAccount studentAccount = accountService.createStudentAccount(owner, 100,"CZK", "DELTA SŠIE");
        accounts.add(studentAccount);

        TimeDate();
        LogAccountStop();
        LogAccountStop();

        LogAccountStart();
        TimeDate();
        LogAccountStart();

        BankAccount businessAccount = accountService.createBusinessAccount(owner, 100000, "CZK");
        accounts.add(businessAccount);

        TimeDate();
        LogAccountStop();
        LogAccountStop();


        // Výpočet úroků pro účty implementující InterestPoint
        for (BankAccount account : accounts) {
            if (account instanceof InterestPoint interestPoint) {
                interestPoint.calculateInterest();
            }
        }

        // Výpis škol pro studenty
        for (BankAccount account : accounts) {
            if (account instanceof StudentAccount overrideAccount) {
                System.out.println("School: " + overrideAccount.getSchool());
            }
        }

        // Operace převodů
        transferService.withdraw(bankAccount, 500);
        transferService.addToBalance(bankAccount, 300);
        System.out.println("Current Account Balance: " + bankAccount.getBalance() + " " + bankAccount.getCurrency());
        System.out.println("To je " + CurrencyConverter.convert(bankAccount.getBalance(), bankAccount.getCurrency(), "EUR") + " EUR");
        System.out.println("To je " + CurrencyConverter.convert(bankAccount.getBalance(), bankAccount.getCurrency(), "USD") + " USD");

        AccountTransferService accountTransferService = new AccountTransferService();
        accountTransferService.transfer(businessAccount, studentAccount, 10000);

        System.out.println("New Business Balance: " + businessAccount.getBalance() + " " + businessAccount.getCurrency());
        System.out.println("To je " + CurrencyConverter.convert(businessAccount.getBalance(), businessAccount.getCurrency(), "EUR") + " EUR");
        System.out.println("To je " + CurrencyConverter.convert(businessAccount.getBalance(), businessAccount.getCurrency(), "USD") + " USD");

        System.out.println("New Student Balance: " + studentAccount.getBalance() + " " + studentAccount.getCurrency());
        System.out.println("To je " + CurrencyConverter.convert(studentAccount.getBalance(), studentAccount.getCurrency(), "EUR") + " EUR");
        System.out.println("To je " + CurrencyConverter.convert(studentAccount.getBalance(), studentAccount.getCurrency(), "USD") + " USD");


        // --- SERIALIZACE POMOCÍ JACKSON XML ---
        System.out.println("\n--- SERIALIZACE (Jackson XML) ---");
        BankAccountSerialization jacksonSerializationService = new BankAccountXmlJacksonSerializationService();

        // Serializace jednoho účtu
        String singleAccountXml = jacksonSerializationService.serialize(bankAccount);
        System.out.println("Single Account XML:\n" + singleAccountXml);

        // Serializace všech účtů v seznamu
        String allAccountsXml = jacksonSerializationService.serializeAll(accounts);
        System.out.println("All Accounts XML:\n" + allAccountsXml);
        System.out.println("--- KONEC SERIALIZACE ---");
    }
}
