package accounts;

import people.AccountOwner;

public class BusinessAccount extends BankAccount {

    private static final double TRANSACTION_FEE_RATE = 0.01; // 1 %

    public BusinessAccount(AccountOwner owner) {
        super(owner);
    }

    public BusinessAccount(AccountOwner owner, double balance) {
        super(owner, balance);
    }

    @Override
    public void sub(double amount) {
        double fee = amount * TRANSACTION_FEE_RATE;
        double totalAmount = amount + fee;

        System.out.println("Sub amount is " + amount + " (+ poplatek " + fee + ")");

        super.sub(totalAmount);
    }
}