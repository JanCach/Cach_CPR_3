import accounts.*;
import creditCards.CreditCard;
import people.Owner;
import transfers.AccountTransferService;
import transfers.TransferService;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    /*
     * Ukol na 17. 9.
     *
     * Vytvořit další typy účtů a rozšířit stávající:
     *
     * Studentský účet
     *  - povolit výběr 5 000 do záporu
     *
     * Spořící účet
     *  - když přidám peníze na účet, připíše se mi i 0,5% úrok
     *
     * Podnikatelský účet
     *  - každý výběr odečte transakční poplatek 1%
     *
     */

    public static void main(String[] args) {

        TransferService transferService = new TransferService();

        Owner owner = new Owner("Tomas", "Pesek");

        List<BankAccount> accounts = new ArrayList<>();

        BankAccount bankAccount = new CurrentAccount(owner, 1000);
        accounts.add(bankAccount);

        BankAccount studentAccount = new StudentAccount(owner, 100);
        accounts.add(studentAccount);

        for (BankAccount account : accounts) {
            if (account instanceof InterestPoint) {
                ((InterestPoint)account).calculateInterest();
            }
        }


        for (BankAccount account : accounts) {

            if (account instanceof StudentAccount) {
                StudentAccount overrideAccount = (StudentAccount) account;
                System.out.println("school: " + overrideAccount.getSchool());
            }
        }

        transferService.withdraw(bankAccount, 500);
        transferService.addToBalance(bankAccount,300);
        transferService.addToBalance(bankAccount,100);
        System.out.println("balance: " + bankAccount.getBalance());


        CreditCard creditCard = new CreditCard(owner, 500);
        transferService.addToBalance(creditCard,1000);
        transferService.withdraw(creditCard,100);


        // --- ukol ---
        BusinessAccount businessAccount = new BusinessAccount(owner, 100000);
        AccountTransferService accountTransferService = new AccountTransferService();

        // zustatek pred prevodem
        System.out.println("Business balance: " + businessAccount.getBalance());
        System.out.println("Student balance: " + studentAccount.getBalance());

        accountTransferService.transfer(businessAccount, studentAccount, 10000);

        // zustatek po prevodu
        System.out.println("New business balance: " + businessAccount.getBalance());
        System.out.println("New student balance: " + studentAccount.getBalance());



        // transferService.withdraw(bankAccount, 500);
        // transferService.withdraw(bankAccount,500);
        // transferService.withdraw(bankAccount,500);



        System.out.println("balance: " + bankAccount.getBalance());
    }
}