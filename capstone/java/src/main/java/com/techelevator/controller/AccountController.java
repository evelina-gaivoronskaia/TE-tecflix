package com.techelevator.controller;

import com.techelevator.dao.AccountDao;
import com.techelevator.model.AccountDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class AccountController {

    private AccountDao accountDao;

    public AccountController(AccountDao accountDao){
        this.accountDao = accountDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/createProfile", method = RequestMethod.POST)
    public void createAccount(@Valid @RequestBody AccountDTO newAccount){
        accountDao.createAccount(newAccount.getUserId(), newAccount.getFirstName(), newAccount.getLastName(), newAccount.getEmailAddress(), newAccount.getTimeZone(), newAccount.getSubscribedToEmailList());
    }

}
