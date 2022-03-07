public class BankTest {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();

        acc1.displayTotal();
        acc1.deposit('c', 500);
        acc1.withdraw('c', 300);
        acc1.displayTotal();

        System.out.println(BankAccount.totalMoney);
        System.out.println(BankAccount.numOfAccounts);

    }
}
