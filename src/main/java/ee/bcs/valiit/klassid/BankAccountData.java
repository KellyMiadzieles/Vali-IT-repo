package ee.bcs.valiit.klassid;

public class BankAccountData {
    public String accountNumber;
    public String ownerName;
    public Double balance;
    public Boolean isBlocked;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getLocked() {
        return isBlocked;
    }

    public void setLocked(Boolean locked) {
        this.isBlocked = locked;
    }

}
