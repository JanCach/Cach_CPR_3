package accounts;

import people.AccountOwner;

public class StudentAccount extends BankAccount {

    private String school;
    private static final double doMinusu = 5000.0;

    public StudentAccount(AccountOwner owner, String school) {
        super(owner);
        this.school = school;
    }

    public StudentAccount(AccountOwner owner, double balance) {
        super(owner, balance);
    }
    public String getSchool() {
        return this.school;
    }

    @Override
    public void sub(double amount) {
        double newBalance = getBalance() - amount;

        if (newBalance < -doMinusu) {
            throw new RuntimeException("Překročen limit. Zůstatek nemůže klesnout pod -5000");
        }

        if (newBalance >= 0) {
            super.sub(amount);
        } else {

            System.out.println("Jste " + amount + "Kč pod nulou");
            super.add(-amount);
        }
    }
}