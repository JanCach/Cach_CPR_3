package accounts;

import notifiers.EmailNotifier;
import notifiers.Notifier;
import people.Owner;
import transfers.Withdraw;

import java.util.UUID;

// kod banky  2010

public abstract class BankAccount implements Withdraw {

    private String uuid;

    private String accountNumber; // 2102405518

    private Owner owner;

    protected double balance;

    // 1
    // 2
    // 3
    // 4
    // 5
    // 6


    public BankAccount(Owner owner) {
        this.owner = owner;
        this.balance = 0;
    }

    public BankAccount(Owner owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public BankAccount(String uuid, String accountNumber, Owner owner) {
        
    }

    @Override
    public void setNewBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}