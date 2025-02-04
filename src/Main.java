//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankManagement bm = new BankManagement("HDFC", "HBC1234");
        while (true) {
            System.out.println("1.Create Account.\n2.Deposit Amount.\n3.Withdraw Amount.\n4.CheckBalance.\n5.Account Statement.\n6.Daily Report\n7.Delete Account");
            System.out.println("Enter your choice:");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: {
                    boolean result = bm.createAccount();
                    if (result) {
                        System.out.println("Account Created Successfully!!!!");
                    }
                    break;

                }
                case 2: {
                    boolean result = bm.deposit();
                    if (result) {
                        System.out.println("Amount Deposited Successfully!!!");
                    }
                    break;
                }
                case 3: {
                    boolean result = bm.withdraw();
                    if (result) {
                        System.out.println("Amount withdraw Successfully!!!");
                    }
                    break;
                }
                case 4: {
                    if(bm.checkBalance() == -1)
                    {
                        System.out.println("Plz Enter correct account number");
                    }
                    break;
                }
                case 5: {
                    bm.accountStatement();
                    break;
                }
                case 6:{
                    bm.dailyReport();
                }
                case 7:{
                    if(bm.accountDelete())
                        System.out.println("Account deleted");
                    else
                        System.out.println("Enter correct account number");
                }
            }

        }
    }

}