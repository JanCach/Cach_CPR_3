package accounts.decorators;

import accounts.BankAccount;
import accounts.services.IAccountService;
import people.Owner;

import java.util.List;

public class AccountLoggingService implements IAccountService {

    IAccountService service;

    public AccountLoggingService(IAccountService service) {
        this.service = service;
    }

    @Override
    public BankAccount createCurrentAccount(Owner owner, double balance) {
        this.logStart();
        BankAccount account = this.service.createCurrentAccount(owner, balance);
        this.logEnd();

        return account;
    }

    @Override
    public BankAccount createStudentAccount(Owner owner, double balance, String school) {
        this.logStart();
        BankAccount account = this.service.createStudentAccount(owner, balance, school);
        this.logEnd();

        return account;
    }

    @Override
    public BankAccount createSavingAccount(Owner owner, double balance) {
        this.logStart();
        BankAccount account = this.service.createSavingAccount(owner, balance);
        this.logEnd();

        return account;
    }

    @Override
    public BankAccount createBusinessAccount(Owner owner, double balance) {
        this.logStart();
        BankAccount account = this.service.createBusinessAccount(owner, balance);
        this.logEnd();

        return account;
    }

    @Override
    public List<BankAccount> getAccounts() {
        return this.service.getAccounts();
    }

    private void logStart() {
        System.out.println("Creating account started");
    }

    private void logEnd() {
        System.out.println("Creating account finished");
    }
}