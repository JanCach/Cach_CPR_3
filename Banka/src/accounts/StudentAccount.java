package accounts;

import people.AccountOwner;

public class StudentAccount extends BankAccount
{
    private String school;

    public StudentAccount(AccountOwner owner, String school) {
        super(owner);

        this.school = school;
    }

    public StudentAccount(AccountOwner owner, double balance) {
        super(owner, balance);
    }

    public String getSchool()
    {
        return this.school;
    }

}