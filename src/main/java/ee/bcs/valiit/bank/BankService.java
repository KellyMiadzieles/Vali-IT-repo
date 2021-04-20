package ee.bcs.valiit.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void createAccount(String firstName, String lastName, String accountNr, Double balance) {
        bankAccountRepository.createAccount(firstName, lastName, accountNr, balance);
    }

    public Double getBalance(String accountNr) {
        return bankAccountRepository.getBalance(accountNr);
    }

    public String deposit(String accountNr, Double amount) {
        Double balance = getBalance(accountNr);
        if (amount > 0) {
            balance = balance + amount;
            return bankAccountRepository.updateBalance(accountNr, balance);
        } else {
            return "Ülekanne ebaõnnestus, kuna ülekantav amount polnud positiivne";
        }
    }

    public String withdrawMoney(String accountNr, Double amount) {
        Double balance = getBalance(accountNr);
        balance = balance - amount;
        return bankAccountRepository.updateBalance(accountNr, balance);
        //return "Uus kontojääk on " + balance;
    }

    public void transferMoney(String fromAccount, Double amount, String toAccount) {
        withdrawMoney(fromAccount, amount);
        deposit(toAccount, amount);
    }
}



