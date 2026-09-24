package accounts;
import people.AccountOwner;

public class BusinessAccount extends BankAccount {

    public BusinessAccount(AccountOwner accountOwner, String accountNumber) {
        super(accountOwner, accountNumber);
    }

    public BusinessAccount(AccountOwner accountOwner, String accountNumber, double balance) {
        super(accountOwner, accountNumber, balance);
    }


    @Override
    public void sub(double amount) {
        double newAmount = amount + (amount * 0.01);
        super.sub(newAmount);
    }

}
