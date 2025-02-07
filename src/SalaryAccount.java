import java.time.LocalDate;
import java.time.Period;

public class SalaryAccount extends BankAccounts {
    LocalDate lastTransactionDate;
    boolean isFreez;
    int transactionCount = 0;
    TransactionHistory[] transaction = new TransactionHistory[50];

    public SalaryAccount(long accountNumber, String accHolderName, double balance, String accountType,
                         LocalDate accCreationDate, LocalDate lastTransactionDate) {
        super(accountNumber, accHolderName, balance, accountType, accCreationDate);
        this.lastTransactionDate = lastTransactionDate;
    }

    @Override
    public String toString() {
        return "SalaryAccount [ lastTransactionDate=" + lastTransactionDate + ", toString()=" + super.toString() + "]";
    }

    public LocalDate getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(LocalDate lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

    public boolean isFreez() {
        return isFreez;
    }

    public void setFreez(boolean freez) {
        isFreez = freez;
    }

    public double deposit() {
        if (isFrozen()) {
            System.out.println("Your Account is Frozen.");
            return -1;
        } else {
            System.out.println("Enter how much you want to deposit");
            double amount = sc.nextInt();
            long rand_int1 = rand.nextLong(1000);
            LocalDate date = LocalDate.now();
            transaction[transactionCount++] = new TransactionHistory(rand_int1, "Deposit", amount, date, getBalance() + amount);
            setBalance(getBalance() + amount);
            setLastTransactionDate(date);
            return amount;
        }

    }

    public double withdraw() {
        if (isFrozen()) {
            return -1;
        } else {
            System.out.println("Enter how much amount you want to withdraw:");
            double amount = sc.nextDouble();
            long rand_int1 = rand.nextLong(1000);
            LocalDate date = LocalDate.now();
            transaction[transactionCount++] = new TransactionHistory(rand_int1, "Withdraw", amount, date, getBalance() - amount);
            setBalance(getBalance() - amount);
            setLastTransactionDate(date);
            return amount;
        }

    }

    public boolean isFrozen() {
//    	setLastTransactionDate(getAccCreationDate());
        LocalDate lastTransaction = getLastTransactionDate();
        Period period = Period.between(lastTransaction, LocalDate.now());
        int monthCount = period.getYears() * 12 + period.getMonths();
        if (monthCount >= 2) {
            return true;
        }
        return false;

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