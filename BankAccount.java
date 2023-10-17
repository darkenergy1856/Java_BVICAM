/*
* Simulate a simple banking application. Provide for classes BankAccount.
* Account will be of two type - Savings and Current.
* There should be methods to open an account, close an account and perform withdraw, deposit and transfer operations on an account as abstract methods in Account and properly overridden with definition in Account Types.
* Test classes should instantiate Account Type Classes and provide a menu-driven option for operations.
 */


import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.System.exit;

public class BankAccount extends Account {

    static int accountCount = 0;

    @Override
    void openAccount(String accountType , int initialDeposit , int accountNumber) {
        this.accountBalance = initialDeposit;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
    }

    @Override
    void closeAccount() {
        this.accountNumber = 0;
        this.accountBalance = 0;
        this.accountType = null;
    }

    @Override
    void withdraw(int withdrawAmount) {
        if (accountBalance >= withdrawAmount)
            accountBalance -= withdrawAmount;
    }

    @Override
    void deposit(int depositAmount) {
        accountBalance += depositAmount;
    }

    @Override
    void transfer(BankAccount account, int transferAmount) {
        this.withdraw(transferAmount);
        account.deposit(transferAmount);

    }
    BankAccount(String accountType , int initialDeposit){
        accountCount++;
        if (accountType.equals("Saving Account") || accountType.equals("Current Account"))
            openAccount(accountType , initialDeposit ,accountCount);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LinkedList<Account> accounts = new LinkedList<>();

        while(true){
            System.out.println("Choose Operation To Perform : ");
            System.out.println("1. Open Account");
            System.out.println("2. Close Account");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Deposit");


            switch (input.nextInt()){
                case 1:
                    System.out.println("Which Type of Bank do you Want to Open : ");
                    System.out.println("1. Saving Account");
                    System.out.println("2. Current Account");
                    int inputOption = input.nextInt();
                    System.out.println("Initial Deposit");
                    int initialAmount = input.nextInt();
                    if (inputOption == 1) {
                        accounts.add(new BankAccount("Saving Account", initialAmount));
                        System.out.println("Account Created with Account Number : " + BankAccount.accountCount);
                    }
                    else if (inputOption == 2) {
                        accounts.add(new BankAccount("Current Account", initialAmount));
                        System.out.println("Account Created with Account Number : " + BankAccount.accountCount);
                    }
                    else
                        exit(1);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Option Selected");
                    exit(1);
            }


        }
    }
}

abstract class Account {
    int accountNumber;
    int accountBalance;
    String accountType;
    abstract void openAccount(String accountType , int initialDeposit , int accountNumber);
    abstract void closeAccount();

    abstract void withdraw(int withdrawAmount);

    abstract void deposit(int depositAmount);

    abstract void transfer(BankAccount account , int transferAmount);

}
