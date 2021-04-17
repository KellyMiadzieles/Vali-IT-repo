package ee.bcs.valiit.tasks;

import ee.bcs.valiit.klassid.BankAccountData;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class Lesson5 {
    private static HashMap<String, BankAccountData> accountBalanceMap = new HashMap<>();

    public static void main(String[] args) {

    }
/*
    // http://localhost:8080/createAccount/Kelly/EE123/100
    @GetMapping("createAccount/{ownerName}/{accountNr/{balance}")
    public void createAccount(@RequestParam("ownerName") String ownerName,
                              @PathVariable("accountNr") String accountNr,
                              @PathVariable("balance") Double balance) {
        BankAccountData account = new BankAccountData();
        account.setOwnerName(ownerName);
        account.setAccountNumber(accountNr);
        account.setBalance(balance);
        accountBalanceMap.put(accountNr, balance);
    }

    // http://localhost:8080/createAccount/EE456/100
    @PostMapping("createAccount/{accountNr}/{balance}")
    public void createAccount(@PathVariable("accountNr") String accountNr,
                              @PathVariable("balance") Double balance) {
        accountBalanceMap.put(accountNr, balance);
    }

    // http://localhost:8080/bank/account
    /*@PostMapping("bank/account")
    public void createAccount2(@RequestBody CreateAccount request) {
        accountBalanceMap.put(request.getAccountNumber(), request.getAmount());
    }



    // http://localhost:8080/balance/EE456
    @GetMapping("balance/{accountNumber}")
    public String getBalance(@PathVariable("accountNumber") String accountNr) {
        return "Your balance is: " + accountBalanceMap.get(accountNr);
    }

    // http://localhost:8080/deposit/EE456/500
    @PutMapping("deposit/{depositMoney}/{amount}")
    public String deposit(@PathVariable("depositMoney") String accountNr,
                          @PathVariable("amount") double amount) {
        double depositAmount = 0;
        if (amount > 0) {
            depositAmount = accountBalanceMap.get(accountNr) + amount;
            accountBalanceMap.put(accountNr, depositAmount);
        }
        return "Your balance of" + accountNr + " is " + depositAmount;
    }

    //http://localhost:8080/withdrawMoney/EE456/40
    @PutMapping("withdrawMoney/{accountNr}/{amount}")
    public String withdrawMoney(@PathVariable("accountNr") String accountNr,
                                @PathVariable("amount") double amount) {
        if (amount > 0) {
            double balance = accountBalanceMap.get(accountNr);
            if (amount < 0) {
                return "Not enough money";
            } else {
                balance -= amount;
                accountBalanceMap.put(accountNr, balance);
                return amount + "withdraw from account " + accountNr + ". New balance is " + balance;
            }

        } else {
            return "Invalid amount";
        }
    }

    //http://localhosT:8080/transferMoney/EE456/10/EE123
    @PutMapping("transferMoney/{fromAccount}/{amount}/{toAccount}")
    public String transferMoney(@PathVariable("fromAccount") String fromAccount,
                                @PathVariable("amount") double amount,
                                @PathVariable("toAccount") String toAccount) {
        if (amount > 0 && amount <= accountBalanceMap.get(fromAccount)) {
            double newFromBalance = accountBalanceMap.get(fromAccount) - amount;
            double newToBalance = accountBalanceMap.get(toAccount) + amount;
            accountBalanceMap.put(fromAccount, newFromBalance);
            accountBalanceMap.put(toAccount, newToBalance);
        }
        return "You have transferred from " + fromAccount + " to " + toAccount + amount + " EUR.";
    }

 */

    // TODO täienda oma BankControllerit nii, et sa hoiad Map-is konto balanssi asemel konto objekti
    //  1)
    // Selleks loo uus konto objekt, mis sisaldab minimaalselt
    // * kontoNr
    // * kontoOmanikuNimi
    // * balanss
    // * kas konto on lukustatud
    // 2)
    // täienda konto loomis teenust nii, et sa salvestad ka konto omaniku nime
    // 3)
    // loo 2 uut teenust: lockAccount ja unlockAccount
    // 4)
    // juhul kui konto on lukustatud ei tohi saada sellele kontole raha juurde kande ega kontolt raha ära võtta
    // ehk siis withdrawMoney, depositMoney ja transferMoney teenused ei tohi töötada
}
