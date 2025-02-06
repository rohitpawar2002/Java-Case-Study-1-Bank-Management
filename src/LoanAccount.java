
import java.time.LocalDate;

public class LoanAccount extends BankAccounts {
    //double balance;
    double interestRate;
    int tenureMonths;
    String loanType;
    double emiPayment;
    int transactionCount = 0;
    TransactionHistory[] transaction = new TransactionHistory[50];

    public LoanAccount(long accountNumber, String accHolderName, double balance, String accountType, LocalDate accCreationDate, double interestRate, int tenureMonths, String loanType, double emiPayment) {
        super(accountNumber, accHolderName, -balance, accountType, accCreationDate);
        this.interestRate = interestRate;
        this.tenureMonths = tenureMonths;
        this.loanType = loanType;
        this.emiPayment = emiPayment;
    }


    public LoanAccount(int i, String string, int j, String string2, int k, String string3, double d, int l) {
        // TODO Auto-generated constructor stub
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTenureMonths() {
        return tenureMonths;
    }

    public void setTenureMonths(int tenureMonths) {
        this.tenureMonths = tenureMonths;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getEmiPayment() {
        return emiPayment;
    }

    public void setEmiPayment(double emiPayment) {
        this.emiPayment = emiPayment;
    }

    public double calculateEMI() {
        double monthlyInterestRate = (interestRate / 100) / 12;
        return (Math.abs(balance * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenureMonths))
                / (Math.pow(1 + monthlyInterestRate, tenureMonths) - 1));
    }


    // Method to check if the loan is paid off
    public boolean isLoanPaidOff() {
        if (balance >= 0) {
            System.out.println("Loan fully repaid.");
            return true;
        } else {
            System.out.println("Loan not yet repaid. Remaining loan amount: " + balance);
            return false;
        }
    }

    public void checkLoanInterest() {
        double monthlyInterest = (Math.abs(balance) * (interestRate / 100)) / getTenureMonths(); // Monthly interest
        //balance += monthlyInterest; // Add interest to loan balance

        System.out.println("Interest of ₹" + monthlyInterest + " applied.");
    }

    public boolean isLoanOverdue() {
        LocalDate dueDate = accCreationDate.plusMonths(tenureMonths);
        if (LocalDate.now().isAfter(dueDate)) {
            System.out.println(" Loan is overdue. Current balance: ₹" + balance);
            return true;
        }
        return false;
    }

    public boolean payEMI() {
        LocalDate dueDate = accCreationDate.plusMonths(tenureMonths);
        boolean isOverDue = LocalDate.now().isAfter(dueDate);
        double lateFee = 0;
        if (isOverDue) {
            lateFee = Math.abs(balance) * 0.02;

            System.out.println(" Loan is overdue.");
            System.out.println("You have to pay Late fee:  "+ lateFee);
        }

        System.out.println("How much amount do you want to pay?");
        double amount = sc.nextDouble();

        double emiWithLateFee = calculateEMI() + lateFee;
        if (amount < emiWithLateFee) {
            System.out.println("Error: Minimum EMI payment required: ₹" + emiWithLateFee);
            return false;
        }
        balance += amount;
        System.out.println("Payment of ₹" + amount + " received. Remaining Loan Balance: ₹" + balance);

        if (balance >= 0) {
            System.out.println("Congratulations! Your loan is fully repaid.");
        }

        return true;
    }

    public boolean checkLateFee() {
        if (isLoanOverdue()) {
            double lateFee = balance * 0.02;
            balance -= lateFee;
            System.out.println("Late fee of ₹" + lateFee + " applied. New Loan Balance: ₹" + balance);
            return true;
        }
        return false;
    }

    public double withdraw() {
        if (isLoanPaidOff()) {
            System.out.println("Enter how much amount you want to withdraw:");
            double amount = sc.nextDouble();
            long rand_int1 = rand.nextLong(1000);
            LocalDate date = LocalDate.now();
            transaction[transactionCount++] = new TransactionHistory(rand_int1, "Withdraw", amount, date, getBalance() - amount);
            setBalance(getBalance() - amount);
            return amount;
        } else {
            return -2;
        }
    }

    public void displayTransactionsHistory() {
        for (int i = 0; i < transactionCount; i++) {
            System.out.println("[ Transaction ID - " + transaction[i].getTransactionId() + ", Type of Transaction - "+ transaction[i].getType()+", Amount - "+transaction[i].getAmount()+", Date - "+transaction[i].getDate()+", Balance - "+transaction[i].getBalance()+"]");
        }
    }

    public double deposit() {
        System.out.println("Enter how much you want to deposit");
        double Amount = sc.nextInt();
        long rand_int1 = rand.nextLong(1000);
        LocalDate date = LocalDate.now();
        transaction[transactionCount++] = new TransactionHistory(rand_int1, "Deposit", Amount, date, getBalance() + Amount);
        setBalance(getBalance()+Amount);
        return Amount;
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