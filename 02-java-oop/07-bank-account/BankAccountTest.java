public class BankAccountTest {
    public static void main(String[] args) {
        System.out.println(BankAccount.numberOfAccounts);
        System.out.println(BankAccount.totalAmountStored);
        BankAccount b1= new BankAccount();

        b1.checkingDeposit(1000);
        b1.savingDeposit(1000);
        System.out.println(b1.getCheckingBalance());
        b1.savingDeposit(1000);
        System.out.println(b1.getSavingBalance());
        b1.checkingWithdrawal(998);
        System.out.println(b1.getCheckingBalance());
        b1.checkingWithdrawal(2);
        System.out.println(b1.getCheckingBalance());
        b1.savingWithdrawal(30);
        b1.displayBalances();

    }
}
