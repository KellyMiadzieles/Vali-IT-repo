package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void createAccount(String accountNr, Double balance)
}
