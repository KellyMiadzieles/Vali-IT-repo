package ee.bcs.valiit.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class BankAccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String firstName, String lastName, String accountNr, Double balance) {
        String sql = "INSERT INTO account (id, first_name, last_name, account_number, balance) VALUES (:dbId,:dbFirstName,:dbLastName, :dbAccountNr, :dbAmount)";
        Map<String, Object> paramMap = new HashMap<>();
        Integer id = ThreadLocalRandom.current().nextInt(1, 1000 + 1); //annab ise automaatselt id numbri
        paramMap.put("dbId", id); //salvestab mapi id numbri
        paramMap.put("dbFirstName", firstName);
        paramMap.put("dbLastName", lastName);
        paramMap.put("dbAccountNr", accountNr);
        paramMap.put("dbAmount", balance);
        jdbcTemplate.update(sql, paramMap);
    }

    public Double getBalance(String accountNr) {
        String sql = "SELECT balance FROM account where account_number = :dbAccountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccountNr", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, Double.class); //SELECTI puhul on queryfor object
    }

    public String updateBalance(String accountNr, Double amount) {
        String sql = "UPDATE account SET balance = :dbBalance WHERE account_number = :dbAccountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccountNr", accountNr);
        paramMap.put("dbBalance", amount);
        Integer result = jdbcTemplate.update(sql, paramMap);
        return result.toString();
    }

}
