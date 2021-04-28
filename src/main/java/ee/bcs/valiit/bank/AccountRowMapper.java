package ee.bcs.valiit.bank;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<BankAccountDTO> {

    @Override
    public BankAccountDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        BankAccountDTO result = new BankAccountDTO();
        result.setBalance(resultSet.getDouble("balance"));
        result.setAccountNumber(resultSet.getString("account_number"));
        return result;
    }
}
