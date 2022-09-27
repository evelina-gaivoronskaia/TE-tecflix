package com.techelevator.dao;

import com.techelevator.model.Account;
import com.techelevator.model.AccountNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcAccountDao implements AccountDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean createAccount(int userId, String firstName, String lastName, String emailAddress, String timeZone, Boolean isSubscribedToEmailList) {
        String insertAccountSql = "INSERT INTO account (user_id, first_name, last_name, email_address, time_zone, email_list) values (?,?,?,?,?,?)";
        return jdbcTemplate.update(insertAccountSql, userId, firstName, lastName, emailAddress, timeZone, isSubscribedToEmailList) == 1;
    }

    @Override
    public Account getAccountByEmailAddress(String emailAddress) {
        String sql = "SELECT * FROM account WHERE email_address ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, emailAddress);
        if(results.next()){
            return mapRowToAccount(results);
        } else {
            throw new AccountNotFoundException();
        }
    }

    @Override
    public int findIdByUsername(String username) {
        String sqlForId = "SELECT user_id FROM users WHERE username ILIKE ?;";
        Integer userId = jdbcTemplate.queryForObject(sqlForId, Integer.class, username);
        if(userId != null){
            return userId;
        } else{
            return -1;
        }
    }

    private Account mapRowToAccount(SqlRowSet rs){
        Account account = new Account();
        account.setUserId(rs.getInt("user_id"));
        account.setFirstName(rs.getString("first_name"));
        account.setLastName(rs.getString("last_name"));
        account.setEmailAddress(rs.getString("email_address"));
        account.setTimeZone(rs.getString("time_zone"));
        account.setSubscribedToEmailList(rs.getBoolean("email_list"));
        return account;
    }
}
