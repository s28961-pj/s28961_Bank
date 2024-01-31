package com.pjatk.project.controller;

import com.pjatk.project.model.Account;
import com.pjatk.project.service.AccountService;
import jakarta.xml.bind.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) throws ValidationException {
        try {
            Account result = accountService.addAccount(account);
            return ResponseEntity.status(201).body(result);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccountList() throws ValidationException {
        List<Account> accountList = accountService.getAccountList();
        return ResponseEntity.ok(accountList);
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

    // TODO:
    //  - MUST contain API meta information [218]
    //  #/info/title as (unique) identifying, functional descriptive name of the API
    //  #/info/version to distinguish API specifications versions following semantic rules 1.0.0
    //  #/info/description containing a proper description of the API
    //  #/info/contact/{name,url,email} containing the responsible team
    //  /info/x-api-id:   UUID
    //  - GET requests for individual resources will usually generate a 404 (if the resource does not exist).
    //  - GET requests for collection resources may return either 200 (if the collection is empty) or 404 (if the collection is missing).
    //  - POST requests are idiomatically used to create single resources on a collection resource endpoint,
    //  - Successful POST requests return 200 or 204 (if the resource was updated — with or without returning the resource), 201 (if the resource was newly created), and 202 (if the request was accepted for asynchronous processing).
    //  - DELETE requests are usually applied to single resources, not on collection resources, as this would imply deleting the entire collection. Failed DELETE requests will usually generate 404 (if the resource cannot be found) or 410 (if the resource was already traceably deleted before).
    //  - no ambiguity in meaning of the query parameters. For example in GET /items?user_id=gt:100, is user_id greater than 100 or is user_id equal to gt:100?
    //  - More than
    //  min_length=2 — query elements based on upper/lower bounds (min and max)
    //  created_after=2019-07-17 or modified_since=2019-07-17
    //  Using terminology specific to time: before, after, since and until
    //  price_higher_than=50 or price_equal_or_higher_than=50
}
