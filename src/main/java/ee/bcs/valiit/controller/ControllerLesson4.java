package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class ControllerLesson4 {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public static void main(String[] args) {
    }

    // http://localhost:8080/createAccount/tiit/mari/EE019/100
    @PostMapping("createAccount/{firstName}/{lastName}/{accountNr}/{balance}")
    public void createAccount(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName, @PathVariable("accountNr") String accountNr,
                              @PathVariable("balance") Double balance) {
        String sql = "INSERT INTO account (id, first_name, last_name, account_number, balance) VALUES (:dbId,:dbFirstName,:dbLastName, :dbAccountNr, :dbAmount)";
        Map<String, Object> paramMap = new HashMap<>();
        Integer id = ThreadLocalRandom.current().nextInt(1, 1000 + 1); //annab ise automaatselt id numbri
        paramMap.put("dbId", id); //salvestab mapi id numbri
        paramMap.put("dbFirstName", firstName);
        paramMap.put("dbLastName", lastName);
        paramMap.put("dbAccountNr", accountNr);
        paramMap.put("dbAmount", balance);
        //paramMap.put(dbIsBlocked", blocked);
        jdbcTemplate.update(sql, paramMap);

    }


    // http://localhost:8080/bank/account
    /*@PostMapping("bank/account")
    public void createAccount2(@RequestBody CreateAccount request) {
        accountBalanceMap.put(request.getAccountNumber(), request.getAmount());
    }

     */

    // http://localhost:8080/balance/EE019
    @GetMapping("balance/{accountNumber}")
    public Double getBalance(@PathVariable("accountNumber") String accountNr) {
        String sql = "SELECT balance FROM account where account_number = :dbAccountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccountNr", accountNr);
        Double balance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
        return balance;
    }
    /*
    //http://localhost:8080/lockAccount2/EE456
    @PutMapping("lockAccount2/{accountNr}")
    public String lockAccount2(@PathVariable("accountNr") String accountNr) {
        String sql = "UPDATE account SET isBlocked = 'true' WHERE account_number = :dbAccountNr";
        Map <String, Object> paraMap = new HashMap<>();
        paraMap.put("dbAccountNr", accountNr);
        jdbcTemplate.update(sql, paraMap);
        return accountNr + "is Blocked";
    }

@PutMapping("unlockAccount2/{accountNr}")
    public String unlockAccount2(@PathVariable("accountNr") String accountNr) {
        String sql = "UPDATE account SET isBlocked = 'false' WHERE account_number = :dbAccountNr";
        Map <String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccountNr", accountNr);
        jdbcTemplate.update(sql, paramMap);
        return accountNr + "is unlocked";
    }

 */


    // http://localhost:8080/deposit/EE019/500
    @PutMapping("deposit/{accountNr}/{amount}")
    public String deposit(@PathVariable("accountNr") String accountNr,
                          @PathVariable("amount") Double amount) {
        Double balance = getBalance(accountNr);
        if (amount > 0) {
            balance = balance + amount;
            String sql = "UPDATE account SET balance = :dbBalance WHERE account_number = :dbAccountNr";
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("dbAccountNr", accountNr);
            paramMap.put("dbBalance", balance);
            jdbcTemplate.update(sql, paramMap);
            return "Uus kontojääk on " + balance;
        } else {
            return "Ülekanne ebaõnnestus, kuna ülekantav amount polnud positiivne";
        }
    }

    //http://localhost:8080/withdrawMoney/EE019/40
    @PutMapping("withdrawMoney/{accountNr}/{amount}")
    public String withdrawMoney(@PathVariable("accountNr") String accountNr,
                                @PathVariable("amount") Double amount) {
        Double balance = getBalance(accountNr);
        balance = balance - amount;
        String sql = "Update account set balance = :dbBalance WHERE account_number = :dbAccountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccountNr", accountNr);
        paramMap.put("dbBalance", balance);
        jdbcTemplate.update(sql, paramMap);
        return "Uus kontojääk on " + balance;
    }

    //http://localhosT:8080/transferMoney/EE019/10/EE123
    @PutMapping("transferMoney/{fromAccount}/{amount}/{toAccount}")
    public String transferMoney(@PathVariable("fromAccount") String fromAccount,
                                @PathVariable("amount") Double amount,
                                @PathVariable("toAccount") String toAccount) {
        withdrawMoney(fromAccount, amount);
        deposit(toAccount, amount);
        return "You have transferred from " + fromAccount + " to " + toAccount + amount + " EUR.";
    }
}
/*
    kui teha RequestBody, kus on vaja teha iga muutuja jaoks eraldi objekt
    static  muutuja või funktsioon kuulub klassile (kui meil palju objekte, mis jagavad ühte klassi, kui ütlen muutuale et static, siis kõik objektid jagavad staticut) mitte objektile
 */
