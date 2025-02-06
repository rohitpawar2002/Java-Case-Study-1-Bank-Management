import java.time.LocalDate;
import java.util.Scanner;

public class CurrentAccount extends BankAccounts {
    Scanner sc = new Scanner(System.in);
    static double overDraftLimit = 10000;
    double overDraftCharges;
    int duration;
    LocalDate overdraftDate;
    int transactionCount = 0;
    TransactionHistory[] transaction = new TransactionHistory[50];

    public CurrentAccount(long accountNumber, String accHolderName, double balance, String accountType, LocalDate accCreationDate, int duration) {
        super(accountNumber, accHolderName, balance, accountType, accCreationDate);
        this.duration = duration;
    }

    public static double getOverDraftLimit() {
        return overDraftLimit;
    }

    public static void setOverDraftLimit(double OverDraftLimit) {
        overDraftLimit = OverDraftLimit;
    }

    public double getOverDraftCharges() {
        return overDraftCharges;
    }

    public void setOverDraftCharges(double overDraftCharges) {
        this.overDraftCharges = overDraftCharges;
    }

    public LocalDate getOverdraftDate() {
        return overdraftDate;
    }

    public void setOverdraftDate(LocalDate overdraftDate) {
        this.overdraftDate = overdraftDate;
    }

    public double deposit() {

        System.out.println("Enter how much you want to deposit");
        double amount = sc.nextInt();
        long rand_int1 = rand.nextLong(1000);
        LocalDate date = LocalDate.now();
        transaction[transactionCount++] = new TransactionHistory(rand_int1, "Deposit", amount, date, getBalance() + amount);
        setBalance(getBalance() + amount);
        return amount;
    }

    public double withdraw() {
        System.out.println("Enter amount you want to withdraw");
        double amount = sc.nextInt();

        if (getBalance() > amount) {
            setBalance(getBalance() - amount);
            return amount;
        } else {
            setOverdraftDate(LocalDate.now());
            if (Math.abs(getBalance() - amount) > getOverDraftLimit()) {
                System.out.println("You cannot withdraw money beyond overdraft limit");
                return -4;
            } else {
                setBalance(getBalance() - amount);
                return amount;
            }
        }
    }

    public void displayTransactionsHistory() {

    }

    public int todaysTransactionCount() {
        return 0;
    }

    public int todaysTransactionsCount() {
        return 0;
    }
}