package accounts;
import people.AccountOwner;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(AccountOwner accountOwner, String accountNumber) {
        super(accountOwner, accountNumber);
    }

    public SavingsAccount(AccountOwner accountOwner, String accountNumber, double balance) {
        super(accountOwner, accountNumber, balance);
    }


    @Override
    public void add(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        double newBalance = (this.balance + amount) * 1.005;
        this.balance = newBalance;
    }

}
