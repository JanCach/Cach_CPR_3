import accounts.*;
import accounts.serialization.BankAccountSerialization;
import accounts.serialization.BankAccountListSerialize;
import accounts.serialization.BankAccountXmlJacksonSerializationService;
import creditCards.CreditCard;
import people.Owner;
import transfers.AccountTransferService;
import transfers.TransferService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TransferService transferService = new TransferService();
        Owner owner = new Owner("Tomas", "Pesek");

        List<BankAccount> accounts = new ArrayList<>();

        // Vytváření účtů pomocí TOVÁRNY (Factory Pattern)
        BankAccount bankAccount = BankAccountFactory.createAccount(AccountType.CURRENT, owner, 1000);
        accounts.add(bankAccount);

        BankAccount studentAccount = BankAccountFactory.createAccount(AccountType.STUDENT, owner, 100, "VŠB-TUO");
        accounts.add(studentAccount);

        BankAccount businessAccount = BankAccountFactory.createAccount(AccountType.BUSINESS, owner, 100000);
        accounts.add(businessAccount);

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
        System.out.println("Current Account Balance: " + bankAccount.getBalance());

        AccountTransferService accountTransferService = new AccountTransferService();
        accountTransferService.transfer(businessAccount, studentAccount, 10000);

        System.out.println("New Business Balance: " + businessAccount.getBalance());
        System.out.println("New Student Balance: " + studentAccount.getBalance());

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