package ee.bcs.valiit.tasks;

import ee.bcs.valiit.klassid.BankAccountData;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson5 {
    private static HashMap<String, BankAccountData> accountNumberBankAccountDataMap = new HashMap<>();

    public static void main(String[] args) {

    }

    // http://localhost:8080/createAccount2/Mari/EE456/100/true
    @PostMapping("createAccount2/{ownerName}/{accountNr}/{balance}/{locked}")
    public String createAccount(@PathVariable("ownerName") String ownerName,
                                @PathVariable("accountNr") String accountNr,
                                @PathVariable("balance") Double balance,
                                @PathVariable("locked") Boolean locked) {
        BankAccountData account = new BankAccountData();
        account.setOwnerName(ownerName);
        account.setAccountNumber(accountNr);
        account.setBalance(balance);
        account.setLocked(locked);
        accountNumberBankAccountDataMap.put(accountNr, account);
        return "Mapis on " + accountNumberBankAccountDataMap.size();
    }


    // http://localhost:8080/balance2/EE456
    @GetMapping("balance2/{accountNumber}")
    public Double getBalance(@PathVariable("accountNumber") String accountNr) {
        return accountNumberBankAccountDataMap.get(accountNr).getBalance();
    }

    // http://localhost:8080/deposit2/EE456/500
    @PutMapping("deposit2/{depositMoney}/{amount}")
    public String deposit(@PathVariable("depositMoney") String accountNr,
                          @PathVariable("amount") double amount) {
        BankAccountData account = accountNumberBankAccountDataMap.get(accountNr);
        if (account.isBlocked) {
            return "Raha lisamine ebaõnnestus, sest konto on kinni";
        }
        Double balance = account.getBalance();
        if (amount > 0) {
            balance = balance + amount;
            account.setBalance(balance);
            return "Uus kontojääk on " + account.getBalance();
        } else {
            return "Raha lisamine kontoleebaõnnestus, kuna ülekantav amount polnud positiivne";
        }
    }
    //http://localhost:8080/lockAccount/EE456
    @PutMapping("lockAccount/{accountNr}")
    public String lockAccount(@PathVariable("accountNr") String accountNr) {
        BankAccountData account = accountNumberBankAccountDataMap.get(accountNr);
        if (account.isBlocked) {
            return "Kasutaja lukustamine ebaõnnestus, sest kasutaja on lukustatud";
        } else {
            account.setLocked(true);
            return "Kasutaja lukustamine õnnestus";
        }
    }
    //http://localhost:8080/unlockAccount/EE456
    @PutMapping("unlockAccount/{accountNr}")
    public String unlockAccount(@PathVariable("accountNr") String accountNr) {
        BankAccountData account = accountNumberBankAccountDataMap.get(accountNr);
        if (account.isBlocked) {
            account.setLocked(true);
            return "Kasutaja avamine õnnestus";
        } else {
            return "Kasutaja avamine ebaõnnestus, sest kasutaja on avatud";
        }
    }

    //http://localhost:8080/withdrawMoney2/EE456/40
    @PutMapping("withdrawMoney2/{accountNr}/{amount}")
    public String withdrawMoney(@PathVariable("accountNr") String accountNr,
                                @PathVariable("amount") double amount) {
        BankAccountData account = accountNumberBankAccountDataMap.get(accountNr); // kontot küsin konto numbri järgi
        if (account.isBlocked) {
            return "Raha eemaldamine ebaõnnestus, sest konto on lukus";
        }
        Double balance = account.getBalance();
        if (amount > 0) {
            balance = balance - amount;
            account.setBalance(balance);
            return "Uus kontojääk on " + account.getBalance();
        } else {
            return "Raha eemaldamine ebaõnnestus, kuna amount on negatiivne";
        }
    }

    //http://localhosT:8080/transferMoney2/EE456/10/EE123
    @PutMapping("transferMoney2/{fromAccount}/{amount}/{toAccount}")
    public String transferMoney(@PathVariable("fromAccount") String fromAccount,
                                @PathVariable("amount") double amount,
                                @PathVariable("toAccount") String toAccount) {
        BankAccountData accountFrom = accountNumberBankAccountDataMap.get(fromAccount);
        BankAccountData accountTo = accountNumberBankAccountDataMap.get(toAccount);
        if (accountFrom.isBlocked || accountTo.isBlocked) {
            return "Tehing ebaõnnestus, sest üks või mõlemad kontod on lukus";
        }
        withdrawMoney(fromAccount, amount);
        deposit(toAccount, amount);
        return "You have transferred from " + fromAccount + " to " + toAccount + amount + " EUR.";
    }

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
