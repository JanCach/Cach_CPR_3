package accounts;

import people.Owner;

public class SavingsAccount extends BankAccount implements InterestPoint {

    private static final float INTEREST = 0.5f;
    private static final float BONUS_FEE = 0.5f;

    public SavingsAccount(String uuid, String accountNumber, Owner owner) {
        super(uuid, accountNumber, owner);
    }

    public SavingsAccount(Owner owner) {
        super(owner);
    }

    public SavingsAccount(Owner owner, double balance) {
        super(owner, balance);
    }

    @Override
    public void calculateInterest() {
        double interest = this.balance * INTEREST;

        this.setNewBalance(this.getBalance() + interest);
    }
}