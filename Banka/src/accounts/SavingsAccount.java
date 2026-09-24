package accounts;

import people.Owner;

public class SavingAccount extends BankAccount implements InterestPoint {

    private static final float INTEREST = 0.5f;
    private static final float BONUS_FEE = 0.5f;

    public SavingAccount(String uuid, String accountNumber, Owner owner) {
        super(uuid, accountNumber, owner);
    }

    public SavingAccount(Owner owner) {
        super(owner);
    }

    public SavingAccount(Owner owner, double balance) {
        super(owner, balance);
    }

    @Override
    public void calculateInterest() {
        double interest = this.balance * INTEREST;

        this.setBalance(this.getBalance() + interest);
    }
}