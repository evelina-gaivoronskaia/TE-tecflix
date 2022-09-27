package com.techelevator.model;

public class Account {
    private int accountId;
    private int userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String timeZone;
    private Boolean isSubscribedToEmailList;

    public Account() { }

    public Account(int accountId, int userId, String firstName, String lastName, String emailAddress, String timeZone, Boolean isSubscribedToEmailList) {
        this.accountId = accountId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.timeZone = timeZone;
        this.isSubscribedToEmailList = isSubscribedToEmailList;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Boolean getSubscribedToEmailList() {
        return isSubscribedToEmailList;
    }

    public void setSubscribedToEmailList(Boolean subscribedToEmailList) {
        isSubscribedToEmailList = subscribedToEmailList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", isSubscribedToEmailList=" + isSubscribedToEmailList +
                '}';
    }
}
