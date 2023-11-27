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
        LinkedList<BankAccount> accounts = new LinkedList<>();

        while(true){
            System.out.println("Choose Operation To Perform : ");
            System.out.println("1. Open Account");
            System.out.println("2. Close Account");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Deposit");
            System.out.println("6. Exit Application");


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
                    System.out.println("Enter Account Number : ");
                    try{
                    accounts.remove(input.nextInt()-1);}catch (Exception e){
                        System.out.println("Account dose not  exist.");
                    }
                    break;
                case 3:
                    System.out.println("Enter Account Number : ");
                    int accountNumber = input.nextInt();
                    System.out.println("Enter Withdraw Amount : ");
                    int withdrawAmount = input.nextInt();
                    accounts.get(accountNumber-1).withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Enter Your Account Number : ");
                    int firstAccountNumber = input.nextInt();
                    System.out.println("Enter Account to Transfer Money : ");
                    int secondAccountNumber = input.nextInt();
                    System.out.println("Enter Withdraw Amount : ");
                    int transferAmount = input.nextInt();
                    accounts.get(firstAccountNumber-1).transfer(accounts.get(secondAccountNumber-1) , transferAmount);
                    break;
                case 5:
                    System.out.println("Enter your Account Number : ");
                    int depositAccount = input.nextInt();
                    System.out.println("Enter Deposit Amount : ");
                    int depositAmount = input.nextInt();
                    accounts.get(depositAccount-1).deposit(depositAmount);
                    break;
                case 6:
                    exit(0);
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
