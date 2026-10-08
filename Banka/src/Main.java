import accounts.*;
import creditCards.CreditCard;
import log.TransactionLoggerService;
import people.Owner;
import accounts.serialization.BankAccountJsonSerializationService;
import accounts.serialization.BankAccountSerialize;
import accounts.serialization.XamlBankAccountService;
import transfers.AccountTransferService;
import transfers.TransferService;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Setup Services & Domain Objects
        TransactionLoggerService transactionLog = new TransactionLoggerService();
        TransferService transferService = new TransferService(transactionLog);
        AccountTransferService accountTransferService = new AccountTransferService(transactionLog);

        Owner owner = new Owner("Tomas", "Pesek");

        List<BankAccount> accounts = new ArrayList<>();

        CurrentAccount bankAccount = new CurrentAccount(owner, 1000);
        bankAccount.setAccountNumber("2102405518");
        bankAccount.setUuid("ACC-001");
        accounts.add(bankAccount);

        StudentAccount studentAccount = new StudentAccount(owner, 100, "CTU in Prague");
        studentAccount.setAccountNumber("2102409999");
        studentAccount.setUuid("ACC-002");
        accounts.add(studentAccount);

        BusinessAccount businessAccount = new BusinessAccount(owner, 100000);
        businessAccount.setAccountNumber("2102408888");
        businessAccount.setUuid("ACC-003");
        accounts.add(businessAccount);

        // 2. Perform Operations
        for (BankAccount account : accounts) {
            if (account instanceof InterestPoint) {
                ((InterestPoint) account).calculateInterest();
            }
        }

        transferService.withdraw(bankAccount, 500);
        transferService.addToBalance(bankAccount, 300);

        CreditCard creditCard = new CreditCard(owner, 500);
        transferService.addToBalance(creditCard, 1000);
        transferService.withdraw(creditCard, 100);

        accountTransferService.transfer(businessAccount, studentAccount, 10000);

        // 3. Print Transaction Logs
        transactionLog.printLogs();

        // 4. JSON Serialization Example
        System.out.println("\n=========================================");
        System.out.println("         JSON SERIALIZATION SERVICE       ");
        System.out.println("=========================================");
        try {
            BankAccountSerialize jsonSerializer = new BankAccountJsonSerializationService();

            ByteArrayOutputStream jsonOutputStream = new ByteArrayOutputStream();
            jsonSerializer.serialize(studentAccount, jsonOutputStream);
            String jsonOutput = jsonOutputStream.toString(StandardCharsets.UTF_8);

            System.out.println("[Serialized JSON Output]:\n" + jsonOutput);

            ByteArrayInputStream jsonInputStream = new ByteArrayInputStream(jsonOutput.getBytes(StandardCharsets.UTF_8));
            StudentAccount deserializedFromJson = jsonSerializer.deserialize(jsonInputStream, StudentAccount.class);

            System.out.println("\n[Deserialized JSON Verification]:");
            System.out.println("Owner: " + deserializedFromJson.getOwner().getName() + " " + deserializedFromJson.getOwner().getLastName());
            System.out.println("School: " + deserializedFromJson.getSchool());
            System.out.println("Balance: " + deserializedFromJson.getBalance() + " CZK");
        } catch (Exception e) {
            System.err.println("JSON Serialization Error: " + e.getMessage());
            e.printStackTrace();
        }

        // 5. XAML / XML Serialization Example
        System.out.println("\n=========================================");
        System.out.println("         XAML SERIALIZATION SERVICE       ");
        System.out.println("=========================================");
        try {
            BankAccountSerialize xamlSerializer = new XamlBankAccountService();

            ByteArrayOutputStream xamlOutputStream = new ByteArrayOutputStream();
            xamlSerializer.serialize(businessAccount, xamlOutputStream);
            String xamlOutput = xamlOutputStream.toString(StandardCharsets.UTF_8);

            System.out.println("[Serialized XAML Output]:\n" + xamlOutput);

            ByteArrayInputStream xamlInputStream = new ByteArrayInputStream(xamlOutput.getBytes(StandardCharsets.UTF_8));
            BusinessAccount deserializedFromXaml = xamlSerializer.deserialize(xamlInputStream, BusinessAccount.class);

            System.out.println("\n[Deserialized XAML Verification]:");
            System.out.println("Owner: " + deserializedFromXaml.getOwner().getName() + " " + deserializedFromXaml.getOwner().getLastName());
            System.out.println("Account Number: " + deserializedFromXaml.getAccountNumber());
            System.out.println("Balance: " + deserializedFromXaml.getBalance() + " CZK");
        } catch (Exception e) {
            System.err.println("XAML Serialization Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}