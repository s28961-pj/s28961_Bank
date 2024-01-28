package com.pjatk.project.controller;

import com.pjatk.project.model.Account;
import com.pjatk.project.service.AccountService;
import jakarta.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        accountService.addAccount(account);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/accounts")
    public List<Account> getAccountList() throws ValidationException {
        return accountService.getAccountList();
    }
    @GetMapping("/accounts/{id}")
    public Account getAccountById(Integer id) {
        return accountService.getAccountById(id);
    }
}
