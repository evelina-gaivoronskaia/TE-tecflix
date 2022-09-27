package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class AccountDTO {
    private int userId;
    private String firstName;
    private String lastName;
    @NotEmpty
    private String emailAddress;
    private String timeZone;
    private Boolean isSubscribedToEmailList;

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
        this.isSubscribedToEmailList = subscribedToEmailList;
    }


}
