package accounts;

import people.AccountOwner;

public class StudentAccount extends BankAccount{

    private String schoolName;

    public StudentAccount(
            AccountOwner accountOwner,
            String accountNumber,
            double balance,
            String schoolName
    ) {
        super(accountOwner, accountNumber, balance);
        this.schoolName = schoolName;
    }

    public StudentAccount(
            AccountOwner accountOwner,
            String accountNumber,
            String schoolName
    ) {
        this(accountOwner, accountNumber, 0, schoolName);
    }

    @Override
    public void add(double amount) {

        double bonusAmount = amount * 0.05;

        super.add(bonusAmount);
        super.add(amount);
    }

    @Override
    public void sub(double amount) {
        double newBalance = this.balance - amount;

        if (newBalance < -5000) {
            throw new IllegalArgumentException("Studenti mohou jit jen -5000 do minusu. Ty jsi chtel jit az na " + newBalance);
        }

        this.balance -= amount;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
