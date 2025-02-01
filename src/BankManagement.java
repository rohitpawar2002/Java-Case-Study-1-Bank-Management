import java.time.LocalDate;
import java.util.Scanner;

public class BankManagement {
    Scanner sc = new Scanner(System.in);
    String bankName;
    String IFSCCode;
    int accountCount = 5;

    BankAccounts[] account;

    public BankManagement(String bankName, String IFSCCode) {
        this.bankName = bankName;
        this.IFSCCode = IFSCCode;

        account = new BankAccounts[20];

        account[0] = new BankAccounts(1234566,"Rohit Pawar",100,"Saving", LocalDate.now());
        account[1] = new BankAccounts(1234526,"Rohit Pawar",100,"Saving", LocalDate.now());
        account[2] = new BankAccounts(1234546,"Rohit Pawar",100,"Saving", LocalDate.now());
        account[3] = new BankAccounts(1237566,"Rohit Pawar",100,"Saving", LocalDate.now());
        account[4] = new BankAccounts(12834566,"Rohit Pawar",100,"Saving", LocalDate.now());
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public boolean deposit()
    {
        System.out.println("Enter account number");
        long accNo = sc.nextLong();

        for (int i=0;i < accountCount; i++)
        {
            if(account[i].accountNumber == accNo)
            {
                boolean res = account[i].deposit();
                if(res)
                    return true;
                break;
            }
        }
        return false;
    }

    public boolean checkBalance()
    {
        System.out.println("Enter account number");
        long accNo = sc.nextLong();

        for (int i=0;i < accountCount; i++)
        {
            if(account[i].accountNumber == accNo)
            {
                //System.out.println(account[i]);
                System.out.println(account[i].getBalance());
                return true;
            }
        }
        return false;
    }
}
