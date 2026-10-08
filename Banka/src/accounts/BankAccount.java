package accounts;

import notifiers.EmailNotifier;
import notifiers.Notifier;
import people.Owner;
import transfers.Withdraw;

public abstract class BankAccount implements Withdraw {

    private String uuid;
    private String accountNumber;
    private Owner owner;
    protected double balance;
    protected Notifier notifier = new EmailNotifier();

    // Default constructor for serialization
    public BankAccount() {}

    public BankAccount(String uuid, String accountNumber, Owner owner) {
        this.uuid = uuid;
        this.accountNumber = accountNumber;
        this.owner = owner;
    }

    public BankAccount(Owner owner) {
        this.owner = owner;
        this.balance = 0;
    }

    public BankAccount(Owner owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    // Getters and Setters required for JavaBeans conventions
    public String getUuid() { return uuid; }
    public void setUuid(String uuid) { this.uuid = uuid; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public Owner getOwner() { return owner; }
    public void setOwner(Owner owner) { this.owner = owner; }

    @Override
    public double getBalance() { return this.balance; }

    @Override
    public void setNewBalance(double balance) { this.balance = balance; }
}