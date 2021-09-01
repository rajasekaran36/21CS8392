class Account {
    private int accountNumber;
    private String accountHolderName;
    private String aadharNumber;
    private int balance;

    public Account(int accountNumber, String accountHolderName, String aadharNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.aadharNumber = aadharNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    @Override
    public String toString() {
        return "{" + " accountNumber='" + accountNumber + "'" + ", accountHolderName='" + accountHolderName + "'"
                + ", aadharNumber='" + aadharNumber + "'" + ", balance='" + balance + "'" + "}";
    }
}

class Bank {
    public static int nextAccountNumber = 303601200;
    public static int nextIndex = 0;
    Account[] accounts;

    public Bank() {
        accounts = new Account[10];
    }

    public void createAccount(String accountHolderName, String aadharNumber) {
        accounts[nextIndex] = new Account(nextAccountNumber, accountHolderName, aadharNumber);
        nextAccountNumber++;
        nextIndex++;
    }

    public Account getAccount(int accountNumber) {
        for (Account account : accounts) {
            if (accountNumber == account.getAccountNumber()) {
                return account;
            }
        }
        return null;
    }

    public void displayAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

}

class XYZBank extends Bank {
    public Account getAccount(int accountNumber) {
        return accounts[0];
    }
}

public class Main {
    public static void main(String[] args) {
        XYZBank bank = new XYZBank();
        bank.createAccount("Rajasekaran S", "123412341234");
        bank.createAccount("Sathish R", "987698769876");
        bank.displayAccounts();
    }
}
