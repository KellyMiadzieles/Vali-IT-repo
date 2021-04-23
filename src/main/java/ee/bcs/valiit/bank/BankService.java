package ee.bcs.valiit.bank;

import ee.bcs.valiit.solution.exception.SampleApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountRepository accountRepository;

    public void createAccount(String firstName, String lastName, String accountNr, Double balance) {
        bankAccountRepository.createAccount(firstName, lastName, accountNr, balance);
    }

    public Double getBalance(String accountNr) {

        //return bankAccountRepository.getBalance(accountNr);
        return accountRepository.getOne(accountNr).getBalance();
    }

    public String deposit(String accountNr, Double amount) {
        Double balance = getBalance(accountNr);

        if (amount < 0) {
            throw new SampleApplicationException("Ülekanne ebaõnnestus, sest ülekantav summa polnud positiivne");
        }
        balance = balance + amount;
        return bankAccountRepository.updateBalance(accountNr, balance);
    }

    public String withdrawMoney(String accountNr, Double amount) {
        Double balance = getBalance(accountNr);
        if (amount < 0) {
            throw new SampleApplicationException("Kontol pole piisavalt raha");
        }
        if (balance < amount) {
            throw new SampleApplicationException("Kontol pole piisavalt raha");
        }
            balance = balance - amount;
        return bankAccountRepository.updateBalance(accountNr, balance);
        //return "Uus kontojääk on " + balance;
    }

    public void transferMoney(String fromAccount, Double amount, String toAccount) {
        if (amount < 0) {
            throw new SampleApplicationException("Ülekannet ei saa teostada, kontol pole piisavalt raha");
        }
        withdrawMoney(fromAccount, amount);
        deposit(toAccount, amount);
    }
}



