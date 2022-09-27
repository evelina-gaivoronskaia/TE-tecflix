package com.techelevator.dao;

public interface AccountDao {

    boolean createAccount(int userId, String firstName, String lastName, String emailAddress, String timeZone, Boolean isSubscribedToEmailList);
}
