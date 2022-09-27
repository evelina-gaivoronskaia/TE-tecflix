package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcAccountDao implements AccountDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean createAccount(int userId, String firstName, String lastName, String emailAddress, String timeZone, Boolean isSubscribedToEmailList) {
        String insertAccountSql = "INSERT INTO account (user_id, first_name, last_name, email_address, time_zone, email_list) values (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(insertAccountSql, userId, firstName, lastName, emailAddress, timeZone, isSubscribedToEmailList) == 1;
    }
}
