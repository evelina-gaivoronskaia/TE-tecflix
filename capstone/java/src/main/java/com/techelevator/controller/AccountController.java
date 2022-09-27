package com.techelevator.controller;

import com.techelevator.dao.AccountDao;
import com.techelevator.model.Account;
import com.techelevator.model.AccountAlreadyExistsException;
import com.techelevator.model.AccountDTO;
import com.techelevator.model.AccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
public class AccountController {

    private AccountDao accountDao;

//    public AccountController(AccountDao accountDao){
//        this.accountDao = accountDao;
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/createProfile", method = RequestMethod.POST)
    public boolean createAccount(@Valid @RequestBody AccountDTO newAccount, Principal principal) {
            int userId = accountDao.findIdByUsername(principal.getName());
            return accountDao.createAccount(userId, newAccount.getFirstName(), newAccount.getLastName(), newAccount.getEmailAddress(), newAccount.getTimeZone(), newAccount.getSubscribedToEmailList());
    }

}
