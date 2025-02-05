import java.time.LocalDate;

import java.util.Random;
import java.util.Scanner;

public abstract  class  BankAccounts {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    long accountNumber;
    String accHolderName;
    double balance;
    String accountType;
    LocalDate accCreationDate;

    public BankAccounts() {
    }

    public BankAccounts(long accountNumber, String accHolderName, double balance, String accountType, LocalDate accCreationDate) {
        this.accountNumber = accountNumber;
        this.accHolderName = accHolderName;
        this.balance = balance;
        this.accountType = accountType;
        this.accCreationDate = accCreationDate;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAccCreationDate(LocalDate accCreationDate) {
        this.accCreationDate = accCreationDate;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public LocalDate getAccCreationDate() {
        return accCreationDate;
    }

    public double deposit()
    {
        System.out.println("Enter how much you want to deposit");
        double amount = sc.nextInt();
//        long TransactionID = rand.nextLong(1000);
        LocalDate date = LocalDate.now();
//        transaction[Tcount++] = new TransactionHistory(TransactionID,"Deposit",amount,date,getBalance()+amount);
        setBalance(getBalance()+amount);
        return amount;
    }
    public abstract double withdraw();

    @Override
    public String toString() {
        return "BankAccounts [ accountNumber=" + accountNumber + ", accHolderName="
                + accHolderName + ", balance=" + balance + ", accountType=" + accountType + ", accCreationDate="
                + accCreationDate + "]";
    }

    public abstract void displayTransactionsHistory();


    public void displayAccInfo() {
        System.out.println("Account Number - "+ getAccountNumber());
        System.out.println("Account Holder Name - "+ getAccHolderName());
        System.out.println("Balance - "+ getBalance());
        System.out.println("Account Type - "+ getAccountType());
        System.out.println("Account Creation Date - "+ getAccCreationDate());

    }

    public abstract int todaysTransactionCount();

    public abstract int todaysTransactionsCount();

}