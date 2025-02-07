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
        long rand_int1 = rand.nextLong(1000);

        if (getBalance() > amount) {
            setBalance(getBalance() - amount);
            transaction[transactionCount++] = new TransactionHistory(rand_int1, "Withdraw", amount, LocalDate.now(), getBalance());
            return amount;
        } else {
            setOverdraftDate(LocalDate.now());
            if (Math.abs(getBalance() - amount) > getOverDraftLimit()) {
                System.out.println("You cannot withdraw money beyond overdraft limit");
                return -4;
            } else {
                setBalance(getBalance() - amount);
                transaction[transactionCount++] = new TransactionHistory(rand_int1, "Withdraw", amount, LocalDate.now(), getBalance());
                return amount;
            }
        }
    }

    public void displayTransactionsHistory() {
        for (int i = 0; i < transactionCount; i++) {
            System.out.println("[ Transaction ID - " + transaction[i].getTransactionId() + ", Type of Transaction - "+ transaction[i].getType()+", Amount - "+transaction[i].getAmount()+", Date - "+transaction[i].getDate()+", Balance - "+transaction[i].getBalance()+"]");
        }
    }

    public int todaysTransactionCount() {
        int count = 0;
        if (transactionCount != 0) {
            System.out.println("Account Holder Name: " + getAccHolderName() + " Account Number: " + getAccountNumber());
            for (int i = 0; i < transactionCount; i++) {
                if (transaction[i].date.isEqual(LocalDate.now())) {
                    //transaction[i].displayTransactions();
                    System.out.println("[ Transaction ID - " + transaction[i].getTransactionId() + ", Type of Transaction - "+ transaction[i].getType()+", Amount - "+transaction[i].getAmount()+", Date - "+transaction[i].getDate()+", Balance - "+transaction[i].getBalance()+"]");
                    count++;
                }
            }
        }
        return count;
    }

    public int todaysTransactionsCount() {
        int count = 0;
        if (transactionCount != 0) {
            //System.out.println("Account Holder Name: " + getAccHolderName() + " Account Number: " + getAccountNumber());
            for (int i = 0; i < transactionCount; i++) {
                if (transaction[i].date.isEqual(LocalDate.now())) {
                    //transaction[i].displayTransactions();
                    //System.out.println("[ Transaction ID - " + transaction[i].getTransactionId() + ", Type of Transaction - "+ transaction[i].getType()+", Amount - "+transaction[i].getAmount()+", Date - "+transaction[i].getDate()+", Balance - "+transaction[i].getBalance()+"]");
                    count++;
                }
            }
        }
        return count;
    }
}