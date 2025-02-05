import java.time.LocalDate;

public class SavingAccount extends BankAccounts {

    static double minBalance = 10000;
    double interestRate;
    int transactionCount = 0;
    TransactionHistory[] transaction = new TransactionHistory[50];

    public SavingAccount(long accountNumber, String accHolderName, double balance, String accountType, LocalDate accCreationDate, double interestRate) {
        super(accountNumber, accHolderName, balance, accountType, accCreationDate);
        this.interestRate = interestRate;
    }

    public static double getMinBalance() {
        return minBalance;
    }

    public static void setMinBalance(double MinBalance) {
        minBalance = MinBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
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
        if((getBalance() - amount) > getMinBalance()){
            long rand_int1 = rand.nextLong(1000);
            LocalDate date = LocalDate.now();
            transaction[transactionCount++] = new TransactionHistory(rand_int1, "Withdraw", amount, date, getBalance() - amount);
            setBalance(getBalance() - amount);
            return amount;
        }
        return -3;
    }

    public void displayTransactionsHistory() {
        for (int i = 0; i < transactionCount; i++) {
            System.out.println("[ Transaction ID - " + transaction[i].getTransactionId() + ", Type of Transaction - "+ transaction[i].getType()+", Amount - "+transaction[i].getAmount()+", Date - "+transaction[i].getDate()+", Balance - "+transaction[i].getBalance()+"]");
        }
    }

    public void checkLoanInterest() {
        double monthlyInterest = (balance * (interestRate / 100)) / 12; // Monthly interest
        //balance += monthlyInterest; // Add interest to loan balance

        System.out.println("Interest of ₹" + monthlyInterest + " applied.");
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