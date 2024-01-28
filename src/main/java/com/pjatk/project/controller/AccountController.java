package com.pjatk.project.controller;

import com.pjatk.project.model.Account;
import com.pjatk.project.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        accountService.addAccount(account);
        return ResponseEntity.ok(account);
    }
}
