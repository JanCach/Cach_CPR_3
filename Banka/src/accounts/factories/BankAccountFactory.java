package accounts.factories;

import accounts.*;
import accounts.services.AccountNumberGenerator;
import notifiers.EmailNotifier;
import notifiers.Notifier;
import people.Owner;

import java.util.UUID;

public class BankAccountFactory {

    private static final String BANK_CODE = "0800";

    private Notifier notifier = new EmailNotifier();
    private AccountNumberGenerator accountNumberGenerator = new AccountNumberGenerator(BANK_CODE);



    public BankAccount createCurrentAccount(Owner owner, double balance, String currency) {
        CurrentAccount currentAccount = new CurrentAccount(owner, balance);
        this.initBankAccount(currentAccount, currency);

        return currentAccount;
    }

    public BankAccount createStudentAccount(Owner owner, double balance, String currency, String school) {
        StudentAccount studentAccount = new StudentAccount(owner, balance, school);
        this.initBankAccount(studentAccount, currency);

        return studentAccount;
    }

    public BankAccount createSavingAccount(Owner owner, double balance, String currency) {
        SavingAccount savingAccount = new SavingAccount(owner, balance);
        this.initBankAccount(savingAccount, currency);

        return savingAccount;
    }

    public BankAccount createBusinessAccount(Owner owner, double balance, String currency) {
        BusinessAccount businessAccount = new BusinessAccount(owner, balance);
        this.initBankAccount(businessAccount, currency);

        return businessAccount;
    }

    private void initBankAccount(BankAccount bankAccount, String currency) {
        bankAccount.setUuid(UUID.randomUUID().toString());
        bankAccount.setAccountNumber(this.accountNumberGenerator.generate());
        bankAccount.setCurrency(currency);
    }
}