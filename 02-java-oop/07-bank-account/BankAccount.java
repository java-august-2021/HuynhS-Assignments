import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingBalance;
    protected static int numberOfAccounts = 0;
    protected static int totalAmountStored = 0;

    public BankAccount(){
        numberOfAccounts++;

    }


    public double checkingDeposit(double amount){
        this.checkingBalance += amount;
        return BankAccount.totalAmountStored += amount;
    }
    public double savingDeposit(double amount){
        this.savingBalance += amount;
        return BankAccount.totalAmountStored += amount;
    }

    public double checkingWithdrawal(double amount){
        if(this.checkingBalance < amount){
            System.out.printf("Insufficient funds. Try again");
        }
        this.checkingBalance -= amount;
        return BankAccount.totalAmountStored -= amount;
    }
    public double savingWithdrawal(double amount){
        if(this.savingBalance < amount){
            System.out.printf("Insufficient funds. Try again");
        }
        this.savingBalance -= amount;
        return BankAccount.totalAmountStored -= amount;
    }

    public void displayBalances(){
        System.out.printf("Checking Balance: %2f", this.checkingBalance);
        System.out.printf("Saving Balance: %2f", this.savingBalance);
    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    public double getSavingBalance(){
        return this.savingBalance;
    }
}
