package accounts;

import people.Owner;

public class StudentAccount extends BankAccount {
    private String school;

    public StudentAccount() { super(); }

    public StudentAccount(Owner owner, String school) {
        super(owner);
        this.school = school;
    }

    public StudentAccount(Owner owner, double balance) {
        super(owner, balance);
    }

    public StudentAccount(Owner owner, double balance, String school) {
        super(owner, balance);
        this.school = school;
    }

    public String getSchool() { return this.school; }
    public void setSchool(String school) { this.school = school; }
}