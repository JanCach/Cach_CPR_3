package accounts.services;

import accounts.BankAccount;
import accounts.factories.BankAccountFactory;
import people.Owner;

import java.util.ArrayList;
import java.util.List;

public class AccountService implements IAccountService {

    List<BankAccount> accounts = new ArrayList<>();

    BankAccountFactory accountFactory = new BankAccountFactory();

    public BankAccount createCurrentAccount(Owner owner, double balance) {
        BankAccount bankAccount = accountFactory.createCurrentAccount(owner, balance);
        accounts.add(bankAccount);

        return bankAccount;
    }

    public BankAccount createStudentAccount(Owner owner, double balance, String school) {
        BankAccount bankAccount = accountFactory.createStudentAccount(owner, balance, school);
        accounts.add(bankAccount);

        return bankAccount;
    }

    public BankAccount createSavingAccount(Owner owner, double balance) {
        BankAccount bankAccount = accountFactory.createSavingAccount(owner, balance);
        accounts.add(bankAccount);

        return bankAccount;
    }

    public BankAccount createBusinessAccount(Owner owner, double balance) {
        BankAccount bankAccount = accountFactory.createBusinessAccount(owner, balance);
        accounts.add(bankAccount);

        return bankAccount;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}