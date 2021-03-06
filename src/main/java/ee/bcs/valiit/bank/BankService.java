package ee.bcs.valiit.bank;

import ee.bcs.valiit.solution.exception.SampleApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private AccountRepository accountRepository;

    public void createAccount(String firstName, String lastName, String accountNr, Double balance) {
        bankAccountRepository.createAccount(firstName, lastName, accountNr, balance);
    }
    public String getBalance2(String accountNr) {
        return "Your balance is " + getBalance(accountNr);
    }
    private Double getBalance(String accountNr) {
        return bankAccountRepository.getBalance(accountNr);
        //return accountRepository.getOne(accountNr).getBalance();
    }

    public String deposit(String accountNr, Double amount) {
        Double balance = getBalance(accountNr);

        if (amount < 0) {
            throw new SampleApplicationException("Ülekanne ebaõnnestus, sest ülekantav summa polnud positiivne");
        }
        balance = balance + amount;
        bankAccountRepository.updateBalance(accountNr, balance);
        return "Your new account balance is " + balance;
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
        bankAccountRepository.updateBalance(accountNr, balance);
        return "Your new account balance is " + balance;
        //return "Uus kontojääk on " + balance;
    }

    public String transferMoney(String fromAccount, Double amount, String toAccount) {
        if (amount < 0) {
            throw new SampleApplicationException("Ülekannet ei saa teostada, kontol pole piisavalt raha");
        }
        withdrawMoney(fromAccount, amount);
        deposit(toAccount, amount);
        return "Your new account balance is " + getBalance(fromAccount);

    }
    public List<BankAccountDTO> getAllAccounts() {
        return bankAccountRepository.getAllAccounts();
    }

  /*  public Boolean isLocked(String accountNr) {
        return bankAccountRepository.isLocked(accountNr);
    }
    public String lockAccount2(String accountNr) {
        Boolean locked = isLocked(accountNr);
        if (locked){
            return "Kasutaja lukustamine ebaõnnestus, sest kasutaja on lukustatud";
        } else {
            bankAccountRepository.updateIsLocked(accountNr);
            return "Kasutaja lukustamine õnnestus";
        }
    }
    public String unLockAccount2(String accountNr){
        Boolean locked = isLocked(accountNr);
        if (locked) {
            account.setLocked(true);
            return "Kasutaja avamine õnnestus";
        } else {
            return "Kasutaja avamine ebaõnnestus, sest kasutaja on avatud";
        }
        bankAccountRepository.updateIsLocked(accountNr);
    }

   */
}



