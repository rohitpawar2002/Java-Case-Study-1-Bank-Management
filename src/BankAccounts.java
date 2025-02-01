import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class BankAccounts {
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

    public boolean deposit()
    {
        System.out.println("Enter how much you want to deposit");
        double amount = sc.nextInt();
        long rand_int1 = rand.nextLong(1000);
        LocalDate date = LocalDate.now();
        TransactionHistory t1 = new TransactionHistory(rand_int1,"Deposit",amount,date,getBalance()+amount);
        setBalance(getBalance()+amount);
        return true;
    }


}
