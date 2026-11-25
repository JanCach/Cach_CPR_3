package accounts.decorators;

import accounts.BankAccount;
import accounts.services.IAccountService;
import people.Owner;

import java.time.LocalTime;
import java.util.List;

public class AccountLoggingWithTimeService implements IAccountService {

    IAccountService service;

    public AccountLoggingWithTimeService(IAccountService service) {
        this.service = service;
    }

    @Override
    public BankAccount createCurrentAccount(Owner owner, double balance, String currency) {
        this.logStart();
        BankAccount account = this.service.createCurrentAccount(owner, balance, currency);
        this.logEnd();

        return account;
    }

    @Override
    public BankAccount createStudentAccount(Owner owner, double balance, String currency, String school) {
        this.logStart();
        BankAccount account = this.service.createStudentAccount(owner, balance, currency, school);
        this.logEnd();

        return account;
    }

    @Override
    public BankAccount createSavingAccount(Owner owner, double balance, String currency) {
        this.logStart();
        BankAccount account = this.service.createSavingAccount(owner, balance, currency);
        this.logEnd();

        return account;
    }

    @Override
    public BankAccount createBusinessAccount(Owner owner, double balance, String currency) {
        this.logStart();
        BankAccount account = this.service.createBusinessAccount(owner, balance, currency);
        this.logEnd();

        return account;
    }

    @Override
    public List<BankAccount> getAccounts() {
        return this.service.getAccounts();
    }

    private void logStart() {
        System.out.println("Creating account started, " + LocalTime.now());
    }

    private void logEnd() {
        System.out.println("Creating account finished, " + LocalTime.now());
    }
}