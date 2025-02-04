
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
        return (balance * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenureMonths))
                / (Math.pow(1 + monthlyInterestRate, tenureMonths) - 1);
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

    public double applyLoanInterest() {
        double monthlyInterest = (balance * (interestRate / 100)) / 12; // Monthly interest
        balance += monthlyInterest; // Add interest to loan balance

        System.out.println("Interest of ₹" + monthlyInterest + " applied. New Loan Balance: ₹" + balance);
        return monthlyInterest;
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
        System.out.println("How much amount you want to pay");
        double amount = sc.nextDouble();
        if (amount < calculateEMI()) {
            System.out.println("Error: Minimum EMI payment required: ₹" + calculateEMI());
            return false;
        }

        balance -= amount;
        System.out.println("Payment of ₹" + amount + " received. Remaining Loan Balance: ₹" + balance);

        if (balance <= 0) {
            System.out.println("Congratulations! Your loan is fully repaid.");

        }
        return true;

    }

    public boolean applyLateFee() {
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

}