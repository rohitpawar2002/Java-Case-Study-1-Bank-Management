//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    BankManagement bm = new BankManagement("HDFC","HBC1234");

        System.out.println(bm.deposit());

        System.out.println(bm.checkBalance());

    }
}