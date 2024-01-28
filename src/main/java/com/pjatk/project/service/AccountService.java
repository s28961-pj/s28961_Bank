package com.pjatk.project.service;

import com.pjatk.project.model.Account;
import com.pjatk.project.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    public void addAccount(Account account) {
        accountRepository.addAccount(account);
    }

    public Account getAccountById(Integer id) {
        return accountRepository.getAccountById(id);
    }

    public List<Account> getAccountList() {
        return accountRepository.getAccountList();
    }
}
