package com.techelevator.dao;

import com.techelevator.model.Account;

public interface AccountDao {

    boolean createAccount(int userId, String firstName, String lastName, String emailAddress, String timeZone, Boolean isSubscribedToEmailList);

    Account getAccountByEmailAddress(String emailAddress);

    int findIdByUsername(String username);
}
