package com.pjatk.project.controller;

import com.pjatk.project.model.Account;
import com.pjatk.project.service.AccountService;
import jakarta.xml.bind.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    AccountService accountService;

    @PostMapping()
    public ResponseEntity<Account> createAccount(@RequestBody Account account) throws ValidationException {
        accountService.addAccount(account);
        return ResponseEntity.ok(account);
    }

    @GetMapping()
    public List<Account> getAccountList() throws ValidationException {
        return accountService.getAccountList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Integer id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/balance/{balance}")
    public List<Account> getAccountWhereBalanceIsBiggerThan(@PathVariable Double balance) {
        return accountService.getAccountListByBalanceMoreThan(balance);
    }
}
