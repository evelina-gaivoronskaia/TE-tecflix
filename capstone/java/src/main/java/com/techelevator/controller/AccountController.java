package com.techelevator.controller;

import com.techelevator.dao.AccountDao;
import com.techelevator.model.Account;
import com.techelevator.model.AccountAlreadyExistsException;
import com.techelevator.model.AccountDTO;
import com.techelevator.model.AccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class AccountController {

    private AccountDao accountDao;

//    public AccountController(AccountDao accountDao){
//        this.accountDao = accountDao;
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/createProfile", method = RequestMethod.POST)
    public void createAccount(@Valid @RequestBody AccountDTO newAccount) {
        try {
            Account account = accountDao.getAccountByEmailAddress(newAccount.getEmailAddress());
            throw new AccountAlreadyExistsException();
        } catch (AccountNotFoundException e){
            accountDao.createAccount(newAccount.getUserId(), newAccount.getFirstName(), newAccount.getLastName(), newAccount.getEmailAddress(), newAccount.getTimeZone(), newAccount.getSubscribedToEmailList());
        }
    }

}
