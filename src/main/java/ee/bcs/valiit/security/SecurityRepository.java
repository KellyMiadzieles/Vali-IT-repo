package ee.bcs.valiit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class SecurityRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public String getPasswordByUsername(String username) {
        String sql = "SELECT password FROM all_users WHERE username =:dbUsername";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbUsername", username);
        String password = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return password;
    }

    public void createUser(String username, String password) {
        String sql = "INSERT INTO all_users (username, password) VALUES (:dbUsername,:dbPassword)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbUsername", username);
        paramMap.put("dbPassword", password);
        jdbcTemplate.update(sql, paramMap);
    }

    public boolean doesUserExists(String username) {
        String sql = "SELECT count(*) FROM all_users WHERE username = :dbUsername";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("dbUsername", username);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class) > 0;
    }
}
