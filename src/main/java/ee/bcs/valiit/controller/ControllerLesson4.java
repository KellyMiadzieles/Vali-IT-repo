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
    @PostMapping ("createAccount/{firstName}/{lastName}/{accountNr}/{balance}")
        public void createAccount(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName, @PathVariable("accountNr") String accountNr,
                @PathVariable("balance") Double balance) {
    String sql = "INSERT INTO account (id, first_name, last_name, account_number, balance) VALUES (:dbId,:dbFirstName,:dbLastName, :dbAccountNr, :dbAmount)";
    Map<String, Object> paraMap = new HashMap<>();
    Integer id = ThreadLocalRandom.current().nextInt(1, 1000 + 1);
    paraMap.put("dbId", id);
    paraMap.put("dbFirstName", firstName);
    paraMap.put("dbLastName", lastName);
    paraMap.put("dbAccountNr", accountNr);
    paraMap.put("dbAmount", balance);
    jdbcTemplate.update(sql, paraMap);

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
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("dbAccountNr", accountNr);
        Double balance = jdbcTemplate.queryForObject(sql, paraMap, Double.class);
        return balance;
    }

    // http://localhost:8080/deposit/EE019/500
    @PutMapping("deposit/{accountNr}/{amount}")
    public String deposit(@PathVariable("accountNr") String accountNr,
                         @PathVariable("amount") double amount) {
       Double balance = getBalance(accountNr);
       if (amount > 0){
           balance = balance + amount;
           String sql = "UPDATE account SET balance = :dbBalance WHERE account_number = :dbAccountNr";
           Map<String, Object> paraMap = new HashMap<>();
           paraMap.put("dbAccountNr", accountNr);
           paraMap.put("dbBalance", balance);
           jdbcTemplate.update(sql, paraMap);
           return "Uus kontojääk on " + balance;
       } else {
           return "Ülekanne ebaõnnestus, kuna ülekantav amount polnud positiivne";
       }
  }

    //http://localhost:8080/withdrawMoney/EE019/40
    @PutMapping("withdrawMoney/{accountNr}/{amount}")
    public String withdrawMoney(@PathVariable("accountNr") String accountNr,
                                @PathVariable("amount") double amount) {
        Double balance = getBalance(accountNr);
        balance = balance - amount;
        String sql = "Update account set balance = :dbBalance WHERE account_number = :dbAccountNr";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("dbAccountNr", accountNr);
        paraMap.put("dbBalance", balance);
        jdbcTemplate.update(sql, paraMap);
        return "Uus kontojääk on " + balance;
    }
/*
    //http://localhosT:8080/transferMoney/EE019/10/EE123
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
}

