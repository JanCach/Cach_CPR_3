package accounts;

import people.AccountOwner;

public class SavingsAccount extends BankAccount {

    private static final double INTEREST_RATE = 0.005; // 0,5 %

    public SavingsAccount(AccountOwner owner) {
        super(owner);
    }

    public SavingsAccount(AccountOwner owner, double balance) {
        super(owner, balance);
    }

    @Override
    public void add(double amount) {
        double interest = amount * INTEREST_RATE;
        double totalAmount = amount + interest;

        System.out.println("Přidané množství je " + amount + " (+ úrok " + interest + ")");

        super.add(totalAmount);
    }
}