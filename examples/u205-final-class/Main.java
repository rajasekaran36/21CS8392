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
public class Main {
    public static void main(String[] args) {
        
    }
}
