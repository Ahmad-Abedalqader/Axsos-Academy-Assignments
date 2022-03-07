public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    static int numOfAccounts = 0;
    static double totalMoney = 0.0;

    // Constructor:
    public BankAccount(){
        numOfAccounts++;
    }

    //getters:
    public double getCheckingBalance(){
        return checkingBalance;
    }
    public double getSavingsBalance(){
        return savingsBalance;
    }

    public void deposit(Character a, double amount){
        if (a.equals('c')){
            checkingBalance += amount;
        }
        else if (a.equals('s')){
            savingsBalance += amount;
        }
        totalMoney += amount;
    }

    public void withdraw(Character a, double amount){
        if (a.equals('c')){
            if (amount > checkingBalance){
                System.out.println("insufficient funds");
            }
            else{
                checkingBalance -= amount;
            }
        }
        else if (a.equals('s')){
            if (amount > savingsBalance){
                System.out.println("insufficient funds");
            }
            else{
                savingsBalance -= amount;
            }
        }
    }

    public void displayTotal(){
        System.out.println("Checking Balance - $" + checkingBalance);
        System.out.println("Savings Balance - $" + savingsBalance);
        System.out.println("Total of both balances - $" + (checkingBalance + savingsBalance));
    }
}
