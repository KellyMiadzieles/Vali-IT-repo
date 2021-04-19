package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
            return bankAccountRepository.deposit(accountNr, amount);
        } else {
            return "Ülekanne ebaõnnestus, kuna ülekantav amount polnud positiivne";
        }
    }
}

